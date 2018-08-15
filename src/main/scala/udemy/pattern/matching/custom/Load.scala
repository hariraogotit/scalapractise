package udemy.pattern.matching.custom

import udemy.partialfunction.Animal

/**
  * Created by Hari Rao on 13/08/18.
  */
object Load  extends App{


  println(namesOfFarmAnimals(Seq(Animal("Bessy","Cow"), Animal("Santiago", "Cat"))))

  println(namesOfFarmAnimalsTuple(Seq(Animal("Bessy","Cow"), Animal("Santiago", "Cat"))))

  println(namesOfFarmAnimalsItSelf(Seq(Animal("Bessy","Cow"), Animal("Santiago", "Cat"))))

  println(namesOfFarmAnimalsSeq(Seq(Animal("Bessy","Cow"), Animal("Santiago", "Cat"))))

  def namesOfFarmAnimals(myAnimals:Seq[Animal]) : Seq[String] ={
    myAnimals.filter {
      case FarmAnimal(_) =>
        true
      case _ =>
        false
    }.map {
      case FarmAnimal(name) =>
        name
      case _ =>
        ""
    }
  }

  def namesOfFarmAnimalsTuple(myAnimals:Seq[Animal]) : Seq[String] ={
    myAnimals.filter {
      case FarmAnimalTuple(_,_) =>
        true
      case _ =>
        false
    }.map {
      case FarmAnimalTuple(name, species) =>
        s"$name and $species"
      case _ =>
        ""
    }
  }

  def namesOfFarmAnimalsItSelf(myAnimals:Seq[Animal]) : Seq[String] ={
    myAnimals.filter {
      case FarmAnimalItSelf(_) =>
        true
      case _ =>
        false
    }.map {
      case FarmAnimalItSelf(Animal(name, species)) =>
        s"$name and $species"
      case _ =>
        ""
    }
  }

  def namesOfFarmAnimalsSeq(myAnimals:Seq[Animal]) : Seq[String] ={
    myAnimals.filter {
      case FarmAnimalSeq(_,_,_) =>
        true
      case _ =>
        false
    }.map {
      case FarmAnimalSeq(task1, task2, task3) =>
        s"$task1, $task2 and $task3"
      case _ =>
        ""
    }
  }

}
