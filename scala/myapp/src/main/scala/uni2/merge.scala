package uni2

object merge extends App{

  val valList = List(3, 2, 4, 4, 7, 12, 34)
  mySortMethod(valList)

  def mySortMethod(valList:List[Int]): Unit ={
    val n = valList.length
    for(i <- 0 to n - 1){
      if(valList(i) != valList(n-1)){
        if(valList(i) > valList(i+1)){
          print(valList(i))
          println(" switch")
        }else{
          print(valList(i))
          println(" skip")
        }
      }
    }
  }

}
