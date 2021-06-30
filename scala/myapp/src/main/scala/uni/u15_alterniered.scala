package uni

object u15_alterniered extends App{

  def expo(x:Int, n:Int): Int ={
    var result = 1
    for(i <- 1 to n){
      result *= x
    }
    result
  }

  def folge(n:Int): Int = {
    val result = expo(-1, n) * n*n
    return result
  }

  val aList = List(1,2,3,4)
  println(aList)
  val res = aList.map(x => folge(x))
  println(res)

}
