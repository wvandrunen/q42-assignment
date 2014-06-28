package com.q42

object Application {

  def main(args: Array[String]): Unit = {

    val numbers: List[Int] = List(2,4,8,16,32)
    val operators: List[String] = List("*", "+", "-", "/")

    val solutionGenerator = new SolutionGenerator(numbers, operators)

    println()
    println("=======================")
    println("Starting Q42 Assignment")
    println("=======================")

    println("Numbers used    : " + solutionGenerator)
    println("Operators used  : " + solutionGenerator)

    val calculator = new SolutionCalculator(new ReversedPolishNotatedFormula, solutionGenerator)
    val solutions = calculator.calculateSolutions()

    println("Solutions found : " + solutions.size)
    println("")
    println("Printing all solutions...")
    solutions.foreach(println)
  }
}