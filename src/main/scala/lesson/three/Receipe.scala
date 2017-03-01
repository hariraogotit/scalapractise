package lesson.three

/**
  * Created by Hari Rao on 26/02/17.
  *
  * val in the constructor makes the field a member field of the class.
  */
class Receipe(
      val ingredients: List[String] = List.empty,
      val directions: List[String] = List.empty) {

  // These statements are valid here because this area can be considered as body of the
  // constructor and body of the class Receipe
      println("Ingredients " + ingredients)
      println("Directions " + directions)
}

