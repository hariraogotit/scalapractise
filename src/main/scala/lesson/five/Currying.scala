package lesson.five

/**
  * Created by Hari Rao on 05/03/17.
  */
object Currying {

  def exampleOfCurrying(): Unit ={
    /**
      * Usual function
      */
    val plus = {(a: Int, b: Int) => a * b}

    /**
      * 1. Curried equivalent of above
      * 2. A Curried function or method always take only one argument
      * 3. Below the CurriedPlus takes one argument of type Int which gives a function that adds the values
      *
      * Below can be called as follows
      * 1. val plusOne = plus(1)
      * 2. plusOne(1).. This will result in 1 + 1 = 2
      * 3. Or currying can be called as plus(1)(1) which results to 2.
      * 4. General use of currying in Scala is to assist in type inference (and Implicits which will be talked
      *    in later lessons ) i.e consider the methods in package object five
      *     map, filter and foldLeft. When we call map(List(1,2,3), {_ + 1}) Scala cannot work out the type of the second
      *     parameter - {_+1}. In order for scala to work out the type the methods signature can be changed to the following
      *     as per the currying def map[A, B](list : List[A] )( fn : A => B ) : List[B],
      *     def filter[A](list: List[A]) (fn: A => Boolean): List[A] and
      *     def foldLeft[A, B](list: List[A] acc : B) (fn: (A,B) => B ): B. How ever a curried function always takes one parameter
      *     so don't know how foldLeft above obeys to currying.
      */
    val curriedPlus = {a:Int => {b: Int => a + b} }
  }

}
