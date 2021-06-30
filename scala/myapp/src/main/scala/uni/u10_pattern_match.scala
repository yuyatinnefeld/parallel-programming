package uni

object u10_pattern_match extends App{

  //print this
  // ********************
  // *                  *
  // *      Hallo       *
  // *                  *
  // ********************


  for(i <- 1 to 5) {
    i match {
      case 2 => println("*                  *")
      case 3 => println("*      Hallo       *")
      case 4 => println("*                  *")
      case _ => println("********************")
    }

  }
}
