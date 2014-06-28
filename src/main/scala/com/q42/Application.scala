package com.q42

object Application {

  def main(args: Array[String]): Unit = {

    // scalastyle:off magic.number
    val numbers = List(2,4,8,16,32)
    // scalastyle:on magic.number

    val operators = List("*", "+", "-", "/")

    val solutionGenerator = new SolutionGenerator(numbers, operators)

    println()
    println("=======================")
    println("Starting Q42 Assignment")
    println("=======================")

    println("Numbers used    : " + numbers)
    println("Operators used  : " + operators)

    val calculator = new SolutionCalculator(new ReversedPolishNotatedFormula, solutionGenerator)
    val solutions = calculator.calculateSolutions()

    println("Solutions found : " + solutions.size)
    println("")
    println("Printing all solutions...")
    solutions.foreach(x => println(solutionPrinter(x)))
  }

  def solutionPrinter(solution: (List[String], Int)): String = {
    val (calculation: List[String], ans: Int) = solution

    val firstItem = calculation(0)
    val rest = calculation.drop(1)
    val slides = rest.sliding(2, 2)

    val normalOrder = List(firstItem) ++ slides.flatMap(x => x.reverse)

    normalOrder.mkString(" ") + " = " + ans;
  }
}
