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

object Vector3U {
	/** Zero vector */
	def zero[U<:MUnit] = Vector3U(0.0.of[U], 0.0.of[U], 0.0.of[U])
	/** (1,0,0) vector */
	def x[U<:MUnit]    = Vector3U(1.0.of[U], 0.0.of[U], 0.0.of[U])
	/** (0,1,0) vector */
	def y[U<:MUnit]    = Vector3U(0.0.of[U], 1.0.of[U], 0.0.of[U])
	/** (0,0,1) vector */
	def z[U<:MUnit]    = Vector3U(0.0.of[U], 0.0.of[U], 1.0.of[U])
	def of[U<:MUnit](x: Double, y: Double, z: Double) = Vector3U(x.of[U], y.of[U], z.of[U])
}

/** A three-dimensional vector with a unit */
case class Vector3U[U<:MUnit](val x:DoubleU[U], val y:DoubleU[U], val z:DoubleU[U]) {
	@inline
	def mkString(implicit name: UnitName[U]) = toString + name.toString
	@inline
	override def toString = "[" + x.value + "," + y.value + "," + z.value + "]"
	@inline 
	def value = (x.value, y.value, z.value)
	
	/** Add a value with the same unit. */
	@inline def +(i: Vector3U[U]) = Vector3U(x+i.x, y+i.y, z+i.z)
	/** Subtract a value with the same unit. */
	@inline def -(i: Vector3U[U]) = Vector3U(x-i.x, y-i.y, z-i.z)
	/** Negate this value. */
	@inline def unary_- = Vector3U(-x, -y, -z)

	/** Dot product. */
	@inline def *[V<:MUnit](i: Vector3U[V]) = new DoubleU[U#Mul[V]](x.value*i.x.value + y.value*i.y.value + z.value*i.z.value)
	
	/** Multiply by a value with a unit. */
	@inline def *[V<:MUnit](i: IntU[V]) = new Vector3U[U#Mul[V]]((x.value*i.value).of, (y.value*i.value).of, (z.value*i.value).of)
	/** Multiply by a value with a unit. */
	@inline def *[V<:MUnit](i: DoubleU[V]) = new Vector3U[U#Mul[V]]((x.value*i.value).of, (y.value*i.value).of, (z.value*i.value).of)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Int) = Vector3U[U]((x.value*i).of, (y.value*i).of, (z.value*i).of)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Short) = Vector3U[U]((x.value*i).of, (y.value*i).of, (z.value*i).of)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Byte) = Vector3U[U]((x.value*i).of, (y.value*i).of, (z.value*i).of)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Float) = Vector3U[U]((x.value*i).of, (y.value*i).of, (z.value*i).of)
	
	/** Multiply by a dimensionless value. */
	@inline def times(i: Long) = new Vector3U[U](x times i, y times i, z times i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Int) = new Vector3U[U](x times i, y times i, z times i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Short) = new Vector3U[U](x times i, y times i, z times i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Byte) = new Vector3U[U](x times i, y times i, z times i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Double) = new Vector3U[U](x times i, y times i, z times i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Float) = new Vector3U[U](x times i, y times i, z times i)
	
	/** Divide by a value with a unit. */
	@inline def /[V<:MUnit](i: IntU[V]) = new Vector3U[U#Mul[V#Invert]](x/i, y/i, z/i)
	/** Divide by a value with a unit. */
	@inline def /[V<:MUnit](i: DoubleU[V]) = new Vector3U[U#Mul[V#Invert]](x/i, y/i, z/i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Int) = new Vector3U[U](x/i, y/i, z/i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Short) = new Vector3U[U](x/i, y/i, z/i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Byte) = new Vector3U[U](x/i, y/i, z/i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Float) = new Vector3U[U](x/i, y/i, z/i)
	
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Long) = Vector3U(x dividedBy i, y dividedBy i, z dividedBy i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Int) = Vector3U(x dividedBy i, y dividedBy i, z dividedBy i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Short) = Vector3U(x dividedBy i, y dividedBy i, z dividedBy i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Byte) = Vector3U(x dividedBy i, y dividedBy i, z dividedBy i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Double) = Vector3U(x dividedBy i, y dividedBy i, z dividedBy i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Float) = Vector3U(x dividedBy i, y dividedBy i, z dividedBy i)

	/** Convert to another unit. */
	@inline def convert[V<:MUnit](implicit ev:DoubleRatio[U,V]) = 
		Vector3U(x.convert[V], y.convert[V], z.convert[V])
	
	@inline def represent[V<:MUnit,W<:MUnit](implicit ev:DoubleRatio[V,W]) = 
		Vector3U(x.represent[V,W], y.represent[V,W], z.represent[V,W])
	 
	@inline def representAll[V<:TUnitPowerPair, W<:MUnit](
		implicit ev: PowerDoubleRatio[V#UnitName,V#Power,W,U#Get[V#UnitName]]) =
			Vector3U(x.representAll[V,W], y.representAll[V,W], z.representAll[V,W])

	/** Add a value with a different unit, coercing to the smaller of them. */
	@inline
	def +[V<:MUnit, W<:MUnit: (U∨V)#Union](i: Vector3U[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
		Vector3U[W](x+i.x, y+i.y, z+i.z)
	/** Subract a value with a different unit, coercing to the smaller of them. */
	@inline
	def -[V<:MUnit, W<:MUnit: (U∨V)#Union](i: Vector3U[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
		Vector3U[W](x-i.x, y-i.y, z-i.z)


	/** Square of length of this vector */
	@inline def absSq: DoubleU[U#Mul[U]] = x*x + y*y + z*z
	/** Euclidean length of this vector */
	@inline def abs = new DoubleU[U](math.sqrt(x.value*x.value + y.value*y.value + z.value*z.value))
	/** Euclidean length of this vector */
	@inline def length = abs
	/** Square of length of this vector */
	@inline def lengthSq = absSq

	/** Cross product */
	@inline def ***[V<:MUnit](i: Vector3U[V]) = this × i
	/** Cross product */
	@inline def ×[V<:MUnit](i: Vector3U[V]) = Vector3U[U](
		(y.value*i.z.value - z.value*i.y.value).of[U],
		(z.value*i.x.value - x.value*i.z.value).of[U],
		(x.value*i.y.value - y.value*i.x.value).of[U])

	/** A vector with the same direction and length 1 */
	@inline def unit: Vector3U[TDimensionless] = {
		val l = length.value
		Vector3U[_1](x.value/l, y.value/l, z.value/l)
	}

}


