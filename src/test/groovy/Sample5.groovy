import spock.lang.Specification
import spock.lang.Unroll

class Sample5WhereSpockRulesSpec extends Specification {

  def "maximum of two numbers"() {
    expect:
      Math.max(a, b) == max

    where:
      a | b | max
      1 | 3 | 3
      7 | 4 | 7
      0 | 0 | 0
  }

  @Unroll()
  def "maximum of two numbers with default unrolling"() {
    expect:
    Math.max(a, b) == max

    where:
      a | b || max
      1 | 3 || 3
      7 | 4 || 7
      0 | 0 || 0
  }

  @Unroll("max from #a and #b should be #max")
  def "maximum of two numbers with readable unrolling"() {
    expect:
    Math.max(a, b) == max

    where:
    a | b || max
    1 | 3 || 3
    7 | 4 || 7
    0 | 0 || 0
  }

  static List<String> staticList = ['This', 'is', 'a', 'list']

  @Unroll("list contains word: #word")
  def "parameters from static list"() {
    expect:
      ['This', 'is', 'a', 'list'].contains(word)
    where:
      word << staticList
  }

  def "data pipes" () {
    expect: "adding a #number to 5 gives #sum"
      5 + number == sum
    where:
      number << [4, 1, 7, 0, -2]
      sum << [9, 6, 12, 5, 3]
  }
}