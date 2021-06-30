package uni

object u4_sec_day_calculator extends App{

  val input:Int = 100000 //100000 sec => 1 day 3 hours 46 min 40 sce
  val day_sec = 86400
  val hour_sec = 3600
  val min_sec = 60

  val day:Int = input / day_sec
  var hour:Int = (input % day_sec) / hour_sec
  var min:Int = (input % day_sec) % hour_sec / min_sec
  var sec:Int = (input % day_sec) % hour_sec % min_sec

  println(s"$input sec = $day day $hour hours $min min $sec sec")


}
