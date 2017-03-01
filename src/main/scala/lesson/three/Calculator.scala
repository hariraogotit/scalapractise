package lesson.three

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

  /**
    * Not only class but an object can also have case object
    */
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

  sealed trait Expression
  case class NumberExpression(value: Int) extends Expression
  case class OperatorExpression(lhs: Expression, rhs: Expression, op: Operator) extends Expression

  /**
    *
    * @param expression
    * @return
    *   This method builds a stack of type Expression
    *   Example
    *         Input :- From scala console ran - new Calculator().parsePostFix("1 2 + 3 4 5 - - * 6 7 8 - * /")
    *         Output :- OperatorExpression(OperatorExpression(OperatorExpression(NumberExpression(1),NumberExpression(2),+),OperatorExpression(NumberExpression(3),OperatorExpression(NumberExpression(4),NumberExpression(5),-),-),*),OperatorExpression(NumberExpression(6),OperatorExpression(NumberExpression(7),NumberExpression(8),-),*),/)
    */
  def parse(expression: String): Expression = {
      val stack = new mutable.Stack[Expression]()

      for(token: String <- expression.split(" ")) token match {
          case Number(num) => stack.push(NumberExpression(num))
          case Operator(op) =>
               val rhs = stack.pop()
               val lhs = stack.pop()
               stack.push(OperatorExpression(lhs,rhs,op))
          case _=> throw new IllegalArgumentException("Invalid Token " + token)
        }
      stack.pop()
  }

  /**
    *
    * @param expression
    * @return
    *    The above parse method builds the stack of type Expression. The below method evaluates the built stack of Expressions
    */
  def Calculate(expression: Expression): Int = expression match {
    case NumberExpression(value) => value
    case OperatorExpression(lhs,rhs,op) => op.operate(Calculate(lhs),Calculate(rhs))
  }

  /**
    *
    * @param expression
    * @return
    *    This method traverses over all the expressions in the stack to print them in infix notation.
    *    String interpolation is used to print the infix expression.
    *    Example of String Interpolation
    *    val name = "Fred"
    *    val age = 33
    *    val weight = 200.00
    *    1. println(s"$name is $age years old, and weighs $weight pounds.") -> Fred is 33 years old, and weighs 200.0 pounds.
    *    2. println(s"Age next year: ${age + 1}") -> Age next year: 34
    */

  def toInfix(expression: Expression) : String = expression match {
    case NumberExpression(value) => value.toString
    case OperatorExpression(lhs,rhs,op) => s"(${toInfix(lhs)} $op ${toInfix(rhs)})"
  }

  def parsePostFix(arg: String): Unit = {
    if(arg!=null){
      val expression = parse(arg)
     // println(expression)
      println(s"${toInfix(expression)} = ${Calculate(expression)}")
    }else{
      throw new IllegalArgumentException("Invalid expression " + arg)
    }
  }
}