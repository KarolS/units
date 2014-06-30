/*
Copyright (c) 2013-2014 Karol M. Stasiak

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

import io.github.karols.units.SI._
import io.github.karols.units.SI.Short._
import scala.math.Numeric
import com.twitter.algebird._
import language.implicitConversions

package object algebirdSupport {
	implicit def implicit__doubleUInstancep[U<:MUnit] =
		new Monoid[DoubleU[U]] with Group[DoubleU[U]] with VectorSpace[Double, ({type T[Ign]=DoubleU[U]})#T] {
			implicit def field: Field[Double] = implicitly[Field[Double]]
			implicit def group: Group[DoubleU[U]] = this
			def zero = 0.0.of[U]
			def plus(x: DoubleU[U], y: DoubleU[U]) = x + y
			def scale(a: Double, x: DoubleU[U]) = x times a
			override def negate(x: DoubleU[U]) = -x
			override def minus(x: DoubleU[U], y: DoubleU[U]) = x - y
		}
	implicit def implicit__intUInstancep[U<:MUnit] =
		new Monoid[IntU[U]] with Group[IntU[U]] {
			def zero = 0.of[U]
			def plus(x: IntU[U], y: IntU[U]) = x + y
			override def negate(x: IntU[U]) = -x
			override def minus(x: IntU[U], y: IntU[U]) = x - y
		}

	implicit def implicit__withUInstance[N, U<:MUnit](implicit n: Numeric[N]) =
		new Monoid[Any] with Group[Any] {
			def zero: Any = n.zero.of[U]
			def plus(x: Any, y: Any): Any =
				x.asInstanceOf[WithU[N,U]] + y.asInstanceOf[WithU[N,U]]
			override def negate(x: Any): Any = -x.asInstanceOf[WithU[N,U]]
			override def minus(x: Any, y: Any): Any =
				x.asInstanceOf[WithU[N,U]] - y.asInstanceOf[WithU[N,U]]
		}.asInstanceOf[Monoid[WithU[N,U]] with Group[WithU[N,U]]]

	implicit def implicit__vector2UInstancep[U<:MUnit] =
		new Monoid[Vector2U[U]] with Group[Vector2U[U]] with VectorSpace[Double, ({type T[Ign]=Vector2U[U]})#T] {
			implicit def field: Field[Double] = implicitly[Field[Double]]
			implicit def group: Group[Vector2U[U]] = this
			def zero = Vector2U.zero[U]
			def plus(x: Vector2U[U], y: Vector2U[U]) = x + y
			def scale(a: Double, x: Vector2U[U]) = x times a
			override def negate(x: Vector2U[U]) = -x
			override def minus(x: Vector2U[U], y: Vector2U[U]) = x - y
		}
	implicit def implicit__vector3UInstancep[U<:MUnit] =
		new Monoid[Vector3U[U]] with Group[Vector3U[U]] with VectorSpace[Double, ({type T[Ign]=Vector3U[U]})#T] {
			implicit def field: Field[Double] = implicitly[Field[Double]]
			implicit def group: Group[Vector3U[U]] = this
			def zero = Vector3U.zero[U]
			def plus(x: Vector3U[U], y: Vector3U[U]) = x + y
			def scale(a: Double, x: Vector3U[U]) = x times a
			override def negate(x: Vector3U[U]) = -x
			override def minus(x: Vector3U[U], y: Vector3U[U]) = x - y
		}
}