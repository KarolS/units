/*
Copyright (c) 2013 Karol M. Stasiak

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package stasiak.karol.units

import language.higherKinds
import language.implicitConversions
import language.existentials
import stasiak.karol.units.internal.ratios._
import stasiak.karol.units.internal.Bools._
import stasiak.karol.units.internal.Integers._
import stasiak.karol.units.internal.Strings._
import stasiak.karol.units.internal.SingleUnits._
import stasiak.karol.units.internal.UnitImpl._
import stasiak.karol.units.internal.Conversions._
import stasiak.karol.units.internal.UnionType._
import stasiak.karol.units.internal.UnitName
import scala.math

object Vector2U {
	/** Zero vector */
	def zero[U<:MUnit] = Vector2U(0.0.of[U], 0.0.of[U])
	/** (1,0) vector */
	def x[U<:MUnit]    = Vector2U(1.0.of[U], 0.0.of[U])
	/** (0,1) vector */
	def y[U<:MUnit]    = Vector2U(0.0.of[U], 1.0.of[U])
	def of[U<:MUnit](x: Double, y: Double) = Vector2U(x.of[U], y.of[U])
}

/** A two-dimensional vector with a unit */
case class Vector2U[U<:MUnit](val x:DoubleU[U], val y:DoubleU[U]) {
	@inline
	def mkString(implicit name: UnitName[U]) = toString + name.toString
	@inline
	override def toString = "[" + x.value + "," + y.value + "]"
	
	/** Return the value as a pair of Doubles. */
	@inline
	def value = (x.value, y.value)
	
	/** Add a value with the same unit. */
	@inline def +(i: Vector2U[U]) = Vector2U(x+i.x, y+i.y)
	/** Subtract a value with the same unit. */
	@inline def -(i: Vector2U[U]) = Vector2U(x-i.x, y-i.y)
	/** Negate this value. */
	@inline def unary_- = Vector2U(-x, -y)

	/** Dot product. */
	@inline def *[V<:MUnit](i: Vector2U[V]) = new DoubleU[U#Mul[V]](x.value*i.x.value + y.value*i.y.value)
	
	/** Multiply by a value with a unit. */
	@inline def *[V<:MUnit](i: IntU[V]) = new Vector2U[U#Mul[V]]((x.value*i.value).of, (y.value*i.value).of)
	/** Multiply by a value with a unit. */
	@inline def *[V<:MUnit](i: DoubleU[V]) = new Vector2U[U#Mul[V]]((x.value*i.value).of, (y.value*i.value).of)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Int) = Vector2U[U]((x.value*i).of, (y.value*i).of)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Short) = Vector2U[U]((x.value*i).of, (y.value*i).of)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Byte) = Vector2U[U]((x.value*i).of, (y.value*i).of)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Float) = Vector2U[U]((x.value*i).of, (y.value*i).of)
	
	/** Multiply by a dimensionless value. */
	@inline def times(i: Long) = new Vector2U[U](x times i, y times i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Int) = new Vector2U[U](x times i, y times i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Short) = new Vector2U[U](x times i, y times i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Byte) = new Vector2U[U](x times i, y times i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Double) = new Vector2U[U](x times i, y times i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Float) = new Vector2U[U](x times i, y times i)
	
	/** Divide by a value with a unit. */
	@inline def /[V<:MUnit](i: IntU[V]) = new Vector2U[U#Mul[V#Invert]](x/i, y/i)
	/** Divide by a value with a unit. */
	@inline def /[V<:MUnit](i: DoubleU[V]) = new Vector2U[U#Mul[V#Invert]](x/i, y/i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Int) = new Vector2U[U](x/i, y/i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Short) = new Vector2U[U](x/i, y/i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Byte) = new Vector2U[U](x/i, y/i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Float) = new Vector2U[U](x/i, y/i)
	
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Long) = Vector2U(x dividedBy i, y dividedBy i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Int) = Vector2U(x dividedBy i, y dividedBy i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Short) = Vector2U(x dividedBy i, y dividedBy i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Byte) = Vector2U(x dividedBy i, y dividedBy i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Double) = Vector2U(x dividedBy i, y dividedBy i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Float) = Vector2U(x dividedBy i, y dividedBy i)

	/** Convert to another unit. */
	@inline def convert[V<:MUnit](implicit ev:DoubleRatio[U,V]) =
		Vector2U(x.convert[V], y.convert[V])
	
	@inline def represent[V<:MUnit,W<:MUnit](implicit ev:DoubleRatio[V,W]) =
		Vector2U(x.represent[V,W], y.represent[V,W])
	
	@inline def representAll[V<:TUnitPowerPair, W<:MUnit](
		implicit ev: PowerDoubleRatio[V#UnitName,V#Power,W,U#Get[V#UnitName]]) =
			Vector2U(x.representAll[V,W], y.representAll[V,W])

	/** Add a value with a different unit, coercing to the smaller of them. */
	@inline
	def +[V<:MUnit, W<:MUnit: (U∨V)#Union](i: Vector2U[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) =
		Vector2U[W](x+i.x, y+i.y)
	/** Subract a value with a different unit, coercing to the smaller of them. */
	@inline
	def -[V<:MUnit, W<:MUnit: (U∨V)#Union](i: Vector2U[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) =
		Vector2U[W](x-i.x, y-i.y)


	/** Square of length of this vector */
	@inline def absSq = x*x + y*y
	/** Euclidean length of this vector */
	@inline def abs = new DoubleU[U](math.sqrt(x.value*x.value + y.value*y.value))
	/** Euclidean length of this vector */
	@inline def length = abs
	/** Square of length of this vector */
	@inline def lengthSq = absSq

	/** A vector with the same direction and length 1 */
	@inline def unit = {
		val l = length.value
		Vector2U[_1](x.value/l, y.value/l)
	}

}


