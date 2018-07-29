package udemy.generics

/**
  * Created by Hari Rao on 29/07/18.
  */
object Load extends App{

  val numbers = Seq(1,2,3,4,5)
  // All the below are same
  println(numbers.reduce((a,b) => a+b))
  println(numbers.reduce{(a,b) => a+b})
  println(numbers.reduce{_ +_})
  println(numbers.reduce(_ +_))

  //Output of the below - ,1,2,3,4,5
  println(numbers.foldLeft(""){(accumulator, number) => accumulator +"," + number})
  println(numbers.foldLeft(""){_ + "'" + _})

  // :+ appends to the collection in the left. As you see the below is initialized with an empty collection.
  // Output is List(1, 2, 3, 4, 5)
  //:+ appends +: prepends to the collection
  println(numbers.foldLeft(Seq[Int]()){(accumulator, number) => accumulator :+ number})
  println(numbers.foldLeft(Seq[Int]()){_ :+_})

  //Output is List(1, 2, 3, 4, 5)
  println(numbers.foldRight(Seq[Int]()){(number, accumulator) => accumulator :+ number})
  //Output is List(1, 2, 3, 4, 5)
  println(numbers.foldRight(Seq[Int]()){_+:_})


}
