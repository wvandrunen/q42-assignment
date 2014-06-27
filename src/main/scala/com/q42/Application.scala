package com.q42

object Application {

  def main(args: Array[String]): Unit = {

    val numbers: List[Int] = List[Int](2, 4, 8, 16, 32)
    val operators = List[String]("-", "*", "+", "/")

    println()
    println("=======================")
    println("Starting Q42 Assignment")
    println("=======================")

    println("Numbers used    : " + numbers)
    println("Operators used  : " + operators);

    val calculator = new SolutionCalculator(new ReversedPolishNotatedFormula, new SolutionGenerator(numbers, operators))
    val solutions = calculator.calculateSolutions()

    println("Solutions found : " + solutions.size)
    println("")
    println("Printing all solutions...")
    solutions.foreach(println)
  }
}