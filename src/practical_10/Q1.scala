object Q1 {
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator cannot be zero")

    private val g = gcd(n.abs, d.abs)

    val numer: Int = n / g
    val denom: Int = d / g

    def this(n: Int) = this(n, 1)

    def neg: Rational = new Rational(-numer, denom)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    override def toString: String = {
      if (denom == 1) s"$numer"
      else s"$numer/$denom"
    }
  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    println(s"x: $x")

    println(s"-x: ${x.neg}")

    val y = new Rational(5, 2)
    println(s"y: $y")
    println(s"-y: ${y.neg}")

    val z = new Rational(7)
    println(s"z: $z")
    println(s"-z: ${z.neg}")
  }
}
