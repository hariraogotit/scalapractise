package Lesson.Three

/**
  * Created by Hari Rao on 26/02/17.
  * 1. Class and Object CompanionObject are companions
  *    1.1 If they should have the same name and are declared in the same file
  *    1.2 Private and Protected fields in each other are accessible by each other
  *    1.3 Object are usually used as factories
  *    1.4 Apply methods are called by default when the Object is referenced. Eg when List(1,2,3) is called
  *    List.apply(1,2,3) is called in the background
  */
class CompanionObject (val ingredients:List[String],
                              val directions:List[String]) {
     println("Ingredients "+ ingredients)
     println("Directions " + directions)

}

object CompanionObject {
  def apply(ingredients: List[String] = List.empty, directions: List[String] = List.empty): CompanionObject =
    new CompanionObject(ingredients, directions)
}