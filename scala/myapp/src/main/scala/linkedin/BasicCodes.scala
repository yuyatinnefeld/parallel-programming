package scala_basics

import scala.collection.mutable.ArrayBuffer

object BasicCodes {
  def main(args: Array[String]): Unit = {

    // loopCall(1)
    // arrayCall(i = 5)
    // println("multiplied" + mul(3))
    // hello("Scala san")
    // ageCheck(2)
    // println(ageReturn(40))
    // eventListCall()
    // inputData()

    // println("2+3 = " + getSum(2, 3))
    // println("2+3 = " + getSum(num2 = 3, num1 = 2))
    // println("Get sum " + getSum2(1,2,3,4,5))
    // println("fibonacci(10) = " +  Fib(10))
    // printType()
    // arrayFunc()
    // mapsFunc()
    tupleFunc()

  }

  def loopCall(i: Int) {
    var x = i

    do {
      println(x)
      x += 1
    } while (x <= 10)


    for (i <- 1 to 10) {
      print(i)
    }
    val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    for (i <- 0 until randLetters.length) {
      print(" : " + randLetters(i))
      println("")
    }

    for (i <- 1 to 5; j <- 6 to 10) {
      println("i: " + i + ", j: " + j)
    }


  }

  def arrayCall(i: Int) {
    val aList = List(1, 2, 3, 4, 5)

    for (i <- aList) {
      println("List items" + i)
    }
  }

  def mul(i: Int): Int = {
    return i * 2
  }

  def hello(name: String) {
    println("helloooooo: " + name)
  }

  def ageCheck(age: Int) {
    if (age >= 18)
      println("yes")
    else
      println("no")
  }

  def ageReturn(age: Int): String = {
    var answer = if (age >= 18) "yes" else "no"
    return answer
  }

  def eventListCall(): Unit = {
    var i = 0

    var eventList =
      for {i <- 10 to 30
           if (i % 2) == 0
           } yield i

    for (i <- eventList)
      println(i)
  }

  def inputData() {
    var numberGuess = 0
    do {
      print("Guess a number ")
      numberGuess = readLine.toInt
    } while (numberGuess != 15)

    printf("You guessed the secret number %d\n", 15)
    print("Done :)")
  }

  def printType(): Unit = {
    val name = "Dirk"
    val age = 16
    val weight = 187.4

    println(s"Hello $name")
    println(f"I am ${age + 1} and weigh $weight%.2f")

    printf("'%5d'\n", 5)
    printf("'%-15d'\n", 5)
    printf("'%05d'\n", 5)
    printf("'%.5f'\n", 3.15)


    val mySentence = "latatata alatatalta."
    println("4th index: " + mySentence(4))

  }

  def getSum(num1: Int = 1, num2: Int = 1): Int = {
    return num1 + num2
  }

  def getSum2(args: Int*): Int = {
    var sum: Int = 0
    for (num <- args) {
      sum += num
    }
    return sum
  }

  def Fib(num: BigInt): BigInt = {
    if (num == 0)
      return 0
    else if (num == 1)
      return 1
    else
      return Fib(num - 1) + Fib(num - 2)
  }

  def arrayFunc(): Unit = {
    val friends = Array("Bob", "Tom", "Nina")
    friends(0) = "Sue"
    for (i <- friends) {
      println(i)
    }

    val friends2 = ArrayBuffer[String]()
    friends2.insert(0, "Phil")
    friends2.insert(1, "Hana")
    friends2.insert(2, "Gon")
    friends2 += "Tao"
    friends2 ++= Array("John", "Kim")
    friends2.remove(0) //remove Phil
    for (person <- friends2) {
      println(person)
    }

    val favNums = new Array[Int](20)

    for (i <- 0 to (favNums.length - 1)) {
      favNums(i) = i * 20
      print(favNums(i) + " ")
    }
    println()

    val favNumsTime2 = for (num <- favNums) yield num / 20
    favNumsTime2.foreach(print)
    println()
    var favNumsDiv4 = for (num <- favNumsTime2 if num % 4 == 0) yield num
    favNumsDiv4.foreach(println)

    var multTable = Array.ofDim[Int](10, 10)
    for (i <- 0 to 9) {
      for (j <- 0 to 9) {
        multTable(i)(j) = i * j
      }
    }

    for (i <- 0 to 9) {
      for (j <- 0 to 9) {
        printf("%d * %d = %d\n", i, j, multTable(i)(j))
      }
    }

    println("Sum: " + favNumsTime2.sum)
    println("Min: " + favNumsTime2.min)
    println("Max: " + favNumsTime2.max)

  }

  def mapsFunc(): Unit = {
    // default maps => immutable values
    val employees = Map(
      "Manager" -> "Bob Smith",
      "IT" -> "Jim Harnic",
      "CTO" -> "Robina Kandinsky"
    )

    if (employees.contains("Manager"))
      printf("Manager: %s\n", employees("Manager"))

    if (employees.contains("CTO"))
      printf("CTO: %s\n", employees("CTO"))

    if (employees.contains("CEO"))
      printf("CEO: %s\n", employees("CEO"))

    // mutable maps
    val customers = collection.mutable.Map(
      100 -> "Paul",
      101 -> "Kasandra",
    )
    printf("Customer 1: %s\n", customers(100))

    customers(100) = "Yu Ta"
    customers(103) = "Megan Swift"

    for ((k, v) <- customers)
      printf("%d : %s\n", k, v)


  }

  def tupleFunc(): Unit = {
    var tupleMarge = (103, "Marge Simpson", 10.25)
    printf("%s owes us $%.2f\n", tupleMarge._2, tupleMarge._3)
    tupleMarge.productIterator.foreach { i => println(i) }
    println(tupleMarge.toString())
  }


}
