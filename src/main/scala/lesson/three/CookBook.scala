package lesson.three

/**
  * Created by Hari Rao on 26/02/17.
  */
class CookBook(val receipes: Map[String,Receipe]) {

  //Auxilary constructor can be used which calls the main constructor and pass an empty map
  def this() = this(Map.empty)

  val pbj = CompanionObject(List("Peanut Butter","Jelly","Bread"),
                            List("Apply peanut butter and jelly on bread"))

  val pancakes = CompanionObject(List("Pancake","Egg"),
                                 List("Take the egg and put it on the pancake"))

  val cresps = CompanionObject(List("cresps","fruits"),
                               List("Bake the cresps","Put fruits on cresps"))

}
