package udemy.forcomp

/**
  * Created by Hari Rao on 28/07/18.
  */
object Load extends App {

  val antonio = Person("Antonio", 40)
  val mary = Person("Mary", 40)
  val cleo = Person("Cleo", 16)
  val santiago = Person("Santiago", 12)
  val familyOne = Family(Seq(antonio, mary, cleo, santiago))

  val john = Person("John", 43)
  val stacy = Person("Stacy", 42)
  val brian = Person("Brian", 12)
  val betty = Person("Betty", 21)
  val louise = Person("Louise", 24)
  val familyTwo = Family(Seq(john, stacy, brian, betty, louise))

  val families = Seq(familyOne, familyTwo)

  println(familyOne.people.map(_.name))
  println(familyTwo.people.map(_.name))

  println(families.map(_.people.map(_.name)))
  println(families.map(_.people.map(_.name)).flatten)
  println(families.flatMap(_.people.map(_.name)))
  println(families.flatMap(_.people.filter(_.age >=18)).map(_.name))

  /*
     The above can be done using for comprehension. As per the auther for comprehension is more clear
   */
  for {
    family <- families
    people <- family.people
  // My understanding of the below is print statement needs to  be in a variable. In our case the variable is  _
  // So once the print line is executed it is assigned in the variable. Since print prints, the value in the variable is
  //printed
   _ =  println("Person  " + people)
    if people.age >= 18
  }yield{
    println(people.name)
  }

  /*
  The first line determines the return type. If .toSeq is not given then the return type is Option[?] but
  the output or the return type is Seq[String]. Hence the first line is changed to be a return type of sequence
  by adding .toSeq at the end. The bottom line, the first line determines the required return type
   */

  for{
    oldFamily <- families.find(_.people.exists(_.age>40)).toSeq
    elder <- oldFamily.people
    if elder.age > 40
  }yield{
    println(elder.name)
  }

}