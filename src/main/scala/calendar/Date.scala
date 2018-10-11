package calendar

object Date {
  def dayName(day: Int): String = day match {
    case 0 => "Saturday"
    case 1 => "Sunday"
    case 2 => "Monday"
    case 3 => "Tuesday"
    case 4 => "Wednesday"
    case 5 => "Thursday"
    case 6 => "Friday"
    case x if x < 10 =>
      s"$x does not map to a day name, calendars aren't decimal!"
    case x: Int => s"The number $x does not map to a day name!"
  }

  //  def dayName(day:Int):String =
  //    if (day == 0) "Saturday"
  //    else if (day == 1) "Sunday"
  //    else if (day == 2) "Monday"
  //    else if (day == 3) "Tuesday"
  //    else if (day == 4) "Wednesday"
  //    else if (day == 5) "Thursday"
  //    else if (day == 6) "Friday"
  //    else "BAD"
}

object TryDate {
  def main(args: Array[String]): Unit = {
    val pi:Double = 3.1415926;
    println(f"Pi is approximately ${pi}%9.5f")
    println(s"Day is ${Date.dayName(3)}")
    val n = 3
//    val v = if (n == 3) {
//      println("It's three!")
//      3
//    }

    println(s"day number ${Date.dayName(9)}")
  }
}
