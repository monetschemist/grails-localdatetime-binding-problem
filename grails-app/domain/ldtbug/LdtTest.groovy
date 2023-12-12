package ldtbug

import java.time.LocalDateTime

import grails.databinding.BindUsing

class LdtTest {

	@BindUsing({obj, source ->
		LocalDateTime.parse(source['dateTime'])
	})
	LocalDateTime dateTime

	static constraints = {
		dateTime nullable: false
	}

	String toString() {
		dateTime
	}
}
