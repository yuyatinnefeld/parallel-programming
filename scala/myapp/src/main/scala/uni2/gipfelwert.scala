package uni2

object gipfelwert extends App{

  val valList = List(4, 6, 18, 1, 8, 5, 12, 2, 3, 7, 1, 5, 3, 1, 0, 11, 5, 16)

  gipfel(valList)

  def gipfel(valList:List[Int]): Unit ={
    val n = valList.length - 1

    for(i <- 1 to n) {
      if(i < n-1){
        if(valList(i) > valList(i-1) && valList(i) > valList(i+1)) {
          println(valList(i))
        }
      }
    }
  }

}
