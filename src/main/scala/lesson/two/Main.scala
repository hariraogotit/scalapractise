package lesson.two

/**
  * Created by Hari Rao on 25/02/17.
  */
object Main  extends App {

 parseTheFirstClassCreated()

 parseException()

 parseForComprehensions()

 parseExpression()

 private def parseForComprehensions() = {
  var forComprehensions = new ForComprehensions

  println(forComprehensions.simpleForComp(List(2, 3, 6)))

  println(forComprehensions.forCompWithBraces())

  println(forComprehensions.forCompWithGuard())
 }

 private def parseTheFirstClassCreated() = {
  var firstScalaClass = new FirstScalaClass

  println(firstScalaClass.add(1, 2))

  println(firstScalaClass.fib(4))

  println(firstScalaClass.monthName(2))

  println(firstScalaClass.monthName(12))

  println(firstScalaClass.daysInMonth(12))

  println(firstScalaClass.whatIsIt(List("Hari", "Rao")))

  println(firstScalaClass.variableBindingPattern(1))

  println(firstScalaClass.whatIsItVariableBindingPattern(List(1, 2, 3)))
 }

 private def parseException() = {
  var exceptionPracs = new ExceptionPracs

  println(exceptionPracs.parseInt("12"))

  println(exceptionPracs.parseIntWithOption("hello"))
 }

 private def parseExpression() = {
   var calculator = new Calculator

   calculator.parsePostFix("1 2 + 3 4 5 - - * 6 7 8 - * /")
 }

}
