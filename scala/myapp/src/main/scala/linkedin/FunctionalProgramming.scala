package scala_basics

object FunctionalProgramming {
  def main(args: Array[String]): Unit = {

    //Reduce Func for combine data
    val numberList = List(1,2,3,4,5)
    val sumRes = numberList.reduce((x:Int, y:Int) => x + y)
    println(sumRes)


    //Map Func for iterative operation
    val collection = List(1, 2, 3, 4, 5)
    val new_collection = collection.map(sqr)
    println(new_collection)
    List(1, 2, 3, 4, 5).map((x: Int) => x * x).foreach(println)

    //Filter Func for select specific val
    List(1, 2, 3, 4, 5, 6, 7, 8).filter(_ % 2 != 0).foreach(println)
    val fruits = Set("orange", "peach", "apple", "banana", "avocado")
    val x = fruits.filter(_.startsWith("a"))
    println("starts with a")
    x.foreach(println)
    println("more than 5 char")

    fruits.filter(_.length > 5).foreach(println)

    //Closures
    def times3(num: Int) = num * 3

    def times4(num: Int) = num * 4

    def multIn(func: (Int) => Double, num: Int) = {
      func(num)
    }

    printf("3 * 100 = %.1f\n", multIn(times3, 100))
    printf("4 * 10 = %.1f\n", multIn(times4, 10))

    val divisorVal = 5
    val divisor5 = (num: Double) => num / divisorVal
    println("10 / 5 = " + divisor5(10.0))

    val mul2 = (num: Double) => num * 2
    println("4 * 2 = " + mul2(4.0))

  }

  def sqr(x: Int): Int = {
    return x * x
  }
}
