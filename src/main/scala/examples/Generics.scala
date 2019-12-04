package examples


class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A) { elements = x :: elements }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

class Fruit
class Apple extends Fruit
class Banana extends Fruit


object Generics extends App {

  val stack = new Stack[Int]
  stack.push(1)
  stack.push(2)
  println(stack.pop)
  println(stack.pop)



  val fruitStack = new Stack[Fruit]
  val apple = new Apple
  val banana = new Banana

  fruitStack.push(apple)
  fruitStack.push(banana)
}


//To conclude, Stack[A] is only a subtype of Stack[B] if and only if B = A

//exercise:  change this fully functional immutable list



