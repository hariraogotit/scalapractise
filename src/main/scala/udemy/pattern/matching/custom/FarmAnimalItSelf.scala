package udemy.pattern.matching.custom

import udemy.partialfunction.Animal

/**
  * Created by Hari Rao on 13/08/18.
  */
object FarmAnimalItSelf {


  def unapply(animal: Animal): Option[Animal] = {
    if (animal.species == "Cow") {
      Some(animal)
    } else {
      None
    }
  }
}
