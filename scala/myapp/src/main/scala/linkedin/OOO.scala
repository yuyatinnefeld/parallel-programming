package scala_basics

object OOO extends App {

  print(myFunc(100, "halo"))

  def myFunc(x: Int, y: String): String = {
    y + " " + x
  }

  val anAnimal = new Animal

  class Animal {
    val age: Int = 0

    def eat() = println("I'm eating")
  }

  class Dog(name: String) extends Animal

  val aDog = new Dog("Testu")

  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat()

  abstract class WalkingAnimal {
    protected val hasLegs = true

    def walk(): Unit
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit
  }

  class Crocodile extends Animal with Carnivore with Philosopher {
    def eat(animal: Animal): Unit = println("I am eating you, animal")

    def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog
  aCroc.?!("what if we could fly?")

  object MySingeton {
    val mySpecialVal = 4333

    def mySpecialMethod(): Int = 2222

    def apply(x: Int): Int = x + 1
  }

  val res = MySingeton.mySpecialMethod()
  println(res)

  val res2 = MySingeton.apply(78)
  println(res2)
  println(MySingeton(78))

  object Animal {
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForEver = Animal.canLiveIndefinitely
  println(animalsCanLiveForEver)

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 345)

  println(bob.age)

  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception => "Some faulty error msg"
  }
  finally {
    //close conn etc.
  }

  abstract class MyList[T] {
    def head: T

    def tail: MyList[T]
  }

  val aList: List[Int] = List(1, 2, 3, 4)
  val first = aList.head
  val last = aList.tail
  println(first)
  println(last)

  val reversedList = aList.reverse
  println(reversedList)

}
