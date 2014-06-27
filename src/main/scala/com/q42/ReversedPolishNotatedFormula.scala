package com.q42

class ReversedPolishNotatedFormula {

  val supportedOperators = List("*", "+", "-", "/")

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

  def validateAndCalculate(calculationInPolishNotation: List[String]) : Int = {
    valid(calculationInPolishNotation) match {
      case true  => calculate(calculationInPolishNotation)
      case false => throw new IllegalArgumentException
    }
  }

  private def calculate(calculationInPolishNotation: List[String]) : Int = {

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
    val rest = calculation.drop(1)
    val slides = rest.sliding(2, 2)

    // first rule -> first digit should be a digit
    if(!firstItem.forall(_.isDigit)) false

    // second rule -> the rest should be pairs of digits and supported operators so let slice in part of twos
    slides.forall( { case List(x, y) => { x.forall(_.isDigit) && supportedOperators.contains(y) } } )
  }

}
