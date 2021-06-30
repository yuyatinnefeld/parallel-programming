package uni

import java.time.{LocalDate, Month, Period}

object u13_oop_personal extends App{

  class Person(val name:String, birthdayYear: String, startYear:String, incomeLevel:Int){
    def printAllInfo(): Unit ={
      println("I'm "+this.name)
      println("My Birthday is: "+this.birthdayYear)
      println("I started to work in "+this.startYear)
      println("I have Level: "+this.incomeLevel)
    }

    def mySalary(): Unit ={
      var BasicIncome = 1250
      //println("BasicIncome = "+ BasicIncome)
      println(s"$name verdient " + (BasicIncome + this.incomeLevel * 300))
    }

    def getVacation(): Int = {
      val today = LocalDate.now();
      val thisYear = today.getYear
      val age = thisYear - this.birthdayYear.toInt
      var vacation = 30
      if(age > 40 && age < 50) {
        vacation = 31
      }else if(age > 50 && age < 60){
        vacation = 32
      }else if(age > 60){
        vacation = 33
      }else{
      }
      return vacation
    }
  }

  val p1 = new Person("Hana", "2000", "2012", 5)
  val p2 = new Person("Taka", "1780", "2012", 3)

  //p1.printAllInfo()
  p1.mySalary()
  p2.mySalary()

  println(p1.name + " has "+p1.getVacation() + " days vacation per year")
  println(p2.name + " has "+p2.getVacation() + " days vacation per year")

}
