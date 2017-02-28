package Lesson.Three.Traits

/**
  * Created by Hari Rao on 27/02/17.
  * The following are using traits where as in CookBook.scala in polymorphismandinheritance package
  * we have used abstract class
  */

 case class Receipe(ingredients: Map[String,Mass], directions: List[String]){
  def shoppingList(kitchen: Map[String,Mass]) : List[String]={
     for{
       (name,need) <- ingredients.toList
        have = kitchen.getOrElse(name,Grams(0))
        if have < need
     }yield name
  }
}

trait Measured {
  def amount: Double
  def symbol: String
  override def toString(): String = amount + symbol
}

trait Conflict {
  override def toString: String = "problem?"
}

/**
  * 1. Ordered trait has abstract compare method which is overridden in Mass for comparing.
  * 2. toString() is present both in Measured and Conflict traits. Scala compiler looks for toString() from right
  *    i.e it looks in Measured then Conflict and so on. Since it will find toString() in Measured, it will consider it
  *    and ignore the toString() in Conflict. This way the Diamond problem will not surface.
  */
sealed trait Mass extends Ordered[Mass] with Conflict with Measured{
  def toGrams : Grams
  override def compare(that: Mass): Int = (this.toGrams.amount - that.toGrams.amount).toInt
}
case class Grams(amount: Double) extends Mass {
  override def toGrams = this
  val symbol = "g"
}
case class MilliGrams(amount: Double) extends Mass{
  override def toGrams = new Grams(amount/1000)
  val symbol = "mg"
}
case class KiloGrams(amount: Double) extends Mass{
  override def toGrams = new Grams(amount *  1000)
  val symbol = "kg"
}

/**
  * Called the following in scala console
  * Lesson.Three.Traits.CookBook.pbj.shoppingList(Map("Peanut Butter" -> Grams(5),
  *              "Jelly" -> KiloGrams(1)))
  */

object CookBook{
  val pbj = Receipe(Map("Peanut Butter" -> Grams(10),
                        "Jelly" -> KiloGrams(0.5),
                        "Bread" -> Grams(250)), List("Put the peanut butter and jelly on the bread"))

  val baconPancakes= Receipe(Map("bacon" -> KiloGrams(1),
                                ("Pancakes" ->  MilliGrams(10))),List("Take some bacon and put it on the bread"))


}
