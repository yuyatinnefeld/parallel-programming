package uni

object u14_tarif_vergleich extends App{

  val minute = 50
  val tarif1:Double = 9.75 + (minute * 0.5)
  val tarif2:Double = 25.75 + ((minute-30) * 0.32)

  println(s"Tarif 1 kostet für $minute Minute $tarif1 EUR")
  println(s"Tarif 2 kostet für $minute Minute $tarif2 EUR")
  var bep = false

  for(i <- 1 to 100){
    val TarifA:Double = 9.75 + (i * 0.5)
    val TarifB:Double = 25.75 + ((i-30) * 0.32)

    println(i+" min: "+ "TarifA:" + TarifA + " | TarifB: " + TarifB)
    if(TarifA > TarifB && bep != true) {
      println("####### Break Event Point#########")
      println("Min "+ i)
      println("TarifA "+ TarifA)
      println("TarifB "+ TarifB)
      println("##################################")
      bep = true

    }
  }

}
