package lesson.five

/**
  * Created by Hari Rao on 04/03/17.
  */
class FunctionLiteral {


  val timesTwo = {(a:Int, b:Int) => a * b}

  /**
    * 1. Below says timesTwoTypeInference is a function which takes two Int types and returns a Int type.
    * 2. If you enter the above val timesTwo = {(a:Int, b:Int) => a * b} and press enter in scala console
    *    you will get timesTwo: (Int,Int) => Int = <function2>. So it says timesTwo is a function which
    *    takes two Int types and returns a Int type
    * 3. Based on scala console's reply the following syntax is constructed i.e timesTwoTypeInference
    *    is a function that takes two input Int types and returns one output of type Int.
    */
  val timesTwoTypeInference: (Int, Int) => Int = { _ * _}

  /**
    * 1. The type inference will not work if you try val times = {_ * _}
    * 2. So below is used to tell the type but the below is not recommended as the readability is pretty poor
    */
  val timesTwoShortHand = {(_:Int) * (_:Int)}

}
