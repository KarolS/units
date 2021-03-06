/*
Copyright (c) 2013-2016 Karol M. Stasiak

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
package io.github.karols.units

import language.higherKinds
import language.implicitConversions
import language.existentials
import io.github.karols.units.internal.ratios._
import io.github.karols.units.internal.Bools._
import io.github.karols.units.internal.Integers._
import io.github.karols.units.internal.Strings._
import io.github.karols.units.internal.SingleUnits._
import io.github.karols.units.internal.UnitImpl._
import io.github.karols.units.internal.UnionType._
import io.github.karols.units.internal.Conversions._
import io.github.karols.units.internal.UnitName
import scala.math

object IntU {
	private val _orderingInstanceVal = new Ordering[IntU[_1]]{
		def compare(x: IntU[_1], y: IntU[_1]) =
			implicitly[Ordering[Long]].compare(x.value, y.value)
	}
	implicit def _orderingInstance[U<:MUnit] =
		_orderingInstanceVal.asInstanceOf[Ordering[IntU[U]]]
}

/** 64-bit signed integer representing a value with a unit of measure.*/
case class IntU[U<:MUnit](val value:Long) extends AnyVal {

	@inline def mkString(implicit name: UnitName[U]) = value.toString + name.toString

	@inline override def toString = value.toString

	@inline def toDouble = new DoubleU[U](value)
	
	/** Add a value with the same unit. */
	@inline def +(i: IntU[U])    = new IntU[U](value + i.value)
	/** Subtract a value with the same unit. */
	@inline def -(i: IntU[U])    = new IntU[U](value - i.value)
	/** Add a value with the same unit. */
	@inline def +(i: DoubleU[U]) = new DoubleU[U](value + i.value)
	/** Subtract a value with the same unit. */
	@inline def -(i: DoubleU[U]) = new DoubleU[U](value - i.value)
	/** Negate this value. */
	@inline def unary_- = new IntU[U](-value)
	
	/** Multiply by a vector. */
	@inline def   *  [V<:MUnit](i: Vector3U[V]) = i*this
	/** Multiply by a vector. */
	@inline def times[V<:MUnit](i: Vector3U[V]) = i*this
	/** Multiply by a vector. */
	@inline def   *  [V<:MUnit](i: Vector2U[V]) = i*this
	/** Multiply by a vector. */
	@inline def times[V<:MUnit](i: Vector2U[V]) = i*this
	
	/** Multiply by a value with a unit. */
	@inline def *[V<:MUnit](i: IntU[V])    = new IntU[U#Mul[V]](value * i.value)
	/** Multiply by a value with a unit. */
	@inline def *[V<:MUnit](i: DoubleU[V]) = new DoubleU[U#Mul[V]](value * i.value)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Int)   = new IntU[U](value * i)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Short) = new IntU[U](value * i)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Byte)  = new IntU[U](value * i)
	/** Multiply by a dimensionless value. */
	@inline def *(i: Float) = new DoubleU[U](value * i)

	/** Multiply by a dimensionless value. */
	@inline def times(i: Long)   = new IntU[U](value * i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Int)    = new IntU[U](value * i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Short)  = new IntU[U](value * i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Byte)   = new IntU[U](value * i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Double) = new DoubleU[U](value * i)
	/** Multiply by a dimensionless value. */
	@inline def times(i: Float)  = new DoubleU[U](value * i)
	
	/** Divide by a value with a unit. */
	@inline def /[V<:MUnit](i: IntU[V])    = new DoubleU[U#Mul[V#Invert]](value.toDouble / i.value)
	/** Divide by a value with a unit. */
	@inline def /[V<:MUnit](i: DoubleU[V]) = new DoubleU[U#Mul[V#Invert]](value / i.value)
	/** Divide by a dimensionless value. */
	@inline def /(i: Int)   = new DoubleU[U](value.toDouble / i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Short) = new DoubleU[U](value.toDouble / i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Byte)  = new DoubleU[U](value.toDouble / i)
	/** Divide by a dimensionless value. */
	@inline def /(i: Float) = new DoubleU[U](value / i)

	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Long)   = new DoubleU[U](value.toDouble / i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Int)    = new DoubleU[U](value.toDouble / i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Short)  = new DoubleU[U](value.toDouble / i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Byte)   = new DoubleU[U](value.toDouble / i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Double) = new DoubleU[U](value / i)
	/** Divide by a dimensionless value. */
	@inline def dividedBy(i: Float)  = new DoubleU[U](value / i)
	
	/** Divide the unit of this value by another unit. */
	@inline def per[V<:MUnit] = new IntU[U/V](value)

	/** Convert to a subunit. */
	@inline
	def convertToInt[V<:MUnit](implicit ev:IntRatio[U,V]) =
		new IntU[V](value * ev.ratio)
	
	/** Convert to another unit. */
	@inline
	def convert[V<:MUnit](implicit ev:DoubleRatio[U,V]) =
		new DoubleU[V](value * ev.ratio)
	
	@inline
	def represent[V<:MUnit,W<:MUnit](implicit ev:DoubleRatio[V,W]) =
		new DoubleU[U#Mul[V#Invert]#Mul[W]](value * ev.ratio)
	
	@inline
	def representAll[V<:TUnitPowerPair, W<:MUnit](
		implicit ev: PowerDoubleRatio[V#UnitName,V#Power,W,U#Get[V#UnitName]]
		) = new DoubleU[U#Mul[(V#UnitName^(U#Get[V#UnitName]))#Invert]#Mul[W#ToPower[U#Get[V#UnitName]]]](value * ev.ratio)

	@inline def < (i: IntU[U]) = value <  i.value
	@inline def <=(i: IntU[U]) = value <= i.value
	@inline def > (i: IntU[U]) = value >  i.value
	@inline def >=(i: IntU[U]) = value >= i.value
	@inline def < (i: DoubleU[U]) = value <  i.value
	@inline def <=(i: DoubleU[U]) = value <= i.value
	@inline def > (i: DoubleU[U]) = value >  i.value
	@inline def >=(i: DoubleU[U]) = value >= i.value

	@inline
	def <~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio < i.value
	@inline
	def <=~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio <= i.value
	@inline
	def >~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio > i.value
	@inline
	def >=~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio >= i.value
	@inline
	def <~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio < i.value
	@inline
	def <=~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio <= i.value
	@inline
	def >~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio > i.value
	@inline
	def >=~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio >= i.value

	@inline
	def ==(i: IntU[U]) = value == i.value
	@inline
	def ==~[V<:MUnit, W<:MUnit: (U∨V)#Union](i: IntU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) =
		value*l.ratio == i.value*r.ratio
	@inline
	def !=(i: IntU[U]) = value != i.value
	@inline
	def !=~[V<:MUnit, W<:MUnit: (U∨V)#Union](i: IntU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) =
		value*l.ratio != i.value*r.ratio
	@inline
	def ==(i: DoubleU[U]) = value == i.value
	@inline
	def ==~[V<:MUnit, W<:MUnit: (U∨V)#Union](i: DoubleU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) =
		value*l.ratio == i.value*r.ratio
	@inline
	def !=(i: DoubleU[U]) = value != i.value
	@inline
	def !=~[V<:MUnit, W<:MUnit: (U∨V)#Union](i: DoubleU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) =
		value*l.ratio != i.value*r.ratio

	/** Add a value with a different unit, coercing to the smaller of them. */
	@inline
	def +[V<:MUnit, W<:MUnit/*: (U∨V)#Union*/](i: IntU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) =
		new IntU[W](value*l.ratio + i.value*r.ratio)
	/** Subtract a value with a different unit, coercing to the smaller of them. */
	@inline
	def -[V<:MUnit, W<:MUnit: (U∨V)#Union](i: IntU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) =
		new IntU[W](value*l.ratio - i.value*r.ratio)
	@inline
	/** Add a value with a different unit, coercing to the smaller of them. */
	def +[V<:MUnit, W<:MUnit: (U∨V)#Union](i: DoubleU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) =
		new DoubleU[W](value*l.ratio.toDouble + i.value*r.ratio.toDouble)
	/** Subtract a value with a different unit, coercing to the smaller of them. */
	@inline
	def -[V<:MUnit, W<:MUnit: (U∨V)#Union](i: DoubleU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) =
		new DoubleU[W](value*l.ratio.toDouble - i.value*r.ratio.toDouble)

	/** Square. */
	@inline def pow2 = this*this
	/** Cube. */
	@inline def pow3 = this*this*this
	/** Fourth power. */
	@inline def pow4 = this*this*this*this
	/** Square root. */
	@inline def sqrt = new DoubleU[U#Sqrt](math.sqrt(value.toDouble))
	/** Cube root. */
	@inline def cbrt = new DoubleU[U#Cbrt](math.cbrt(value.toDouble))
}