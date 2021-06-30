package linkedin

abstract class Product(name:String, price:Price){
  override def toString: String = s"$name $price"
}