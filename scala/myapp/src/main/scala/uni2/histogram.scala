package uni2

object histogram extends  App{

  val valList = List(4, 6, 8, 1, 8, 5, 2, 2, 3, 7, 1, 5, 3, 1, 0, 1, 5, 6, 6, 9)

  histogram(valList)

  def histogram(valList:List[Int]): Unit ={
    val sortedList = valList.sorted

    for(i <- 0 to 9) {
      print(i + ": ")
      val n = sortedList.length - 1

      for (j <- 0 to n) {
        if (sortedList(j) == i) {
          print("*")
        }
      }
      println()
    }
  }

}

