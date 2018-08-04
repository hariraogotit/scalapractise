package udemy.pattern.matching

/**
  * Created by Hari Rao on 04/08/18.
  */
object Load extends App{

// Here person is of type tuple  of String and Option[Int]
  def describePerson(person : (String, Option[Int])): String = {
     person match {
       case (name, None) =>
         s"$name has no age"
         // using | is called pattern alternative. ageResult is the variable that holds the evaluated value in this case it is
         // either 5 or 8
       case (name, Some(ageResult @(5 | 8))) =>
         s"$name is a particularly precocious age at $ageResult."
         // the below if statements are called guards. They are just like the ones in for comprehension
       case (name, Some(age)) if age < 10 =>
         s"$name is a still learning at $age years old"
       case (name, Some(age)) =>
         s"$name is a mature $age years old"
     }
  }

  println(describePerson("Tej", Some(5)))
  println(describePerson("Hari", Some(31)))

}
