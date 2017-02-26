package Lesson.Three

/**
  * Created by Hari Rao on 26/02/17.
  * 1. Class and Object CompanionObject are companions
  *    1.1 If they should have the same name and are declared in the same file
  *    1.2 Private and Protected fields in each other are accessible by each other
  *    1.3 Object are usually used as factories where the constructor of the class is made private there by
  *        forcing us to use the make method which returns the instance of the class
  */
class CompanionObject private(val ingredients:List[String] = List.empty,
                              val directions:List[String] = List.empty) {
     println("Ingredients "+ ingredients)
     println("Directions " + directions)

}

object CompanionObject {
  def make(ingredients: List[String], directions: List[String]): CompanionObject =
    new CompanionObject(ingredients, directions)
}