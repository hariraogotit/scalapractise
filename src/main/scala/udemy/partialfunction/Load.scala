package udemy.partialfunction

/**
  * Created by Hari Rao on 11/08/18.
  */
object Load extends App{

 val santiago = Animal("Santiago", "Cat")
 val cleo = Animal("Cleo", "Dog")

 val meow: PartialFunction[Animal, String] = {
   case Animal(_, "Cat") => "meow"
   case Animal(_,"Tiger") => "meow"
   case Animal(_,"Lion") => "roar"
 }

 val woof: PartialFunction[Animal, String] = {
   case Animal(_,"Dog") => "woof"
 }
  // isDefinedAt Checks if there is any match in the partial function.
  println(meow.isDefinedAt(cleo))
// The above isDefinedAt is used to check if the match is in meow or woof.
val speak = meow orElse woof
speak.applyOrElse(Animal("DefaultAnimal","Default_Animal"), (animal: Animal) => "I am Default Animal")

println(speak(cleo))
println(speak(santiago))
println(speak.applyOrElse(cleo, (animal: Animal) => "I am Default Animal"))
println(speak.applyOrElse(santiago, (animal: Animal) => "I am Default Animal"))
println(speak.applyOrElse(Animal("Squeek","Rat"), (animal: Animal) => "I am Default Animal"))


}
