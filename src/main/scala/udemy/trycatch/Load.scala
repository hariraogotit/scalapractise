package udemy.trycatch

import scala.util.control.NonFatal

/**
  * Created by Hari Rao on 09/08/18.
  */
object Load extends App{

 println( callMakeAnimalDance(Animal("Dog",19)))

 try{
   // In this case calling makeAnimalDanceThrowStackOverFlowException method will throw stackoverflowException. Since this laptop's memory is
   // high we have to wait for very long time to see the exception. The important point here is NonFatal(exception). Since
   // stackOverFlowException is fatal it will not be caught. NonFatal(exception) can also be pattern matched like NonFatal(_) => "This is my fault"
   // instead of having - exception if NonFatal(exception)=> "This is my fault"
   makeAnimalDanceThrowStackOverFlowException(Animal("Cat",19))
 }catch {
   case exception if NonFatal(exception)=> "This is my fault"
 }

def callMakeAnimalDance(animal: Animal) : String ={
  try{
    makeAnimalDance(animal)
  }catch {
    // instead of returning the strings below if you print them then scala will not like it as the method expects a return
    // type of Sting but printing will result in a return type of Unit. So the return type of the method is also applicable to the
    // catch clause.
    // Note a guard is also allowed
    case AnimalTooOldException(name, age) if age < 25=> s"$name was too old at $age but we let him dance anyway"
    case _:Exception => "Not my problem"
  }
}

def makeAnimalDance(animal: Animal): String ={
  if(animal.age > 18){
    throw AnimalTooOldException(animal.name, animal.age)
  }else{
    s"${animal.name} is dancing!"
  }
}

def makeAnimalDanceThrowStackOverFlowException(animal: Animal): String ={
  if(animal.age > 18){
    makeAnimalDanceThrowStackOverFlowException(animal)
  }else{
    s"${animal.name} is dancing!"
  }
}


}
