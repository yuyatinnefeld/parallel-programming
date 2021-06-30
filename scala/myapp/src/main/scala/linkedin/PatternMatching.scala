package scala_basics

object PatternMatching extends App {

  val anInteger = 50
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }

  println(order)

  // pattern matching is only possible with the CASE CLASS

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 22)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I'm $a years old."
    case _ => "Something else"
  }

  println(personGreeting)

  val aTuple = ("Bon Jovi", "Rock")

  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you're talking about"
  }
  println(bandDescription)


}
