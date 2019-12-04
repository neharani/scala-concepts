package examples


object Helpers extends App {
  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit =
        if(current > 0) {
          f
          loop(current - 1)
        }
      loop(x)
    }
  }


  new IntWithTimes(6).times(println("hello"))
  6 times println("Hi")
}

object StringOps {
   implicit class StringUtils(s:String)
  {
    def joinss = s+ "hhhhh"
  }
}


object A extends App {
  import StringOps._

  def joinss :String =""
  "Neha".joinss
}


/*Implicit classes have the following restrictions:

1. They must be defined inside of another trait/class/object.

implicit class RichDouble(x: Double) // BAD!


2. They may only take one non-implicit argument in their constructor.

implicit class RichDate(date: java.util.Date) // OK!
implicit class Indexer[T](collection: Seq[T], index: Int) // BAD!
implicit class Indexer[T](collection: Seq[T])(implicit z: Int) // OK!


3.There may not be any method, member or object in scope with the same name as the implicit class.


object Bar
implicit class Bar(x: Int) // BAD!

val x = 5
implicit class x(y: Int) // BAD!

implicit case class Baz(x: Int) // BAD!


http://baddotrobot.com/blog/2015/07/03/scala-implicit-parameters/
object Impplicits {
  def example2(implicit x: Int, y: Int)               // x and y are implicit
  def example3(x: Int, y: Int)               // wont compile
  def example4(x: Int)(implicit y: Int)               // only y is implicit
  def example5(implicit x: Int)(y: Int)               // wont compile
  def example6(implicit x: Int)(implicit y: Int)
}*/




