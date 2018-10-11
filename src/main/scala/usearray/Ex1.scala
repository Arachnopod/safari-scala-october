package usearray

object DoubleItFunction {
  def apply(d:Double):Double = d * 2
}

object Ex1 {
  def main(args: Array[String]): Unit = {
//    val names = new Array[String](3)
//    names(0) = "Fred"
//    names.update(1, "Jim")
    val names = Array.apply("Fred", "Jim", "Sheila")
    println(s"first name is ${names.apply(0)}")
    println(s"second name is ${names(1)}")

    println(s"DoubleItFunction(3.14) is ${DoubleItFunction(3.14)}")
  }
}
