package uni

object u3_oop_player extends App{

  class Spieler(name:String, var win:Int=0, var lose:Int=0){
    def spiel(gewonnen:Boolean): Unit ={
      if(gewonnen) this.win += 1 else this.lose += 1
    }

    def zeigeBilanz(): Unit ={
      println(s"Spielbilanz fuer $name: ")
      println("gewonnen: "+win)
      println("verloren: "+lose)
      val total:Int = win+lose
      val Quote:Double = win.toDouble / total.toDouble
      println(f"Quote: $Quote%2.2f"+ " %")
      println()

    }

  }


  val a = new Spieler("Anna")
  val b = new Spieler("Otto")
  b.spiel(true)
  a.spiel(true)
  b.spiel(false)
  a.spiel( true )
  a.spiel(true)
  b.spiel(true)
  b.spiel(false)
  a.spiel(false)
  a.spiel(false)
  a.spiel(true)

  a.zeigeBilanz()
  b.zeigeBilanz()
}
