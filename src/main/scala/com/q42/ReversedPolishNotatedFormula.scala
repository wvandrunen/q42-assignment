package com.q42

class ReversedPolishNotatedFormula {
  
  /***
    * Executes the calculation of a given List which contains a calculation in Reverse Polish Notation
    *
    * Example:
    *
    * Input (4, 5, +, 9, -)
    * Path / Output (4, 5, +, 9, -) becomes (9, 9, -) becomes 0 (is returned)
    * @param calculationInPolishNotation the calculation
    * @return the result of the calculation
    */
  def calculate(calculationInPolishNotation: List[String]) : Int = {

    if(!valid(calculationInPolishNotation)) {
      0
    }

    val firstDigit: String = calculationInPolishNotation(0)
    val secondDigit: String = calculationInPolishNotation(1)
    val operand: String = calculationInPolishNotation(2)
    val rest: List[String] = calculationInPolishNotation.drop(3)

    val ans = operand match {
      case "-" => firstDigit.toInt - secondDigit.toInt
      case "+" => firstDigit.toInt + secondDigit.toInt
      case "/" => firstDigit.toInt / secondDigit.toInt
      case "*" => firstDigit.toInt * secondDigit.toInt
    }

    rest match {
      case List() => ans.toInt
      case _ => calculate(List(ans.toString) ++ rest)
    }
  }

  def valid(calculation: List[String]): Boolean = {


    val firstItem = calculation(0)

    // first rule -> first digit should be a digit
    if(!firstItem.forall(_.isDigit)) false

    val rest = calculation.drop(1)

    val slides = rest.sliding(2)

    slides.foreach(println)

    true
  }

}
