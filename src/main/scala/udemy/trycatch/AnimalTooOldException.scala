package udemy.trycatch

/**
  * Created by Hari Rao on 09/08/18.
  */
case class AnimalTooOldException(name: String, age: Int) extends Exception(s"$name is older than 18. They are $age")
