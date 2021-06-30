package uni

object u16_modulomult extends App{

  val n = 6
  val twoDArray = Array.ofDim[Int](n, n)

  for(i <- 1 to n-1){
    for(j <- 1 to n-1){
      twoDArray(i)(j) =  (i * j) % 6
    }
  }

  for(i <- 1 to n-1){
    for(j <- 1 to n-1){
      print(twoDArray(i)(j))
    }
    println()
  }



}
