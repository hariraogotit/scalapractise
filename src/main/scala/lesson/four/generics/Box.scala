package lesson.four.generics

/**
  * Created by Hari Rao on 02/03/17.
  */

class Dog{
  override def toString: String = "Dog"
}

class Puppy extends Doggy{
  override def toString: String = "Puppy"
}

/**
  *
  * @param content
  * @tparam A
  *    The below class accepts any type
  */

case class Box[A](private var content: A)

/**
  * >: is lower bound :- Any Puppy or its supper class can go in and <: upper bound :- Any Dog or classes whose parent is Dog
  * will be returned
  */
object Box{

  def putPuppy[A >: Puppie](box: Box[A]): Unit = box.content = new Puppie

  def getPuppy[A <: Doggy](box: Box[A]): A= box.content

}