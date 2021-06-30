package uni

import scala.io.StdIn.readInt

object u6_val_switch extends App{

  print("Enter x values: ")
  var x:Int = readInt()

  print("Enter y values: ")
  var y:Int = readInt()

  println(s"x = $x")
  println(s"y = $y")
  println(s"x = $x and y = $y Switched")

  var temp:Int = x
  x = y
  y = temp

  println(s"x = $x")
  println(s"y = $y")
}
