package udemy.pattern.matching.caseclass

/**
  * Created by Hari Rao on 07/08/18.
  */
object Load  extends App{

val cat = Classification("felix", "felicius")

val animal = Animal("Dog",10, cat)

def describeAnimal(animal: Animal): String = {
  animal match {
    case Animal(name, age, classification) =>
      s"$name $age $classification"
  }
}

println(describeAnimal(animal))

def describeAnimalExtractClassification(animal: Animal): String = {
  animal match {
      //nested pattern matching as Animal and Classification are pattern matched
    case Animal(name, age, Classification(genus, species)) =>
      s"$name $age $genus $species"
  }
}

 println(describeAnimalExtractClassification(animal))

  // pattern matching can be done directly as follows.
val Animal(name, _, Classification(_, species)) = animal
  println(name, species)



}
