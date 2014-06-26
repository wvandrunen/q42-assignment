package com.q42

/**
 * Returns a list of possible calculations when given a list of numbers and operators.
 *
 * The list of possible calculations are in Reverse Polish Notation (http://en.wikipedia.org/wiki/Reverse_Polish_notation).
 * The Reversed Polish Notation is used to make the execution of the calculation more easy.
 *
 * Example:
 *
 * Input
 * Numbers: (0, 1, 2) Operators: ("-", "*", "+", "/")
 *
 * Output
 * (0, 1, +, 2, +)
 * (0, 1, -, 2, +)
 * (0, 1, *, 2, +)
 * (0, 1, /, 2, +)
 * (0, 1, +, 2, -)
 * (0, 1, -, 2, -)
 * (0, 1, *, 2, -)
 * (0, 1, /, 2, -)
 * (0, 1, +, 2, *)
 * (0, 1, -, 2, *)
 * (0, 1, *, 2, *)
 * (0, 1, /, 2, *)
 * (0, 1, +, 2, /)
 * (0, 1, -, 2, /)
 * (0, 1, *, 2, /)
 * (0, 1, /, 2, /)
 */
class SolutionGenerator(numbers: List[Int], operators: List[String]) {

  def generateAllSolutions(): List[List[String]] = {
    generateNumberCombinations().flatMap(x => buildPossibleCalculationsInPolishNotation(x, List()))
  }

  /**
   * Mixes a number combination with all possible operator combinations
   *
   * @param numbersCombination a combination of numbers
   * @param calculationsAccumulator a accumulator that is used to store the results so far
   * @return a list of possible calculations with all the operators
   */
  private def buildPossibleCalculationsInPolishNotation(numbersCombination: List[Int], calculationsAccumulator : List[List[String]]) : List[List[String]] = {

    def addNextNumberAndOperators(number: Int): List[List[String]] = {
      for (calculation <- calculationsAccumulator; operator <- operators) yield calculation :+ number.toString :+ operator
    }

    numbersCombination match {
      case List() => calculationsAccumulator
      case number :: rest =>
        calculationsAccumulator match {
          // Empty accumulator means we are dealing with the first number.
          // Put this on the list to make the polish notation work.
          case List() => buildPossibleCalculationsInPolishNotation(rest, List(List(number.toString)))
          // Otherwise add the number with all the operators
          case _ => buildPossibleCalculationsInPolishNotation(rest, addNextNumberAndOperators(number))
        }
    }
  }

  /**
   * Generates a list of all possible combinations of a list of numbers with every number used only once.
   *
   * Example:
   *
   * Input:
   * (0, 1, 2)
   *
   * Output:
   * (0, 1, 2)
   * (1, 0, 2)
   * (2, 0, 1)
   * (0, 2, 1)
   * (1, 2, 0)
   * (2, 1, 0)
   *
   * @return a list of possible combinations
   */
  def generateNumberCombinations(): List[List[Int]] = {
    val combinations = for (n1 <- numbers; n2 <- numbers; n3 <- numbers; n4 <- numbers; n5 <- numbers) yield List(n1, n2, n3, n4, n5)

    combinations.filter(x => x.distinct.length == x.length)
  }

}
