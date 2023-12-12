package ldtbug

import grails.gorm.services.Service

@Service(LdtTest)
interface LdtTestService {

    LdtTest get(Serializable id)

    List<LdtTest> list(Map args)

    Long count()

    void delete(Serializable id)

    LdtTest save(LdtTest ldtTest)

}