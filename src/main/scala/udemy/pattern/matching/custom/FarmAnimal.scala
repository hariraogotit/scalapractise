package udemy.pattern.matching.custom

import udemy.partialfunction.Animal

/**
  * Created by Hari Rao on 13/08/18.
  */
object FarmAnimal {

  def unapply(animal: Animal) : Option[String] = {
    if(animal.species == "Cow"){
      Some(animal.name)
    }else{
      None
    }
  }

}
