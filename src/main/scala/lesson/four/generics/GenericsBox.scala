package lesson.four.generics

/**
  * Created by Hari Rao on 02/03/17.
  * Below class has a private variable which can be accessed via getter and setter.
  */
case class GenericsBox[A](private var content: A){
   def put(content: A) : Unit = this.content = content
   def get() : A = this.content
}

/**
  *  Execute the following in Scala console
  *  var gb = GenericsBox(12)
    scala> gb: lesson.four.generics.GenericsBox[Int] = GenericsBox(12)

    scala> gb.put(13)

    scala> gb.get()
    res1: Int = 13
  */