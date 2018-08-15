package udemy.pattern.matching.custom

import udemy.partialfunction.Animal

/**
  * Created by Hari Rao on 13/08/18.
  */
object FarmAnimalTuple {

  def unapply(animal: Animal) : Option[(String, String)] = {
    if (animal.species == "Cow") {
      Some((animal.name, animal.species))
    } else {
      None
    }
  }

}
