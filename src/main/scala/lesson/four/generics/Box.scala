package lesson.four.generics

/**
  * Created by Hari Rao on 02/03/17.
  */

class Dog{
  override def toString: String = "Dog"
}

class Puppy extends Dog{
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

  def putPuppy[A >: Puppy](box: Box[A]): Unit = box.content = new Puppy

  def getPuppy[A <: Dog](box: Box[A]): A= box.content

}