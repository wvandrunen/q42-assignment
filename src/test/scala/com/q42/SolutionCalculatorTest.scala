package com.q42

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalamock.scalatest.MockFactory


@RunWith(classOf[JUnitRunner])
class SolutionCalculatorTest extends FunSuite with MockFactory {

  test("Integration test for solution calculator should calculate correct solution") {
    val pnFormula = mock[ReversedPolishNotatedFormula]
    val solutionGenerator = mock[SolutionGenerator]

    val sol1 = List("32", "16", "+", "4", "-", "2", "*", "8", "/")
    val sol2 = List("16", "16", "+", "4", "-", "2", "*", "8", "/")

    val generatedSolutions = List(sol1, sol2)

    (solutionGenerator.generateAllSolutions _).expects().returning(generatedSolutions)
    (pnFormula.validateAndCalculate _).expects(sol1).returning(11).repeat(1)
    (pnFormula.validateAndCalculate _).expects(sol2).returning(7).repeat(1)

    val solutionCalculator = new SolutionCalculator(pnFormula, solutionGenerator)

    val result = solutionCalculator.calculateSolutions()

    println(result)

    assert(result.forall( {case (sol, ans) => sol == sol1 } ))
  }

}
