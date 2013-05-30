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
import stasiak.karol.units.internal.Bools._
import stasiak.karol.units.internal.Integers._
import stasiak.karol.units.internal.Strings._
import stasiak.karol.units.internal.SingleUnits._
import stasiak.karol.units.internal.UnitImpl._
import stasiak.karol.units.internal.Conversions._
import stasiak.karol.units.internal.AffineSpaces._

/** Double-precision floating-point value representing a point in a 1-dimensional affine space.*/
case class DoubleA[A<:AffineSpace](val value: Double) extends AnyVal {

	@inline def +(i: IntU[A#Unit])    = new DoubleA[A](value + i.value)
	@inline def -(i: IntU[A#Unit])    = new DoubleA[A](value - i.value)
	@inline def +(i: DoubleU[A#Unit]) = new DoubleA[A](value + i.value)
	@inline def -(i: DoubleU[A#Unit]) = new DoubleA[A](value - i.value)
	
	@inline def --(i: IntA[A]) = new DoubleU[A#Unit](value - i.value)
	@inline def --(i: DoubleA[A]) = new DoubleU[A#Unit](value - i.value)
	
	@inline
	def changeUnit[U<:MUnit](implicit ev: DoubleRatio[A#Unit, U]) = 
		new DoubleA[DefineAffineSpace[A#Zero, U]](value * ev.ratio)

	@inline
	def convert[B<:AffineSpace](implicit ev: DoubleAffineSpaceConverter[A,B]) = 
		new DoubleA[B](ev.f(value))

	@inline def fromZero = new DoubleU[A#Unit](value)

	@inline def mkString(implicit name: UnitName[A#Unit]) = value.toString + name.toString

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
}


