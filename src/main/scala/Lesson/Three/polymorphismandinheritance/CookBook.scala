package Lesson.Three.polymorphismandinheritance

/**
  * Created by Hari Rao on 27/02/17.
  */

 case class Receipe(ingredients: Map[String,Mass], directions: List[String]){
  def shoppingList(kitchen: Map[String,Mass]) : List[String]={
     for{
       (name,need) <- ingredients.toList
       // _ = println(name)
        have = kitchen.getOrElse(name,Grams(0))
        if have.compareTo(need) < 0
     }yield name
  }
}

/**
  *   Below the constructor of Mass needed amount so the class like Grams, MilliGrams and KiloGrams
  *   received that via their constructor and passed it to Mass class but this is not the common way.
  *   The most common way is to declare the amount that Mass class needs as a def in Mass class as shown
  *   further below
  */
/*
 abstract class Mass(val amount: Double){
   def toGrams : Grams
 }
 class Grams(amount: Double) extends Mass(amount) {
   override def toGrams = this
   override def toString: String = amount + "g"
 }
 class MilliGrams(amount: Double) extends Mass(amount){
   override def toGrams = new Grams(amount/1000)
   override def toString: String = amount + "mg"
 }
 class KiloGrams(amount: Double) extends Mass(amount){
   override def toGrams = new Grams(amount *  1000)
   override def toString: String = amount + "kg"
 }
*/
/**
  * 1. Instead of def amount, val amount can be declared. As you know in val and var the variable are assigned values then and there
  * but if declared as def then the variables are assigned only when that particular variable is called. This is called
  * late binding or lazy evaluation.
  * 2. Easy way of declaring is declare all the fields as def in abstract class and override them with val or def. There
  * are rules governing around declaring a field as val in abstract class and overriding it with def. So stick with the
  * easy way.
  * 3. Sealed says no other classes outside this file are allowed to extend Mass also when it comes to pattern matching sealed
  * helps in coming with all possible cases as it assures that there are only three types of Mass. In case if you declare
  * a match statement with only one case i.e case Grams(amount) then the compiler will tell "Match case may not be exhaustive.
  * It would fail on the following inputs: KilloGrams(_) and MilliGrams(_)
  * 4. We have implemented Algebric data types :- consists of a sealed Abstract class and several case classes that implements
  * the sealed abstract class.
  */
sealed abstract class Mass extends Comparable[Mass]{
  def amount : Double
  def toGrams : Grams
  override def compareTo(that: Mass): Int = (this.toGrams.amount - that.toGrams.amount).toInt
}
case class Grams(amount: Double) extends Mass {
  override def toGrams = this
  override def toString: String = amount + "g"
}
case class MilliGrams(amount: Double) extends Mass{
  override def toGrams = new Grams(amount/1000)
  override def toString: String = amount + "mg"
}
case class KiloGrams(amount: Double) extends Mass{
  override def toGrams = new Grams(amount *  1000)
  override def toString: String = amount + "kg"
}

object CookBook{
  val pbj = Receipe(Map("Peanut Butter" -> Grams(10),
                        "Jelly" -> KiloGrams(0.5),
                        "Bread" -> Grams(250)), List("Put the peanut butter and jelly on the bread"))

  val baconPancakes= Receipe(Map("bacon" -> KiloGrams(1),
                                ("Pancakes" ->  MilliGrams(10))),List("Take some bacon and put it on the bread"))


}
