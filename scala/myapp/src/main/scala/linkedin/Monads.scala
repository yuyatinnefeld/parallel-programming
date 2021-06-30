package scala_basics

object Monads extends App{

  var x = Seq("Geeks", "For", "Geeks")
  var y = x.map(_.toUpperCase)
  var z = x.flatMap(_.toUpperCase)

  //println(y)
  //println(z)

  // Scala program of Monads
  //def GfG(){
  //    val list1 = List(1, 2, 3)
  //    val list2 = List(10, 20, 30)

  //    // Applying 'flatMap' and 'map'
  //    val z = list1 flatMap {
  //      q => list2 map { r => q + r}
  //    }
  //   println(z)
  //}

  //GfG()

  val list = List.apply(1, 2, 3)
  println(list)
  val list2 = List(1)
  println(list2)

  def makeListOfDoubles(int: Int): List[Double] = {
    List(int.toDouble)
  }

  val list3 = list.flatMap(makeListOfDoubles)
  println(list3)

  val list4 = list.map(_.toDouble)
  println(list4)

  val mappedList = list.map(makeListOfDoubles)
  println(mappedList)

  val o1 = Some("hello")

  val o2 = Some("world")

  val o3 = o1.flatMap(a => o2.map(b => a + " " + b))
  println(o1)
  println(o2)
  println(o3)


  val h1 = Some("hey")
  val h2 = None
  val h3 = Some("jo")

  val h4 = for {
    a <- h1
    b <- h2
    c <- h3
  } yield a + " " + c

  println(h4)

  val hh1 = Some("hey")
  val hh2 = Some("you")
  val hh3 = Some("jo")

  val hh4 = for {
    a <- hh1
    b <- hh2
    c <- hh3
  } yield a + " " + c

  println(hh4)


}
