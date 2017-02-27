package Lesson.Three

/**
  * Created by Hari Rao on 26/02/17.
  */
object Main {

  def main(args: Array[String]) : Unit ={

    matchWorksWithUnapply(new CookBook().pbj)

    println(isSimpleDirections(new CookBook().pbj))

    println(isSimpleDirections(new CookBook().cresps))

    println(isEven(10))

    // unapply can also be called  and used like this
    println(Even.unapply(12))

  }

  /**
    *
    * @param companionObject
    *      companionObject is the input for the unapply method in CompanionObject(ingredients,directions) and the outputs from
    *      unapply are the values in the arguments :- ingredients,directions
    */
  def matchWorksWithUnapply(companionObject: CompanionObject): Unit={
     companionObject match {
       case CompanionObject(ingredients,directions)=>
            println("Matched Ingredients " + ingredients)
            println("Matched Directions " + directions)
     }
  }

  /**
    *
    * @param companionObject
    * @return
    *    As you see we can also match based on a pattern. In this case directions with just one value in the List.
    *    Where as matchWorksWithUnapply is matched with the variable binding pattern
    */

  def isSimpleDirections(companionObject: CompanionObject): Boolean = companionObject match {
    case CompanionObject(_,List(_)) => true
    case _=> false
  }

  /**
    *
    * @param even
    * @return
    *    Unapply is called here by Even(halfOfInput) with arg as input
    */
  def isEven(even: Int): Option[Int] = even match {
    case Even(halfOfInput) => Some(halfOfInput)
    case _ => None
  }

}
