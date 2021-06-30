package scala_basics

import scala.math._

object MathFunc {
  def main(args: Array[String]): Unit = {

    var mod = 5 % 4
    println("modulo: " + mod)

    val temp = 2
    var next = 2
    next += temp
    println(next)

    var absVal = abs(-8)
    println("absolute val: " + absVal)

    var ce = ceil(5.43)
    println(ce)

    var ro = round(5.45)
    println(ro)

    var po = pow(2, 5)
    println(po)

    var sq = sqrt(16)
    println(sq)

    var mn = min(5, 10)
    println(mn)

    var mx = max(1, 999)
    println(mx)

    var random = (scala.math.random() * (11 - 1))
    println(random)

    var in = random.toInt
    println(in)
  }

}
