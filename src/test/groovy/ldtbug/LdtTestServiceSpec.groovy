package ldtbug

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LdtTestServiceSpec extends Specification {

    LdtTestService ldtTestService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new LdtTest(...).save(flush: true, failOnError: true)
        //new LdtTest(...).save(flush: true, failOnError: true)
        //LdtTest ldtTest = new LdtTest(...).save(flush: true, failOnError: true)
        //new LdtTest(...).save(flush: true, failOnError: true)
        //new LdtTest(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ldtTest.id
    }

    void "test get"() {
        setupData()

        expect:
        ldtTestService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<LdtTest> ldtTestList = ldtTestService.list(max: 2, offset: 2)

        then:
        ldtTestList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ldtTestService.count() == 5
    }

    void "test delete"() {
        Long ldtTestId = setupData()

        expect:
        ldtTestService.count() == 5

        when:
        ldtTestService.delete(ldtTestId)
        sessionFactory.currentSession.flush()

        then:
        ldtTestService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        LdtTest ldtTest = new LdtTest()
        ldtTestService.save(ldtTest)

        then:
        ldtTest.id != null
    }
}
