package com.q42

class SolutionPrinter {

  def print(solution: (List[String], Int)): String = {
    val (calculation: List[String], ans: Int) = solution

    val firstItem = calculation(0)
    val rest = calculation.drop(1)
    val slides = rest.sliding(2, 2)

    val normalOrder = List(firstItem) ++ slides.flatMap(x => x.reverse)

    normalOrder.mkString(" ") + " = " + ans
  }

}
