package linkedin

case class Price(value:Double, currency:String){

  def toUSD:Price = copy(value = value * 1.07, currency = "USD")

}