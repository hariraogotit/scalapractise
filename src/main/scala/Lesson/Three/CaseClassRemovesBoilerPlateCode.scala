package Lesson.Three

/**
  * Created by Hari Rao on 27/02/17.
  *  Following are the significance of Case Class
  *  1. The compiler generates a companion object containing apply and unapply method
  *  2. Compiler also generated toString, equals, hashcode and copy methods
  *  3. The member variables initialized via constructor does not need to have val
  */

case class CaseClassRemovesBoilerPlateCode(ing: List[String],dir: List[String])
