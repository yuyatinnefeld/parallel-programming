package uni

import java.util.UUID.randomUUID

object u1_oop_spartverein extends App{

  class MemberShip(val name:String, members: Map[String, Member]){
    def printAllMembers(): Unit ={
      println("MemberShip Name: "+ this.name)
      for(member <- this.members){
        println("ID: "+ member._1 + " | Name: " + member._2.name + " | Gender: " + member._2.gender)
      }
    }

    def paymentCheck(): Unit ={
      val payment= members.map(x => x._2.payStatus)
      println(payment)
    }
  }

  class Member(val name:String, val memberID:String, var gender:Char, year:Int, var payStatus:Boolean=false){

    def payMembershipFee(name:String): Unit ={
      println(this.name + " paid membership fee for " + name)
      payStatus=true
    }

  }

  val p1 = new Member("haraki", randomUUID().toString, 'm', 1980)
  val p2 = new Member("nana", randomUUID().toString, 'f', 1997)
  val p3 = new Member("maria",randomUUID().toString, 'f', 1977)
  val p4 = new Member("maik",randomUUID().toString, 'm', 2000)

  val karatekas = Map(p1.memberID->p1, p2.memberID->p2, p3.memberID->p3)
  val baseballPlayers = Map(p2.memberID->p2, p3.memberID->p3, p4.memberID->p4)

  val karateMemberShip = new MemberShip("Karate Do", karatekas)
  val baseballMemberShip = new MemberShip("Team Homerun!", baseballPlayers)

  karateMemberShip.printAllMembers()
  println()
  baseballMemberShip.printAllMembers()
  baseballMemberShip.paymentCheck()

  p3.payMembershipFee("Karate Do")
  p4.payMembershipFee("Team Homerun!")
  baseballMemberShip.paymentCheck()

}
