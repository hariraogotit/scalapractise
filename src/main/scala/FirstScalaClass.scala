/**
  * Created by Hari Rao on 25/02/17.
  */
class FirstScalaClass {

  /**
    *
    * @param a
    * @param b
    * @return
    *    All the method paramters in scala should have type declared. Example in the below method if the type is not
    *    specified in the paramter then Scala cannot work out on its own as '+' operation can be done on Sting, Int, Double etc
    *    so it cannot decide which one we are aiming.
    */
  def add(a: Int, b: Int) : Int = a + b

  /**
    *
    * @param n
    * @return
    *     For recursive methods the return type should be specified because for Scala to work out the return type it
    *     scans through the method. In recursion when it scans it will see that fib method calls it self.
    */
  def fib(n: Int) : Int = if(n==0 || n==1) 1 else fib(n-1) + fib(n-2)

  def monthName(n: Int): String = n match{
    case 1 => "Jan"
    case 2 => "Feb"
    case _ => "Unknown"
  }

  def daysInMonth(n: Int): Int = n match {
    case 1 | 3 | 5 | 7 | 8| 10 | 12 => 31
    case 4 | 6 | 9 | 11 => 30
    case 2 => 28
  }

  def whatIsIt(something: Any) :String = something match {
    case 1 => "No one"
    case "hello" => "A greeting"
    case List(_,_,_) => "List containing three parameters"
    case List(_,_) => "List containing two parameters"
  }

  /**
    *
    * @param something
    * @return
    * Variable binding pattern :- We are binding a variable to the matched value. As you see the variables
    * have a type eg n is of type Int
    */
  def variableBindingPattern(something: Any) : String = something match {
    case n: Int => "The number " + n
    case s: String => "This is String " + s
    case _ => "Something else"
  }

  def whatIsItVariableBindingPattern(something: Any) :String = something match {
    case List(a,b,c) => "List containing three parameters " + a + b + c
    case _ => "Default"
  }

}
