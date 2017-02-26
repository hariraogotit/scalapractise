package Lesson.Two

/**
  * Created by Hari Rao on 26/02/17.
  */
class ExceptionPracs {

  def parseInt(s: String): Int = try{
    s.toInt
  }catch {
    case e: NumberFormatException => 0
  }

  def parseIntWithOption(s: String): Option[Int] = try{
    Some(s.toInt)
  }catch {
    case e: NumberFormatException => None
  }

}
