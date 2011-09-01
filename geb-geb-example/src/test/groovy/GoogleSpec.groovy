import spock.lang.*
import geb.*
import geb.spock.*

class GoogleSpec extends GebReportingSpec {
		
	def "the first link should be wikipedia"() {
		def fpath="output/${new Date().format('yyyyMMdd_HHmm')}"

		when:
		to GoogleHomePage
		
		and:
		search.forTerm "wikipedia"

		then:
		at GoogleResultsPage
		CaptureUtil.capture(fpath)

		and:
		firstResultLink.text() == "Wikipedia"

		when:
		firstResultLink.click()

		then:
		waitFor { at WikipediaPage }
		CaptureUtil.capture(fpath)
	}
	
}