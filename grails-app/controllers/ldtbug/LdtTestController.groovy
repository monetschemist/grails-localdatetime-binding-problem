package ldtbug

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LdtTestController {

    LdtTestService ldtTestService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ldtTestService.list(params), model:[ldtTestCount: ldtTestService.count()]
    }

    def show(Long id) {
        respond ldtTestService.get(id)
    }

    def create() {
        respond new LdtTest(params)
    }

    def save(LdtTest ldtTest) {
        if (ldtTest == null) {
            notFound()
            return
        }

		println "params $params ldtTest.dateTime ${ldtTest.dateTime}"

        try {
            ldtTestService.save(ldtTest)
        } catch (ValidationException e) {
			println "ldtTest.errors ${ldtTest.errors}"
            respond ldtTest.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ldtTest.label', default: 'LdtTest'), ldtTest.id])
                redirect ldtTest
            }
            '*' { respond ldtTest, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ldtTestService.get(id)
    }

    def update(LdtTest ldtTest) {
        if (ldtTest == null) {
            notFound()
            return
        }

        try {
            ldtTestService.save(ldtTest)
        } catch (ValidationException e) {
            respond ldtTest.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ldtTest.label', default: 'LdtTest'), ldtTest.id])
                redirect ldtTest
            }
            '*'{ respond ldtTest, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ldtTestService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ldtTest.label', default: 'LdtTest'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ldtTest.label', default: 'LdtTest'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
