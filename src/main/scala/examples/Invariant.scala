package examples


class Container[A](value: A) {
  private var _value: A = value
  def getValue: A = _value
  def setValue(value: A): Unit = _value = value
}

object InVariant extends App {
  val catContainer: Container[Cat] = new Container(Cat("Felix"))

  val animalContainer: Container[Animal] = catContainer //won't compile
  animalContainer.setValue(Dog("Spot"))
  val cat: Cat = catContainer.getValue
  println(cat)
}



//Invariant	Container[T]	If S is subtype of T, then Container[S] and Container[T] are unrelated.