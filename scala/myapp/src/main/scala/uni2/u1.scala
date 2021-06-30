package uni2

object u1 extends App{


  val bMap = Map(
    "Jan" -> 1, "Feb" -> 2, "Mar" -> 3, "Apr"-> 4, "May" -> 5, "Jun"->6,
    "Jul"-> 7, "Aug" -> 8, "Sep" -> 9, "Oct" -> 10, "Nov" -> 11, "Dec" ->12
  )

  val cList = List(("Italy", "Rome", 1), ("France", "Paris", 7), ("US", "Washington DC", 1), ("Japan", "Tokyo", 10), ("Germany", "Berlin", 5))

  val onlyCityName = cList.map(p => p._2)
  println(onlyCityName)

  val bigCity = cList.filter(p => p._3 > 6)
  val middleCity = cList.filter(p => p._3 <= 5 && p._3 > 2)
  val smallCity = cList.filter(p => p._3 <= 2)

  println(bigCity)
  println(middleCity)
  println(smallCity)

  val xList = List(1,2,3,4).map(_ + 10).filter(_ % 2 == 0).map(_ * 3)
  println(xList)

}
