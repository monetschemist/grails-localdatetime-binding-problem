package ldtbug

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class LdtTestSpec extends Specification implements DomainUnitTest<LdtTest> {

     void "test domain constraints"() {
        when:
        LdtTest domain = new LdtTest()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
