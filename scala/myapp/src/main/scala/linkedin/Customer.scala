package linkedin

class Customer(fn:String , ln:String){
  lazy val fln = {
    s"$fn $ln"
  }
}

object Customer{
  def apply(fn: String, ln:String):Customer = new Customer(fn, ln)
}