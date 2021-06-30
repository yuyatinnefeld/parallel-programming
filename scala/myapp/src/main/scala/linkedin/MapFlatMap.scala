package scala_basics

object MapFlatMap extends App {

  val name = Seq("Nidhi", "Singh", "Hara")

  // Applying map()
  println("step0: origin: "+ name)
  val lowercaseName = name.map(_.toLowerCase)
  println("step1: lowercase: "+lowercaseName)

  // Applying flatten() now,
  val flatten = lowercaseName.flatten
  println("step2: flatten: "+flatten)
  println()

  // flatMap => flatten + map
  val lowercaseName2 = name.flatMap(_.toLowerCase)
  println("step0: origin: "+ name)
  print("step1: lowercase + flatten: "+lowercaseName2)



}
