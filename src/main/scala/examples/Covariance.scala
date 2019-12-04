package examples




/*
Scala Variance
Covariant	[+T]	If S is subtype of T, then List[S] is also subtype of List[T]
Contravariant	[-T]	If S is subtype of T, then List[T] is also subtype of List[S]
Invariant	[T]	If S is subtype of T, then Printer[S] and Printer[T] are unrelated.


*/

  class Car {}
  class SportsCar extends Car {}
  class Ferrari extends SportsCar {}

  object Covariance extends App {

    def returnCar(arg: SportsCar => SportsCar): SportsCar = {
      new SportsCar
    }

    def foo1(arg: Car): Ferrari = { new Ferrari }
    def foo2[A <: SportsCar](arg: SportsCar): Car = { new Ferrari }
    def foo3(arg: Ferrari): Ferrari = { new Ferrari }

   returnCar(foo1)// compiles
   // returnCar(foo2) // Fails due to wrong return type.
   // returnCar(foo3) // Fails due to wrong parameter typeName
}



abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal


//List[Cat] is a List[Animal] and a List[Dog] is also a List[Animal]
//so this is called subtyping



object CovarianceTest extends App {
  def printAnimalNames(animals: Seq[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  printAnimalNames(cats)
}


class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class


//Contravariant	[-T]	If S is subtype of T, then Type[T] is also subtype of Type[S]

abstract class Type [-T]{
  def typeName : Unit
}

class SuperType extends Type[AnyVal]{
  override def typeName: Unit = {
    println("SuperType")
  }
}
class SubType extends Type[Int]{
  override def typeName: Unit = {
    println("SubType")
  }
}


class TypeCarer {

  def display(t: Type[Int]) {
    t.typeName
  }
}

object ScalaContravarianceTest {

  def main(args: Array[String]) {
    val superType = new SuperType
    val subType = new SubType

    val typeCarer = new TypeCarer

    typeCarer.display(subType)
    typeCarer.display(superType)
  }

}



abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[Cat] {
  def print(cat: Cat): Unit =
    println("The cat's name is: " + cat.name)
}


object Contravariance extends App {

  val myCat: Cat = Cat("Boots")

  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter

  printMyCat(catPrinter)
  printMyCat(animalPrinter)
}





