package lesson.five

/**
  * Created by Hari Rao on 04/03/17.
  * Type Refinements in scala is similar to Anonymous classes in Java
  */
object TypeRefinements {

  /**
    * 1. Below is the Type refinement. So the function is an object
    * 2. Since the function is an object it can be passed in as a parameter.
    * 3. Hence these functions are called higher order function
    * 4. Below can be called as function literal
    */
  val timesTwoFunction = { a:Int => a * 2 }

  /**
    *
    * @param a
    * @return
    *  Below is a method which does exactly what the above function does but the
    *  below method cannot be passed in as a parameter since it needs a class or object to
    *  refer it.
    */
  def timesTwoMethod(a: Int) = a * 2


}

/**
  * 1. Below we are extending the Function1 Interface that takes Int as input type and
  *    produces output of type Int
  * 2. apply is the abstract method in Function1 that needs to be overridden.
  * 3. Below can called timesTwo.apply(1) or timesTwo(1)
  * 4. But the below has many boiler plate code.
  */
object timesTwo extends Function1[Int,Int] {
  def apply(a:Int): Int= a* 2
}

/**
  * 1. Below is an improved version of the above as it removes most of the boiler plate code
  * 2. val timesTwoFunction = { a:Int => a * 2 } above is final version which is live Java's lambda function.
  */
object timesTwoAnonymous{
  val timesTow = new Function1[Int,Int]  {
    def apply(a:Int): Int= a* 2
  }

}
