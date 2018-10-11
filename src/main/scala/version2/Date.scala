package version2

// Compaion object
object Date {
  def apply(day:Int, month:Int, year:Int=2018):Date = {
    // limit of 31 is a hack!!!
    if (month > 0 && month < 13 && day > 0 && day < 31)
      new Date(day, month, year)
    else throw new IllegalArgumentException("Bad date!")
  }

  def isLeapYear(implicit year: Int): Boolean =
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
}

class Date private (val day:Int=1, val month:Int=1, val year:Int=2018) {

  def dayOfWeek: Int = {
    val (m, y) = if (month < 3) (month + 12, year - 1) else (month, year)
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
  def main(args: Array[String]): Unit = {
    val d1 = Date.apply(1, 1, 2000)
    val d2 = Date(1, 1, 2000)
    val d3 = Date(1, 1)
    val d4 = d1
    println(s"d1 is $d1")

    try {
      val d5 = Date(-1, -2, -3)
      println(s"d5 is $d5")
    } catch /* implied ex match */{
      case ex:IllegalArgumentException => println(s"that broke")
      case _:Throwable => println("Huh!? wasn't expecting that!")
    } finally {
      println("we're all better now")
    }
    println("still going...")

//    var x:Any = "bad"
//    x match {
//      case 99 => println("hah, I thought so!")
//    }
  }
}
