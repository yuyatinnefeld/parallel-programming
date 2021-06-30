package uni

object u5_account_number extends App{

  class Account(var name:String, val account_num:Int, var amount:Int = 0) {
    def change_name(name: String): Unit = {
      this.name = name
    }
    def withdrawal(amount:Int): Unit ={
      if(this.amount < amount){
        println(s"the amount $amount is higher than your saving. You have just "+this.amount)
      }else{
        this.amount -= amount
        println("here cash for you!")
      }
    }
    def deposit(amount:Int): Unit ={
      this.amount += amount
    }
  }

  val account = new Account("peter paker", 1435353)
  println(account.name)
  println(account.account_num)
  println(account.amount)

  account.change_name("peter bonbon")
  account.deposit(1000)
  println(account.name)
  println(account.amount)
  account.withdrawal(100000)
  account.withdrawal(100)
  println(account.amount)


}
