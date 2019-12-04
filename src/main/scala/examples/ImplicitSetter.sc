class ImplicitSetter {
  private var a = 0

  def age = a

  def age_=(n: Int) = {
    require(n > 0)
    a = n
  }
}

  val t = new ImplicitSetter
  t.age = 20
  println(t.age)

