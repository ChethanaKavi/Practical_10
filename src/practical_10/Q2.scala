object Q2 {
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator cannot be zero")

    private val g = gcd(n.abs, d.abs)

    val numer: Int = n / g
    val denom: Int = d / g

    def this(n: Int) = this(n, 1)

    def neg: Rational = new Rational(-numer, denom)

    def sub(that: Rational): Rational = {
      new Rational(
        numer * that.denom - that.numer * denom,
        denom * that.denom
      )
    }

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    // Override toString for easy printing
    override def toString: String = {
      if (denom == 1) s"$numer"
      else s"$numer/$denom"
    }
  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result_y_minus_z = y.sub(z)
    println(s"y - z: $y - $z = $result_y_minus_z")

    val result = x.sub(result_y_minus_z)
    println(s"x - (y - z): $x - ($y - $z) = $result")
  }
}
