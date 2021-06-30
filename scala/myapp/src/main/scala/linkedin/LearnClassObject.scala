package scala_basics

object LearnClassObject {
  def main(args: Array[String]): Unit = {
    val rover = new Animal
    rover.setName("Rover")
    rover.setSound("Woof")
    printf("%s says %s\n", rover.getName(), rover.getSound())

    val simba = new Animal
    simba.setName("Simba")
    //simba.setSound("Gaooooo")
    printf("%s says %s\n", simba.getName(), simba.getSound())

    // val = final (immutable)
    val whiskers = new Animal("Whiskers", "Meow")
    println(s"${whiskers.getName()} says ${whiskers.sound} ")

    //println(whiskers.toString)
    val spike = new Dog("Spike", sound = "Woof", growl = "GrGrrrr")
    println(spike.toString())

    val fang = new Wolf("Fang")
    fang.moveSpeed = 45.2
    println(fang.move)

  }

  class Animal(var name: String, var sound: String) {

    //constructor
    this.setName(name)
    this.setSound(sound)

    // simple method
    def getName(): String = this.name

    def getSound(): String = this.sound

    def setName(name: String) {
      if (!(name.matches(".*\\d+.*"))) // .*\d+.* => any decimal any number
        this.name = name
      else
        this.name = "No Name"
    }

    def setSound(sound: String) {
      this.sound = sound
    }

    def this(name: String) {
      this("No Name", "No Sound")
      this.setName(name)
    }

    def this() {
      this("No Name", "No Sound")
    }

    override def toString(): String = {
      return "%s says %s".format(this.name, this.sound)
    }

  }

  class Dog(name: String, sound: String, growl: String) extends Animal(name, sound) {
    def this(name: String, sound: String) {
      this("No Name", sound, "No Growl")
      this.setName(name)
    }

    def this(name: String) {
      this("No Name", "No Sound", "No Growl")
      this.setName(name)
    }

    def this() {
      this("No Name", "No Sound", "No Growl")
    }

    override def toString(): String = {
      return "%s says %s or %s".format(this.name, this.sound, this.growl)
    }

  }

  abstract class Mammal(val name: String) {
    var moveSpeed: Double

    def move: String
  }

  class Wolf(name: String) extends Mammal(name) {
    var moveSpeed = 35.0

    def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)
  }
}
