package examples

abstract class Typed[A] {
  def add(x: A, y: A): A
  def unit: A
}

object ImplicitTest {
  implicit val SubType1: Typed[String] = new Typed[String] {
    def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }

  implicit val SubType2: Typed[String] = new Typed[String] {
    def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }



  implicit val intTyped: Typed[Int] = new Typed[Int] {
    def add(x: Int, y: Int): Int = x + y
    def unit: Int = 0
  }

  def sum[A](xs: List[A])(implicit m: Typed[A]): A =
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail))

  def main(args: Array[String]): Unit = {
    println(sum(List(1, 2, 3)))       // uses intTyped implicitly
    //println(sum(List(1.4, 2, 3)))       // not compile
    println(sum(List("a", "b", "c"))) // uses stringMonoid implicitly
  }
}