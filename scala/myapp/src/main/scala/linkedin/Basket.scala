package linkedin

class Basket(customer: Customer){
  private var items = List.empty[Product]

  def addItem(product: Product): Unit = {
    items = product :: items
  }

  def getItems: Seq[Product] = items


}