package linkedin

import scala.math.BigDecimal.double2bigDecimal

object Application {
  def main(args: Array[String]): Unit = {

    val c1 = Customer("yuya", "tinne")
    val c2 = Customer("nakano", "zui")

    val basket = new Basket(c1)
    val priceE = Price(988.99, "EUR")
    val product = new OnlineProduct("Samsung TV", priceE)
    val product2 = new OnlineProduct("Samsung Phone", priceE)

    basket.addItem(product)
    basket.addItem(product2)

    OnlineShop.default.addCustomer(c1)
    OnlineShop.default.addCustomer(c2)

    val pList = List(Price(10.00, "EUR"), Price(20.00, "USD"), Price(30.00, "USD"))

    println("All")
    pList.foreach(println)

    println("Only EUR")
    pList.filter(p => p.currency == "EUR").foreach(println)


    println("With Tax")
    pList.map(p => println("original:" + p.value + p.currency + " price with tax: " + (p.value * 1.19).setScale(2, BigDecimal.RoundingMode.HALF_UP) + p.currency))






  }


}

