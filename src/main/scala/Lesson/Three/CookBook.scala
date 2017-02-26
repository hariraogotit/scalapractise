package Lesson.Three

/**
  * Created by Hari Rao on 26/02/17.
  */
class CookBook(val receipes: Map[String,Receipe]) {

  println("Receipes " + receipes)

  //Auxilary constructor can be used which calls the main constructor and pass an empty map
  def this() = this(Map.empty)

}
