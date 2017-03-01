package lesson.two

/**
  * Created by Hari Rao on 26/02/17.
  */
class ForComprehensions {

  /**
    *
    * @param original
    * @return
    *   When For and Yield are used it is called for comprehension or for expression
    */

  def simpleForComp(original: List[Int]): List[Int] ={

    for(i <- original) yield {
       i * 2
    }
  }

  /**
    * @return
    *    Below is the nested for loop producing cartesian product
    */
  def forCompWithBraces() : List[Int] = {
     for{
       i <- List(1,2,3)
       j <- List(4,5,6)
     } yield
       i * j
  }

  /**
    *
    * @return
    *    if product % 2 == 0 is called Guard and it is not an if-else. This will not have a body and else.
    *    It is just a predicate.
    */
  def forCompWithGuard() : List[Int] = {
    for{
      i <- List(1,2,3)
      j <- List(4,5,6)
      product = i * j
      if product % 2 == 0
    }
      yield  product
  }

}
