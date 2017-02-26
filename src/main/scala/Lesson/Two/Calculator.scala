package Lesson.Two

import scala.collection.mutable

/**
  * Created by Hari Rao on 26/02/17.
  */
class Calculator {

  def handleOperator(token: String, stack: mutable.Stack[Int]): Boolean = token match {

    case "+" =>
      val rhs = stack.pop()
      val lhs = stack.pop()
      stack.push(lhs + rhs)
      true
    case "*" =>
      val rhs = stack.pop()
      val lhs = stack.pop()
      stack.push(lhs * rhs)
      true
    case "-" =>
      val rhs = stack.pop()
      val lhs = stack.pop()
      stack.push(lhs - rhs)
      true
    case "/" =>
      val rhs = stack.pop()
      val lhs = stack.pop()
      stack.push(lhs / rhs)
      true
    case _ => false
  }

  def handleNumber(token: String, stack: mutable.Stack[Int]): Boolean =  {
    try{
      stack.push(token.toInt)
      true
    }catch{
      case _: NumberFormatException => false
    }
  }

  def calculate(expression: String): Int = {
      val stack = new mutable.Stack[Int]()

      for(token: String <- expression.split(" ")){
        if(!handleOperator(token,stack) && !handleNumber(token,stack)){
          throw  new IllegalArgumentException("Invalid token " + token)
        }
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