package com.q42

/**
 * This class ties everything together. It first generates a list of all possible solutions with the use of the
 * solutionGenerator.
 *
 * Then it calculates every outcome and check if it's the correct answer (11) with the use of the pnFormula
 *
 * @param pnFormula the reversed polish notation formula calcultaro
 * @param solutionGenerator the generator which generates all possible solutions
 */
class SolutionCalculator(pnFormula: ReversedPolishNotatedFormula, solutionGenerator: SolutionGenerator) {

  val correctAnswer = 11

  def calculateSolutions(): List[(List[String], Int)] = {
    determineSolutionsThatAreEleven(solutionGenerator.generateAllSolutions())
  }

  private def determineSolutionsThatAreEleven(solutions: List[List[String]]): List[(List[String], Int)] = {
    solutions.map( s => (s, pnFormula.calculate(s)) ).filter( {case (_, ans) => ans == correctAnswer })
  }
}
