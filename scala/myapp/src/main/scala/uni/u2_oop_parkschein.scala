package uni

object u2_oop_parkschein extends App{

  class Person(val id:String, var hour:Int=0, var status:Boolean=false){
    def checkout(hour:Int): Unit ={
      this.hour += hour
      this.status = true
    }
  }

  class ParkscheinAutomat(val userGroup:List[Person]){

    def printOverview(): Unit ={
      println("####### Info #########")
      println("Total User: "+ userGroup.size)
      println("Checkout Users: "+ userGroup.withFilter(x => x.status == true).map(x => x.id))
      println("Active Users: "+ userGroup.withFilter(x => x.status == false).map(x => x.id))


      for(user <- userGroup){
        println("####### Details #########")
        println("ID: "+ user.id)
        println("Hour: "+ user.hour + " Std")
        println("Status: "+ user.status)
        println("Price: "+ ( 5 + user.hour * 2) + " EUR")
        println()
      }


    }

  }

  val person1 = new Person("1111")
  person1.checkout(3)
  val person2 = new Person("2222")
  person2.checkout(1)
  val person3 = new Person("3333")
  val person4 = new Person("4444")
  val person5 = new Person("5555")
  person5.checkout(10)

  val userGroup = List(person1, person2, person3, person4,person5)

  val parkscheinAutomat = new ParkscheinAutomat(userGroup)

  parkscheinAutomat.printOverview()




}
