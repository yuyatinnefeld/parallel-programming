package uni

object u12_oop_uni extends App{

  class Project(val Title:String, val Organizer:Person, var Member:List[Person], students:Int, Info:String)

  class Person(val name:String, age:Int, role:String){
    def teachSeminar(seminar:String): Unit ={
      println(this.name+ " teaches: "+ seminar)
    }
    def takeSeminar(seminar:String): Unit ={
      println(this.name+ " learns: "+ seminar)
    }
  }

  val p1 = new Person("tania", 42, "teacher")
  val p2 = new Person("maik", 22, "student")
  val p3 = new Person("jum", 52, "gust-professor")
  val p4 = new Person("yona", 19, "student")
  val p5 = new Person("comm", 35, "student")

  p1.teachSeminar("Math")
  p2.takeSeminar("Math")

  val student_group = List(p2, p4, p5)
  val student_group2 = List(p2, p4)

  //println(student_group(0).name)
  for(i <- student_group){
    println("student: " + i.name)
  }

  val project1 = new Project("Math Expo", p1, student_group, student_group.size, "Funny Expo")
  val project2 = new Project("Programming Camp", p3, student_group2, student_group2.size, "Not Outdoor Camp")

  val project_list = List(project1, project2)

  for(i <- project_list){
    print("Project: " + i.Title + " | Organizer: " + i.Organizer.name + " | Member: ")
    for(j <- i.Member){
      print(j.name + ", ")
    }
    println()
  }
}
