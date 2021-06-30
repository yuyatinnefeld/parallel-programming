package scala_basics

object LambdaFunc extends App{

  def squareInt(x:Int) : Int = {
    x * x
  }

  def cubeInt(x:Int): Int = {
    x * x * x
  }

  println("square of 10: "+squareInt(10))
  println("cube of 10: "+cubeInt(10))

  def transformInt(x: Int, f: Int => Int): Int = {
    f(x)
  }

  println("square of 10: "+transformInt(10, x => x * x))
  println("cube of 10: "+transformInt(10, x => x * x * x))

  for(i <- 1 to 10){
    println("square of "+i+": "+ transformInt(i, x => x * x))
  }

  def transformStr(x: String, f: String => String): String = {
    f(x)
  }

  val users = Map("userA" -> "Apple Macbook Pro13", "userB" -> "Apple Iphone 10", "userC" -> "Samsung GalaxyNote 20 Ultra 5G", "userD" -> "Windows Surface 5", "userE" -> "Samsung Wash machine, WW9800T")

  for(user <- users){
    println("### user info ###")
    // println(user)
    println(user._1 + " bought :")
    println("# Brand: " + transformStr(user._2, x => x.split(" ")(0)))
    println("# Product: " + transformStr(user._2, x => x.split(" ")(1)))
    util.Try(println("# Version: " + transformStr(user._2, x => x.split(" ")(2)))) getOrElse(println("# Version: none"))
  }

}
