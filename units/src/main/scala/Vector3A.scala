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

object Vector3A {
	/** Zero vector */
	def zero[A<:AffineSpace] = Vector3A(0.0.at[A], 0.0.at[A], 0.0.at[A])
	/** (1,0,0) vector */
	def x[A<:AffineSpace]    = Vector3A(1.0.at[A], 0.0.at[A], 0.0.at[A])
	/** (0,1,0) vector */
	def y[A<:AffineSpace]    = Vector3A(0.0.at[A], 1.0.at[A], 0.0.at[A])
	/** (0,0,1) vector */
	def z[A<:AffineSpace]    = Vector3A(0.0.at[A], 0.0.at[A], 1.0.at[A])
	
	def at[A<:AffineSpace](x: Double, y: Double, z: Double) = Vector3A(x.at[A], y.at[A], z.at[A])
}

/** A three-dimensional vector within an affine space */
case class Vector3A[A<:AffineSpace](val x:DoubleA[A], val y:DoubleA[A], val z:DoubleA[A]) {
	@inline
	def mkString(implicit name: UnitName[A#Unit]) = toString + name.toString
	@inline
	override def toString = "[" + x.value + "," + y.value + "," + z.value + "]"
	@inline
	def value = (x.value, y.value, z.value)
	
	/** Add a value with the same unit. */
	@inline def +(i: Vector3U[A#Unit]): Vector3A[A] = Vector3A(x+i.x, y+i.y, z+i.z)
	/** Subtract a value with the same unit. */
	@inline def -(i: Vector3U[A#Unit]): Vector3A[A] = Vector3A(x-i.x, y-i.y, z-i.z)
	/** Subtract a value within the same affine space. */
	@inline def --(i: Vector3A[A]): Vector3U[A#Unit] = Vector3U(x--i.x, y--i.y, z--i.z)

	/** Convert to another unit. */
	@inline def convert[B<:AffineSpace](implicit ev:DoubleAffineSpaceConverter[A,B]) =
		Vector3A(x.convert[B], y.convert[B], z.convert[B])
	
	def fromZero = Vector3U(x.fromZero, y.fromZero, z.fromZero)

}


