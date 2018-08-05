package udemy.pattern.matching.collection

/**
  * Created by Hari Rao on 05/08/18.
  */
object Load extends App{

  val myList: List[Int] = 1 :: 2 :: Nil
  myList match {
    case a :: b :: Nil =>
      println(a+b)
  }

  val anotherList: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil
  anotherList match {
    case a :: b :: rest =>
      println(rest)
  }

  val thirdList: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil
  thirdList match {
    case a :: _ :: b :: _ =>
      println(a + b)
  }

  val mySeq: Seq[Int] = Seq(1,2)
  mySeq match {
    case Seq(a, b)  =>
      println(a + b)
  }

  val anotherSeq: Seq[Int] = Seq(1,2,3,4)
  anotherSeq match {
    case Seq(a,b, _*) =>
      println(a + b)
  }

  anotherSeq match {
    case Seq(a,b, result @_*) =>
      println(result)
  }

}
