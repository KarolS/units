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
import stasiak.karol.units.internal.ratios._
import stasiak.karol.units.internal.Bools._
import stasiak.karol.units.internal.Integers._
import stasiak.karol.units.internal.Strings._
import stasiak.karol.units.internal.SingleUnits._
import stasiak.karol.units.internal.UnitImpl._
import stasiak.karol.units.internal.Conversions._
import stasiak.karol.units.internal.AffineSpaces._
import stasiak.karol.units.internal.UnitName

object IntA {
	private type Aff = DefineAffineSpace[Nothing, _1]
	private val _orderingInstanceVal = new Ordering[IntA[Aff]]{
		def compare(x: IntA[Aff], y: IntA[Aff]) = 
			implicitly[Ordering[Long]].compare(x.value, y.value)
	}
	implicit def _orderingInstance[A<:AffineSpace] = 
		_orderingInstanceVal.asInstanceOf[Ordering[IntA[A]]]
}

/** 64-bit signed integer representing a point in a 1-dimensional affine space.*/
case class IntA[A<:AffineSpace](val value: Long) extends AnyVal{

	@inline def +(i: IntU[A#Unit])    = new IntA[A](value + i.value)
	@inline def -(i: IntU[A#Unit])    = new IntA[A](value - i.value)
	@inline def +(i: DoubleU[A#Unit]) = new DoubleA[A](value.toDouble + i.value)
	@inline def -(i: DoubleU[A#Unit]) = new DoubleA[A](value.toDouble - i.value)

	@inline def --(i: IntA[A])    = new IntU[A#Unit](value - i.value)
	@inline def --(i: DoubleA[A]) = new DoubleU[A#Unit](value.toDouble - i.value)

	@inline
	def changeUnitInt[U<:MUnit](implicit ev: IntRatio[A#Unit, U]) = 
		new IntA[DefineAffineSpace[A#Zero, U]](value * ev.ratio)
	@inline
	def changeUnit[U<:MUnit](implicit ev: DoubleRatio[A#Unit, U]) = 
		new DoubleA[DefineAffineSpace[A#Zero, U]](value.toDouble * ev.ratio)
	@inline
	def convertToInt[B<:AffineSpace](implicit ev: IntAffineSpaceConverter[A,B]) = 
		new IntA[B](ev.f(value))
	@inline
	def convert[B<:AffineSpace](implicit ev: DoubleAffineSpaceConverter[A,B]) = 
		new DoubleA[B](ev.f(value.toDouble))

	@inline def fromZero = new IntU[A#Unit](value)

	@inline def mkString(implicit name: UnitName[A#Unit]) = value.toString + name.toString
	
	@inline def toDouble = new DoubleA[A](value.toDouble)

	@inline def < (i: IntA[A]) = value <  i.value
	@inline def <=(i: IntA[A]) = value <= i.value
	@inline def > (i: IntA[A]) = value >  i.value
	@inline def >=(i: IntA[A]) = value >= i.value
	@inline def < (i: DoubleA[A]) = value <  i.value
	@inline def <=(i: DoubleA[A]) = value <= i.value
	@inline def > (i: DoubleA[A]) = value >  i.value
	@inline def >=(i: DoubleA[A]) = value >= i.value

	@inline
	def <~[B<:AffineSpace](i: IntA[B])(implicit ev: DoubleAffineSpaceConverter[A,B]) = ev.f(value) < i.value
	@inline
	def <=~[B<:AffineSpace](i: IntA[B])(implicit ev: DoubleAffineSpaceConverter[A,B]) = ev.f(value) <= i.value
	@inline
	def >~[B<:AffineSpace](i: IntA[B])(implicit ev: DoubleAffineSpaceConverter[A,B]) = ev.f(value) > i.value
	@inline
	def >=~[B<:AffineSpace](i: IntA[B])(implicit ev: DoubleAffineSpaceConverter[A,B]) = ev.f(value) >= i.value
	@inline
	def <~[B<:AffineSpace](i: DoubleA[B])(implicit ev: DoubleAffineSpaceConverter[A,B]) = ev.f(value) < i.value
	@inline
	def <=~[B<:AffineSpace](i: DoubleA[B])(implicit ev: DoubleAffineSpaceConverter[A,B]) = ev.f(value) <= i.value
	@inline
	def >~[B<:AffineSpace](i: DoubleA[B])(implicit ev: DoubleAffineSpaceConverter[A,B]) = ev.f(value) > i.value
	@inline
	def >=~[B<:AffineSpace](i: DoubleA[B])(implicit ev: DoubleAffineSpaceConverter[A,B]) = ev.f(value) >= i.value

	@inline
	def ==(i: IntA[A]) = value == i.value
	@inline
	def ==(i: DoubleA[A]) = value == i.value
	@inline
	def !=(i: IntA[A]) = value != i.value
	@inline
	def !=(i: DoubleA[A]) = value != i.value

}