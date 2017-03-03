package lesson.four.generics


/*
   BOTTOM LINE :- + makes sure that Dog and its subtypes are accepted. + is for Immutables i.e
                    for getters
                  - makes sure that Puppy and its super types are accepted. - is for Mutables i.e
                    for setters
 */


/**
  * Created by Hari Rao on 03/03/17.
  * Below is the improved version of Box.scala
  */

class Dog
class Puppy extends Dog

/**
  *  - :- Contravariance. Same as lower bound but this is short cut and more readable
  * @tparam A
  */
trait PutBox[-A]{
  def put(value: A): Unit = ???
}

/**
  * The below putGetBox is invariant in its type i.e but get and set on the types can be done.
  * Example 1. List[+A] is covariant i.e the List is immutable
  *         2. MutableList[A] is invariant as we can both read from and write to.
  *         3. Subscriber[-Evt,-Pub] is Contravariance i.e this is write only
  * @tparam A
  */
trait putGetBox[A] extends PutBox[A] with GetBox[A]
/**
  * + :- Covariance. Same as upper bound but this is short cut and more readable
  * @tparam A
  */
trait GetBox[+A]{
  def get() : A = ???
}

object Boxes {

   def putPuppy(box: PutBox[Puppy]) : Unit = box.put(new Puppy)
   def getDog(box: GetBox[Dog]) : Dog = box.get()

  val dogPutBox = new PutBox[Dog] {}
  val dogGetBox = new GetBox[Dog] {}
  val puppyPutBox = new PutBox[Puppy] {}
  val puppyGetBox = new GetBox[Puppy] {}

  putPuppy(puppyPutBox)
  getDog(puppyGetBox)
  putPuppy(dogPutBox)
  getDog(dogGetBox)
}
