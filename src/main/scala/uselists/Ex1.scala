package uselists

import scala.annotation.tailrec

object Ex1 {
  @tailrec
  def printAllModified(l:List[String], op:String => String):Unit = l match {
    case List() => println("--------------------")
//    case List(h, item2) // exactly two items
    case theHead :: theTail =>
      println(op(theHead))
      printAllModified(theTail, op)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Fred", "Jim", "Sheila", "Albert")
    println(names)
//    val names2 = Nil.::("Fred")
    // :: called cons
    val names2 = "Fred" :: "Jim" :: "Sheila" :: Nil

    println(s"first item is ${names(0)}")
    println(s"first item is ${names.head}")
    println(s"remaining items are ${names.tail}")
    println(s"four tails: ${names.tail.tail.tail.tail}")

    printAllModified(names, s => {println(s"s is $s");s.toUpperCase})
    // multiple underscores, MUST OCCUR in the order of the function's params
    printAllModified(names, _.toLowerCase)

    names map (_.toUpperCase) foreach println
    println("-----------")
    names map (_.length) foreach println
  }
}
