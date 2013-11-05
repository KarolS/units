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
package stasiak.units

import language.higherKinds
import language.implicitConversions
import language.existentials
import stasiak.units.internal.ratios._
import stasiak.units.internal.Bools._
import stasiak.units.internal.Integers._
import stasiak.units.internal.Strings._
import stasiak.units.internal.SingleUnits._
import stasiak.units.internal.UnitImpl._
import stasiak.units.internal.Conversions._
import stasiak.units.internal.UnionType._
import stasiak.units.internal.UnitName
import scala.math

object Vector2A {
	/** Zero vector */
	def zero[A<:AffineSpace] = Vector2A(0.0.at[A], 0.0.at[A])
	/** (1,0) vector */
	def x[A<:AffineSpace]    = Vector2A(1.0.at[A], 0.0.at[A])
	/** (0,1) vector */
	def y[A<:AffineSpace]    = Vector2A(0.0.at[A], 1.0.at[A])

	def at[A<:AffineSpace](x: Double, y: Double) = Vector2A(x.at[A], y.at[A])
}

/** A two-dimensional vector within an affine space */
case class Vector2A[A<:AffineSpace](val x:DoubleA[A], val y:DoubleA[A]) {
	@inline
	def mkString(implicit name: UnitName[A#Unit]) = toString + name.toString
	@inline
	override def toString = "[" + x.value + "," + y.value + "]"
	@inline
	def value = (x.value, y.value)
	
	/** Add a value with the same unit. */
	@inline def +(i: Vector2U[A#Unit]): Vector2A[A] = Vector2A(x+i.x, y+i.y)
	/** Subtract a value with the same unit. */
	@inline def -(i: Vector2U[A#Unit]): Vector2A[A] = Vector2A(x-i.x, y-i.y)
	/** Subtract a value within the same affine space. */
	@inline def --(i: Vector2A[A]): Vector2U[A#Unit] = Vector2U(x--i.x, y--i.y)

	/** Convert to another unit. */
	@inline def convert[B<:AffineSpace](implicit ev:DoubleAffineSpaceConverter[A,B]) =
		Vector2A(x.convert[B], y.convert[B])
	
	def fromZero = Vector2U(x.fromZero, y.fromZero)

}


