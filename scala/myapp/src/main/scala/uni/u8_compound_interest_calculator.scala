package uni

import scala.io.StdIn.readInt

object u8_compound_interest_calculator extends App{
  print("Enter start capital: ")
  val start_capital:Int = readInt()

  print("Enter monthly invest: ")
  val input_amout:Int = readInt() * 12

  print("Enter year: ")
  val year:Int = readInt()

  print("Enter interest rate: ")
  val rate:Double = readInt()

  var capital_with_invest:Double = start_capital + input_amout
  var capital_without_invest:Double = start_capital + input_amout
  var interest:Double = 0

  for(i <- 1 to year){
    println("--------- "+ i + " year ---------" )
    println("SAVING: " + (capital_without_invest * i))
    println("INVESTING: " + capital_with_invest.round)
    interest = (capital_with_invest * rate / 100)
    println("INTEREST: "+ interest)
    capital_with_invest += (capital_with_invest + interest)
  }


}
