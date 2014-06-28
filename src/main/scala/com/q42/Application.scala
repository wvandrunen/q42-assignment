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
    val solutionPrinter = new SolutionPrinter

    println("Solutions found : " + solutions.size)
    println("")
    println("Printing all solutions...")
    solutions.foreach(x => println(solutionPrinter.print(x)))
  }


}
