package com.q42

import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class SolutionGeneratorTest extends FunSuite {

  test("check if correct solutions are generated when given (0,1) and (-, +)") {
    val sg = new SolutionGenerator(
                                    List(2, 4),
                                    List("-", "+")
                                  )

    val expected = List(
                    List("2", "4", "-"),
                    List("2", "4", "+"),
                    List("4", "2", "+"),
                    List("4", "2", "-")
                    )

    val result = sg.generateAllSolutions()

    assert(expected.forall(x => result.contains(x)))
  }

  test("return no combinations when operator list is empty") {
    val sg = new SolutionGenerator(List(2, 4), List())

    val solutions = sg.generateAllSolutions()

    assert(solutions.isEmpty)
  }

  test("return no combinations when number list is empty") {
    val sg = new SolutionGenerator(List(), List("-", "*"))

    val solutions = sg.generateAllSolutions()

    assert(solutions.isEmpty)
  }

  test("throw exception when unsupported operator is used") {
    intercept[IllegalArgumentException] {
      new SolutionGenerator(List(), List("^"))
    }
  }

}
