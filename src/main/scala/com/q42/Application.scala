package com.q42

object Application {

  def main(args: Array[String]): Unit = {

    val solutionGeneratorFactory = SolutionGeneratorFactory

    println()
    println("=======================")
    println("Starting Q42 Assignment")
    println("=======================")

    println("Numbers used    : " + solutionGeneratorFactory.numbers)
    println("Operators used  : " + solutionGeneratorFactory.operators)

    val calculator = new SolutionCalculator(new ReversedPolishNotatedFormula, solutionGeneratorFactory.create)
    val solutions = calculator.calculateSolutions()

    println("Solutions found : " + solutions.size)
    println("")
    println("Printing all solutions...")
    solutions.foreach(println)
  }
}