package lesson.five

/**
  * Created by Hari Rao on 04/03/17.
  */
object ListAnatomy  extends App{


  def printList() {
    val list1 = List(1, 2, 3)
    println(list1)

    /**
      *  1. :: -> Is called Cons. A List has a tail and head.
      *  2. Below 1 is the head and rest all are tail. Again 2 is the head and rest all are tail, similarly
      *     3 is the head and tail is Nil.
      */
    val list2 = 1 :: (2 :: (3 :: Nil))
    println(list2)

    /**
      * list2 and list3 are same but list2 has the bracs just to explain the head and tail
      */
    val list3 = 1 :: 2 :: 3 :: Nil
    println(list3)

    /**
      * Below adds 0 as the head to the existing list
      */
    val list4 = 0 :: list1

    /**
      * Below gets the tail of list4
      */

    val list5 = list4.tail

    /**
      * list5 values and list1 values are compared and they will be equal
      */
    val sameVal = list5 == list1

    /**
      * Reference of list5 and list1 are compared and they should be equal. Based on above all it is clear that
      * lists are immutable but it does not create a new List every time but rather point to the existing available list
      * by pointing to the appropriate heads
      */

    val sameRef = list5 eq list1

    /**
      * 1. We construted head and tail above similarly we can decompose head and tail for pattern matching. This is what we
      *    are doing below
      * 2. Below is a recursvice call that prints the head and tail of the given List
      * @param list
      */
    def printAll(list: List[_]): Unit =  list match {
      case head :: tail =>
        println(head)
        printAll(tail)
      case Nil => ()
    }

    /**
      *
      * @param list
      * @return
      *  1. The below method returns the size of a given list by recursively getting the head and tail of the list
      *  2. case _ :: tail -- This means anything that has tail
      */
    def length(list: List[_]) : Int = list match  {
      case _ :: tail => 1 + length(tail)
      case _ => 0
    }

    /**
      *
      * @param list
      * @return
      *  Below method converts the given list to List of String types using recursion
      */

    def toStringAll(list: List[_]) : List[String]  = list match {
      case head :: tail => head.toString :: toStringAll(tail)
      case _ => Nil
    }
  }




}
