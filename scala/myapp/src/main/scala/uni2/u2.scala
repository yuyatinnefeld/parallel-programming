package uni2

import scala.collection.mutable.ListBuffer
import java.util

object u2 extends App{

  var list1 = List(1,2,3,4,5)
  var list2 = List(1,2,3,4,5)

  def task_a(): Unit ={
    var intList:ListBuffer[Int] = new ListBuffer[Int]()

    for(i <- 0 to 19){
      intList += i * 2
    }
    var Weekday:List[String] = List("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samsung", "Sonntag")
    var dVal:Double= 0.5
    intList.foreach(println)
  }

  def task_b():Unit = {
    val intArray:Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    println(intArray(2))
  }

  def task_c():Unit = {
    var dList:ListBuffer[Double] = new ListBuffer[Double]()
    var plusminus = 1
    for (i <- 1 to 20){
      if(i % 2 != 0 ){
        var x:Double = 1 / i.toDouble * plusminus
        plusminus *= -1
        dList += x
      }
    }

    dList.foreach(println)
  }

  def task_d():Unit = {
    val bArray:ListBuffer[Boolean] = new ListBuffer[Boolean]

    for(i <- 1 to 30){
      if(i%3 == 0){
        bArray += true
      }else{
        bArray += false
      }
    }

    for(i <- 1 to 30){
      println(i + ": " + bArray(i - 1))
    }

  }

  def stConcat(intArray:List[Int], intArray2:List[Int]):ListBuffer[String] = {
    val stArray:ListBuffer[String] = new ListBuffer[String]

    for ((i, count) <- intArray.zipWithIndex) {
      stArray += (i.toString + intArray2(count).toString)
    }

    return stArray
  }

  def intConcat(intArray:List[Int], intArray2:List[Int]):ListBuffer[Int] = {
    val intresArray:ListBuffer[Int] = new ListBuffer[Int]

    for ((i, count) <- intArray.zipWithIndex) {
      intresArray += (i + intArray2(count))
    }
    return intresArray
  }









}


