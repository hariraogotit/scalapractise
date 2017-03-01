package Lesson.Three

import scala.collection.mutable

/**
  * Created by Hari Rao on 26/02/17.
  */
class Calculator {

  trait Operator{
      def operate(lhs: Int, rhs: Int): Int
  }

  object Operator{
    val operators: Map[String,Operator] = Map("+" -> Add,
                                              "-" -> Subtract,
                                              "/" -> Divide,
                                              "*" -> Multiply)

    def unapply(token: String): Option[Operator] = operators.get(token)
  }

  object Number {
    def unapply(token: String): Option[Int] = try{
      Some(token.toInt)
    }catch {
      case _:NumberFormatException=> None
    }
  }

  case object Add extends Operator{
    override def operate(lhs: Int, rhs: Int) =  lhs + rhs
    override val toString = "+"
  }

  case object Subtract extends Operator{
    override def operate(lhs: Int, rhs: Int) =  lhs - rhs
    override val toString = "-"
  }

  case object Divide extends Operator{
    override def operate(lhs: Int, rhs: Int) =  lhs / rhs
    override val toString = "/"
  }

  case object Multiply extends Operator{
    override def operate(lhs: Int, rhs: Int) =  lhs * rhs
    override val toString = "*"
  }


  def calculate(expression: String): Int = {
      val stack = new mutable.Stack[Int]()

      for(token: String <- expression.split(" ")) token match {
          case Number(num) => stack.push(num)
          case Operator(op) =>
               val rhs = stack.pop()
               val lhs = stack.pop()
               stack.push(op.operate(lhs,rhs))
          case _=> throw new IllegalArgumentException("Invalid Token " + token)
        }
      stack.pop()
  }

  def parsePostFix(expression: String): Unit = {
    if(expression!=null){
      println("Evaluated post fix " + calculate(expression))
    }else{
      throw new IllegalArgumentException("Invalid expression " + expression)
    }
  }
}