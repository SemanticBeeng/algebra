package algebra
package std

import algebra.lattice._
import algebra.ring._
import algebra.std.util.StaticMethods

package object byte extends ByteInstances

trait ByteInstances extends cats.kernel.std.ByteInstances {
  implicit val byteAlgebra = new ByteAlgebra

  val ByteMinMaxLattice: BoundedDistributiveLattice[Byte] =
    BoundedDistributiveLattice.minMax[Byte](Byte.MinValue, Byte.MaxValue)
}

class ByteAlgebra extends EuclideanRing[Byte] with Serializable {

  def zero: Byte = 0
  def one: Byte = 1

  def plus(x: Byte, y: Byte): Byte = (x + y).toByte
  def negate(x: Byte): Byte = (-x).toByte
  override def minus(x: Byte, y: Byte): Byte = (x - y).toByte

  def times(x: Byte, y: Byte): Byte = (x * y).toByte
  def quot(x: Byte, y: Byte) = (x / y).toByte
  def mod(x: Byte, y: Byte) = (x % y).toByte

  override def pow(x: Byte, y: Int): Byte =
    Math.pow(x.toDouble, y.toDouble).toByte

  def gcd(x: Byte, y: Byte): Byte =
    StaticMethods.gcd(x.toLong, y.toLong).toByte

  override def fromInt(n: Int): Byte = n.toByte
}
