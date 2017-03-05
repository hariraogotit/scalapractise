package lesson.five


/**
  * Created by Hari Rao on 26/02/17.
  */
class Calculator {

  /**
    * type Operator is called the type alias similar to typedef keyword in C or C++
    */
  type Operator = (Int, Int) => Int

  object Operator{
    // Function literals are used instead of case object. In FunctionLiteral.scala we have mentioned that
    // val times = {_ * _} will not work as scala will not know to work out the type but in the below function
    // literals get the types from the above type alias. So this is similar to
    // timesTwoTypeInference: (Int, Int) => Int = { _ * _}
    val operators: Map[String,Operator] = Map("+" -> {_ + _} ,
                                              "-" -> {_ - _},
                                              "/" -> {_ / _},
                                              "*" -> {_ * _})
    val tokens = operators map {_.swap}
    def unapply(token: String): Option[Operator] = operators.get(token)
  }

  object Number {
    def unapply(token: String): Option[Int] = try{
      Some(token.toInt)
    }catch {
      case _:NumberFormatException=> None
    }
  }



  sealed trait Expression
  case class NumberExpression(value: Int) extends Expression
  case class OperatorExpression(lhs: Expression, rhs: Expression, op: Operator) extends Expression

  /**
    *
    * @param stack
    * @param token
    * @return
    *   This method is created to remove the mutable stack and replace it with immutable List
    */
  def step(stack : List[Expression], token: String) : List[Expression] = token match {
    case Number(num) => NumberExpression(num) :: stack
    case Operator(op) => stack match {
        // rhs is the head, lhs is tail and rest is rest of the elements in a List. Example in List(1,2,3) 1 is rhs, 2 is lhs and rest is 3
        // In List(1,2,3,4) - rest is 3 and 4
        // Also in List(1,2,3,4) if defined like case rhs :: lhs :: something :: rest then here something is 3 and rest is 4
      case rhs :: lhs :: rest => OperatorExpression(lhs, rhs, op) :: rest
      case _ => throw new IllegalArgumentException("not enough operands")
    }
    case _=> throw new IllegalArgumentException("Invalid Token " + token)
  }

  def parse(expression: String): Expression = {
     val tokens = expression.split(" ")
     val stack = tokens.foldLeft(List.empty[Expression]) {step}
     stack.head
  }


  def Calculate(expression: Expression): Int = expression match {
    case NumberExpression(value) => value
    case OperatorExpression(lhs,rhs,op) => op(Calculate(lhs),Calculate(rhs))
  }


  def toInfix(expression: Expression) : String = expression match {
    case NumberExpression(value) => value.toString
    case OperatorExpression(lhs,rhs,op) => s"(${toInfix(lhs)} ${Operator.tokens(op)} ${toInfix(rhs)})"
  }

  def parsePostFix(arg: String): Unit = {
    if(arg!=null){
      val expression = parse(arg)
 //     println(expression)
      println(s"${toInfix(expression)} = ${Calculate(expression)}")
    }else{
      throw new IllegalArgumentException("Invalid expression " + arg)
    }
  }
}