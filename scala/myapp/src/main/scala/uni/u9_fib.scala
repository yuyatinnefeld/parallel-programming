package uni

object u9_fib extends App{

  def fib(n:Int): Int = {
    if( n == 0 ){
      0
    } else if(n == 1|| n == 2){
      1
    }else{
      fib(n-2) + fib(n-1)
    }
  }

  for(i <- 0 to 10){
    println(s"fib($i) = " + fib(i))
  }

  println("### much better ###")

  def fib1( n : Int) : Int = n match {
    case 0 | 1 => n
    case _ => fib1( n-1 ) + fib1( n-2 )
  }

  for(i <- 0 to 10){
    println(s"fib1($i) = " + fib1(i))
  }


}
