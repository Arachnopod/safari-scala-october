package caseclass

// class has factory, two vals--even without specify
// equals, hashcode, and works directly in match/case!
// and "unapply"
case class Rectangle(width:Int, height:Int)

object TryRectangle {
  def main(args: Array[String]): Unit = {
    val r1 = Rectangle(3, 4)
    val r2 = Rectangle(3, 4)
    val r3 = Rectangle(3, 3)
    println(s"r1 == r2 ${r1 == r2}")

    r2 match {
      case Rectangle(w, h) => println(s"That's a rectangle with dimensions " +
        s"$w and $h")
    }
  }
}