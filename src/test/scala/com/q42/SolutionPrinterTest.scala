package com.q42

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class SolutionPrinterTest extends FunSuite {

  test("should print solution in readable format") {
    val sol = (List("2", "4", "*", "16", "/", "32", "-"), 11)

    val solutionPrinter = new SolutionPrinter

    val result = solutionPrinter.print(sol);

    assert(result == "2 * 4 / 16 - 32 = 11")
  }

}

