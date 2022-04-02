import spock.lang.Ignore
import spock.lang.Specification

class Sample1AnatomyOfSpockSpec extends Specification {
  BigDecimal price = new BigDecimal(200)
  String productName = "Sanity injectors"

  def "should be readable"() {
    given:
      Transaction transaction = new Transaction(productName, price)
    when:
      transaction.perform()
    then:
      transaction.status == TransactionStatus.SUCCESSFUL
  }

  def "should be very short with expect"() {
    expect:
      "XYZ is awesome!".contains("XYZ")
  }

  def "should have nice asserts built-in in groovy"() {
    given:
      List<String> topics = ['Awaitility', 'Spock', 'Guice', 'JUnitParams', 'Fest Assert', 'Geb']

    expect:
      topics.contains('Spock')
      topics.find { it == 'Spock' }
  }

  def "exception handling should be... handled"() {
    when:
      throw new IllegalArgumentException('xyz')
    then:
      thrown(IllegalArgumentException)
  }

  @Ignore
  def "will it pass if exception is thrown in given?"() {
    given:
      throw new IllegalArgumentException('xyz')
    when:
      true
    then:
      thrown(IllegalArgumentException)
  }

}
