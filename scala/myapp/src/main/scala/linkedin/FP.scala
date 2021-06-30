package scala_basics

object FP extends App {
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(45)

  /*
  Functional Programming
   - compose functions
   - pass functions as args
   - return functions as results

  Conclusion: FunctionX
  */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(args: Int): Int = args + 1
  }

  val simpleIncrementer2 = new ((Int) => Int) {
    override def apply(args: Int): Int = args + 1
  }

  val res = simpleIncrementer.apply(30)
  simpleIncrementer(32)
  println(res)


  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  val stringConcatenator2 = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  val res2 = stringConcatenator("hallo ", "John")
  println(res2)

  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  println(doubler(4))

  val doubler2: (Int) => Int = (x: Int) => 2 * x
  println(doubler2(4))

  val aMappedList = List(1, 2, 3, 4, 5).map(x => x * 2)
  println(aMappedList)

  val x3 = List(1, 2, 3, 4, 5).map(x => x * x * x)
  println(x3)

  val aFlatMappedList = List(1, 2, 3, 4, 5).flatMap(x => List(x, 10 * x))
  println(aFlatMappedList)

  val aFilteredList = List(1, 2, 3, 4, 5).filter(x => x <= 3)
  println(aFilteredList)

  val aFilteredList2 = List(1, 2, 3, 4, 5).filter(_ > 2)
  println(aFilteredList2)

  val allPairs = List(1, 2, 3).flatMap(num => List("a", "b", "c").map(letter => s"$num-$letter"))
  println(allPairs)

  val alternativePairs = for {
    num <- List(1, 2, 3)
    letter <- List("a", "b", "c")
  } yield s"$num-$letter"
  println(alternativePairs)

  //Lists
  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val restElement = aList.tail
  println(firstElement)
  println(restElement)
  val aPrependedList = 0 :: aList
  println(aPrependedList)
  val anExtendedList = 0 +: aList :+ 6
  println(anExtendedList)

  // Sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3)
  val accessedElement = aSequence(1)
  println(accessedElement)

  // Vectors (fast seq implementation)
  val aVector = Vector(1, 2, 3, 4, 5)
  println(aVector)

  // Sets (no duplicates)
  val aSet = Set(1, 2, 3, 2, 1, 1)
  println(aSet)
  val setHas5 = aSet.contains(4)
  print(setHas5)

  // Ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList
  print(twoByTwo)

  // Tuples (groups of values under the same value)
  println()
  val aTuple = ("Bon Jovi", "Rock", 1984)
  println(aTuple)

  // Maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 49232423),
    "Jane" -> 2342442,
    ("Max", 392034242)
  )
  println(aPhonebook("Jane"))
}
