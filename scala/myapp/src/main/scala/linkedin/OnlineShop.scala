package linkedin

trait CustomerManager{
  private var customers = List.empty[Customer]

  def addCustomer(customer:Customer):Unit = customers ::= customer
}

trait CheckOutHandler{

  def checkout(basket: Basket):Unit = {}

}

class OnlineShop extends CustomerManager with CheckOutHandler {

  def getName = OnlineShop.SHOP_NAME

}

object OnlineShop{

  private val SHOP_NAME = "DEMO-SHOP"
  lazy val default = new OnlineShop()

}
