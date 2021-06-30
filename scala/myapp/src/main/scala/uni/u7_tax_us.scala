package uni

import scala.io.StdIn.readInt

object u7_tax_us extends App{

  //Income                  =>  Tax

  // 0 – 9.325 USD          =>  10%
  // 9.326 – 37.950 USD     =>  15%
  // 37.951 – 91.900 USD    =>  25%
  // 91.901 – 191.650 USD   =>  28%
  // 191.651 – 416.700 USD  =>  30%
  // 416.701 – 418.400 USD  =>  33%
  // 418.401  >             =>  40%
  print("Enter x values: ")
  var input:Int = readInt()

  var tax:Double = 0

  println("### US TAX CALCULATOR ###")

  println(s"Annual Income: $input USD")

  var level1:Double = (0.1 * input)
  var level2:Double = (0.15 * (input-9325)) + (0.1 * 9325)
  var level3:Double = (0.25 * (input-37.950)) + (0.15 * 37.950) + (0.1 * 9325)
  var level4:Double = (0.28 * (input-91.900)) + (0.25 * 91.900) + (0.15 * 37.950) + (0.1 * 9325)
  var level5:Double = (0.30 * (input-191.650)) + (0.28 * 191.650) + (0.25 * 91.900) + (0.15 * 37.950) + (0.1 * 9325)
  var level6:Double = (0.33 * (input-416.700)) + (0.30 * 191.650) + (0.28 * 191.650) + (0.25 * 91.900) + (0.15 * 37.950) + (0.1 * 9325)
  var level7:Double = (0.40 * (input-418.400)) + (0.33 * 416.700) + (0.30 * 191.650) + (0.28 * 191.650) + (0.25 * 91.900) + (0.15 * 37.950) + (0.1 * 9325)

  if(input <= 9325) tax = level1
  else if(input > 9325 && input <= 37950) tax = level2
  else if(input <= 91900) tax= level3
  else if(input <= 191650) tax = level4
  else if(input <= 416700) tax = level5
  else if(input <= 418400) tax = level6
  else if(input > 418400) tax = level7
  else tax = 0

  tax = tax.round

  println(s"Total Income Taxes: $tax USD")
  println(s"Income After Taxes: ${input - tax} USD")


}
