/**
  * Created by Hari Rao on 25/02/17.
  */
object TypeInference  extends App {

   var firstScalaClass = new FirstScalaClass

    println(firstScalaClass.add(1,2))

    println(firstScalaClass.fib(4))

    println(firstScalaClass.monthName(2))

    println(firstScalaClass.monthName(12))

    println(firstScalaClass.daysInMonth(12))

    println(firstScalaClass.whatIsIt(List("Hari","Rao")))

    println(firstScalaClass.variableBindingPattern(1))

    println(firstScalaClass.whatIsItVariableBindingPattern(List(1,2,3)))

   var exceptionPracs = new ExceptionPracs

    println(exceptionPracs.parseInt("12"))

    println(exceptionPracs.parseIntWithOption("hello"))

   var forComprehensions = new ForComprehensions

    println(forComprehensions.simpleForComp(List(2,3,6)))

    println(forComprehensions.forCompWithBraces())

    println(forComprehensions.forCompWithGuard())
}
