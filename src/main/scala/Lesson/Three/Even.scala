package Lesson.Three

/**
  * Created by Hari Rao on 27/02/17.
  */
object Even {

  /**
    *
    * @param arg
    * @return
    *    unapply can also be used to perform any operation
    */
    def unapply(arg: Int): Option[Int] = if (arg % 2 == 0) Some(arg/2) else None

}
