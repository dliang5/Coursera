// rewatching the videos again to understand
// Lecture 3.1 - class hierarchies

object intsets {
  println("Welcome to the Scala worksheet")
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4
  println(t1)
  println(t2)
}

abstract class IntSet {
  def incl(x : Int): IntSet
  def contains(x : Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x :Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty);
  def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def toString = "{" + left + elem + right + "}"

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem

}

List(List(true, false), List(3))
val t1 = new NonEmpty(3, new Empty, new Empty)
val t2 = t1 incl 4
println(t1)
println(t2)
