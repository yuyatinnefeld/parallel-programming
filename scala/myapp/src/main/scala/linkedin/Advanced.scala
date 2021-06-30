package scala_basics

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advanced extends App {
  /**
   * Lazy evaluation
   */

  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I'm so very lazy!")
    34
  }
  val eagerValue = lazyValueWithSideEffect + 1
  println(eagerValue)

  /**
   * Pseudo-collection
   */

  def methodWhichCanReturnNull(): String = "hello scala"

  def methodWhichCanReturnNull2(): String = null

  val anOption = Option(methodWhichCanReturnNull())
  println(anOption)

  val anOption2 = Option(methodWhichCanReturnNull2())
  println(anOption2)

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string $string"
    case None => "I obtained nothing"
  }
  println(stringProcessing)

  //map, flatMap, filter
  def methodWhichCanThrowException(): String = throw new RuntimeException

  def methodWhichCanThrowException2(): String = "this is string"

  // this try-catch is not efficient
  // try{
  //   methodWhichCanThrowException()
  // }catch{
  //   case e: Exception => "defend against this evil exception"
  // }

  // better way for try catch
  val aTry = Try(methodWhichCanThrowException())
  val aTry2 = Try(methodWhichCanThrowException2())

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(ex) => s"I have obtained an exception: $ex"
  }

  println(anotherStringProcessing)

  val anotherStringProcessing2 = aTry2 match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(ex) => s"I have obtained an exception: $ex"
  }

  println(anotherStringProcessing2)

  /**
   * Parallel Programming / Asynchronous programming
   */

  val aFuture = Future({ //Future.apply()
    println("Loading ...")
    Thread.sleep(1000)
    println("I have computed a value.")
    66
  })

  Thread.sleep(2000)

  /**
   * Implicits basics
   */

  //#1: implicit arguments
  def aMethodWithImplicitArg(implicit arg: Int) = arg + 1

  implicit val myImplicitInt = 46
  println("implicit arg check: " + aMethodWithImplicitArg)

  //#2. implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(24.isEven())
  println(27.isEven())


}
