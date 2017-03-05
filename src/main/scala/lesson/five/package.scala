package lesson

/**
  * Created by Hari Rao on 05/03/17.
  * Below methods map, foldLeft and filter are common methods that are available in all the scala's
  * collection plus some more useful methods so we do not have to implement the following. The below is
  * just for understanding
  */
package object five {

  /**
    *
    * @param list
    * @param fn
    * @tparam A
    * @tparam B
    * @return
    *  1. Below is a transformation which takes the given List and applies the given function
    *  2. So as you see the simple function fn : A => B which is supposed to work on elements gets promoted
    *     as it works on elements of List. This is one of the feature of higher order functions (functions that are
    *     passed as arguments)
    *  3. We always transform the data in the real world. Example we query DB which gives a DB object that needs to be
    *     transformed to a collection of domain objects then we might need to transform these to a XML or JSON object
    */
  def map[A, B](list : List[A] , fn : A => B ) : List[B] = list match {
    case head :: tail => fn(head) :: map(tail, fn)
    case _ => Nil
  }

  /**
    *
    * @param list
    * @param fn
    * @tparam A
    * @return
    *  Below is used for filtering the given data based on the function
    */

  def filter[A](list: List[A], fn: A => Boolean): List[A] = list match {
    case head :: tail =>
      val rest = filter(tail,fn)
      if(fn(head))
           head :: rest
      else
        rest
    case _ => Nil
  }

  /**
    *
    * @param list
    * @param acc
    * @param fn
    * @tparam A
    * @tparam B
    * @return
    *   Below method sums the values of the given list
    */

  def foldLeft[A, B](list: List[A], acc : B, fn: (A,B) => B ): B = list match {
    case head :: tail => foldLeft(tail,fn(head,acc),fn)
    case _=> acc
  }

  /*
       Below shows the inbuilt methods of collections
       1. List(1,2,3).map({a:Int => a * 2}). This can also be rewritten as
       2. List(1,2,3).map{a:Int => a * 2}. This can be rewritten as
       3. List(1,2,3) map {a:Int => a * 2}. In scala if we call 1 + 1 basically what happens is the + method in Int is called
          i.e 1 + 1 can be rewritten as (1).+(1). Similarly #2 can be rewritten as #3.
       4. Since the compiler can work out the type we can rewrite the above to List(1,2,3) map {_ * 2}. Refer FunctionLiteral.class
          for why {_ * _} similar to {_ * 2} did not work before
   */

}
