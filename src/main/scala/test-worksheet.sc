import com.q42.{SolutionGenerator, ReversedPolishNotatedFormula, SolutionCalculator}

val numbers: List[Int] = List[Int](2, 4, 8, 16, 32)
val operators = List[String]("-", "*", "+", "/")

val calculator = new SolutionCalculator(new ReversedPolishNotatedFormula, new SolutionGenerator(numbers, operators))
val solutions = calculator.calculateSolutions()

solutions.foreach(println)





















































































/*
def calcer(number: Int, answer: Int): List[Int] = {
  val nextNumber = number * 2
  for(op <- operators) yield {
    op match {
      case "-" => answer - nextNumber
      case "+" => answer + nextNumber
      case "*" => answer * nextNumber
      case "/" => answer / nextNumber
    }
  }
}
val ans = calcer(2, 2)
def calcAll(numbers: List[Int], answers: List[Int]): List[Int] = {
  numbers match {
    case List() => answers
    case head :: tail => calcAll(tail, answers ::: (for (a <- ans) yield calcer(head, a)).flatten)
  }
}
calcAll(List(4, 8, 16, 32), ans)
val r = addInt(2, List(Stack()))
*/
/*
def calc (numbers: List[Int], ans: Int) : Int = {
  numbers match {
    case a :: b :: tail => {
      val newList = (a + b) :: tail
      calc(newList)
    }
    case _ => newList(0)
  }
}*/
//calc(numbers, 0)
// combinations.groupBy({ case (n, o) => n })
/*
def combineNumbersWithOperators(numbers: List[Int], operators: List[String]) : List[Object] = {
  for (
    number <- numbers;
    operator <- operators
  ) yield (number, operator)
}
def addOperator(s: Stack[Any], ops: List[String]): List[Stack[Any]] = {
  for(op <- ops) yield s :+ op
}
def addInt(number: Int, ss: List[Stack[Any]]): List[Stack[Any]] = {
  number match {
    case 64 => ss
    case 32 => for (s <- ss) yield s :+ 32
    case _ => {
      val updatedStack = (for ( s <- ss ) yield addOperator(s :+ number, operators)).flatten

      addInt(number * 2, updatedStack)
    }
  }
}

*/
