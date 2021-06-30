package uni



object u11_oop_article extends App{
  // class Project(var name: String, daysToComplete: Int)
  // val project1 = new Project("TPS Reports", 1)
  // val project2 = new Project("Website redesign", 5)
  // println("Object: " + project1)
  // println("Attribute: " + project1.name)


  class Article(var SKU:String, var description:String, var price:Double, var stock:Int){

    def buy(stock:Int) = {
      if(this.stock >= stock){
        println(s"This item x $stock piece(s) was bought!")
        this.stock -= stock
        delivery()
      }else{
        println("Sorry we don't have this item in stock")
      }
    }

    def delivery(): Unit ={
      println("This item will be shipped soon")
    }
  }

  val article1 = new Article("111", "the best of best rice cooker!", 234.5, 4)
  val article2 = new Article("222", "the best of best spark book!", 314.5, 10)
  val article3 = new Article("333", "the best of best scala book!", 34.5, 0)

  //println(article1.price, article2.SKU)
  println("Stock check: "+ article2.stock)
  article2.buy(4)
  println("Stock check: "+ article2.stock)
}



