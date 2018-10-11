package calendar

object Date {
  def *=+-(day:Int): String = dayName(day)

  def isLeapYear(implicit year:Int):Boolean =
    (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))

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

// constructor args can be simple args, val, or var
class Date(/*private [this] */
           val day:Int=1, val month:Int=1, val year:Int=2018) {
  def this(x:Int) = this(x, 1, 2018)

  def dayOfWeek: Int = {
//    val m = if (month < 3) month + 12 else month
//    val y = if (month < 3) year - 1 else year

//    val t:(Int, Int) = if (month < 3) (month + 12, year - 1) else (month, year)
//    val m = t._1
//    val y = t._2

    val (m, y) = if (month < 3) (month + 12, year - 1) else (month, year)
//    val (m, y):(Int, Int) = if (month < 3) (month + 12, year - 1) else (month, year)
//    val (m, y):Tuple2[Int, Int] = if (month < 3) (month + 12, year - 1) else (month, year)
    (day + (13 * (m + 1) / 5) + y + y / 4 - y / 100 + y / 400) %7
  }
  def dayName:String =
    Date.dayName(dayOfWeek)

  override def toString: String = s"day: $day, month: $month, year: $year"

  final override def equals(obj: Any): Boolean = {
    println("in Date.equals method")
    obj match {
      case d:Date => d.day == this.day &&
        d.month == this.month &&
        d.year == this.year
      case _ => false
    }
  }
}

object TryDate {
  // function args are VAL always!!!
  def main(args: Array[String]): Unit = {
    val pi:Double = 3.1415926;
    Console println f"Pi is approximately ${pi}%9.5f"
    println(s"Day is ${Date.dayName(3)}")
    val today = new Date(11, 10, 2018)
    println(s"day is ${today.day}")
    val d = new Date(month=3, day=14)
    println(s"default day ${d}")

    // caller side, scoped, default argument!!!
    implicit val thisYear = 2020
    println(s"is this a leap year ${Date.isLeapYear}")

    println(s"Day of jan 1 2000 was ${new Date(1, 1, 2000).dayName}")

    val d1 = new Date(1, 1, 2000)
    val d2 = new Date(1, 1, 2000)
    val d3 = new Date(1, 1)
    val d4 = d1
    println(s"d1 == d2 ${d1 == d2}")
    println(s"d1 == d3 ${d1 == d3}")
    println(s"d1 == d3 ${d1 == d3}")
    println(s"d1 eq d4 ${d1.eq(d4)}")
    println(s"d1 eq d2 ${d1 eq d3}")
  }
}
