package udemy.pattern.matching.custom

import udemy.partialfunction.Animal

/**
  * Created by Hari Rao on 14/08/18.
  */
object FarmAnimalSeq {

  def unapplySeq(animal: Animal) : Option[Seq[String]] = {
    if(animal.species == "Cow"){
      Some(Seq("milking","Breeding","fertilizing"))
    }else{
      None
    }
  }

}
