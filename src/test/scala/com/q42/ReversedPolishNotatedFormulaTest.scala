package com.q42

import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ReversedPolishNotatedFormulaTest extends FunSuite {

  val formulaCalculator = new ReversedPolishNotatedFormula

  test("(4, 5, +, 9, -) should become 0") {
    val formula = List("4", "5", "+", "9", "-")

    assert(formulaCalculator.validateAndCalculate(formula) === 0)
  }

  test("(2, 5, *, 16, *, 32, /) should become 5") {
    val formula = List("2", "5", "*", "16", "*", "32", "/")

    assert(formulaCalculator.validateAndCalculate(formula) === 5)
  }

  test("(2, 6, *, *, 32, /) is invalid and exception should be thrown") {
    val formula = List("2", "5", "*", "*", "32", "/")

    intercept[IllegalArgumentException] {
      formulaCalculator.validateAndCalculate(formula)
    }
  }
}

