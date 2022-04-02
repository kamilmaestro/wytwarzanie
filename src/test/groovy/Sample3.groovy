import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class Sample3ReadableErrorsSpec extends Specification {

  def "should have readable error messages"() {
    expect:
    'super' == 'superReadable'
  }

  def "should help you debug all the way down"() {
    given:
    Map<String, Map<String, String>> countries = [Poland: [capital: 'Warsaw'], Germany: [capital: 'Berlin']]
    expect:
    countries.Poland.capital == 'Ber'
  }

}