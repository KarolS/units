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

import scalaz.{Ordering, Monoid, Show, Order, Equal}

package object scalazSupport {

	implicit def implicit__doubleUInstance[U<:MUnit]:
		Monoid[DoubleU[U]] with Order[DoubleU[U]] with Show[DoubleU[U]] =
		new Monoid[DoubleU[U]] with Order[DoubleU[U]] with Show[DoubleU[U]] {

		override def shows(f: DoubleU[U]) = f.value.toString

		def append(f1: DoubleU[U], f2: => DoubleU[U]) = f1 + f2

		def zero: DoubleU[U] = 0.0.of[U]

		override def equalIsNatural: Boolean = true

		def order(x: DoubleU[U], y: DoubleU[U]) =
			if (x < y) scalaz.Ordering.LT else if (x == y) scalaz.Ordering.EQ else scalaz.Ordering.GT
	}

	implicit def implicit__intUInstance[U<:MUnit]:
		Monoid[IntU[U]] with Order[IntU[U]] with Show[IntU[U]] =
		new Monoid[IntU[U]] with Order[IntU[U]] with Show[IntU[U]] {

		override def shows(f: IntU[U]) = f.value.toString

		def append(f1: IntU[U], f2: => IntU[U]) = f1 + f2

		def zero: IntU[U] = 0.of[U]

		override def equalIsNatural: Boolean = true

		def order(x: IntU[U], y: IntU[U]) =
			if (x < y) scalaz.Ordering.LT else if (x == y) scalaz.Ordering.EQ else scalaz.Ordering.GT
	}

	implicit def implicit__doubleAInstance[A<:AffineSpace]:
		Order[DoubleA[A]] with Show[DoubleA[A]] =
		new Order[DoubleA[A]] with Show[DoubleA[A]] {

		override def shows(f: DoubleA[A]) = f.value.toString

		override def equalIsNatural: Boolean = true

		def order(x: DoubleA[A], y: DoubleA[A]) =
			if (x < y) scalaz.Ordering.LT else if (x == y) scalaz.Ordering.EQ else scalaz.Ordering.GT
	}

	implicit def implicit__intAInstance[A<:AffineSpace]:
		Order[IntA[A]] with Show[IntA[A]] =
		new Order[IntA[A]] with Show[IntA[A]] {

		override def shows(f: IntA[A]) = f.toString

		override def equalIsNatural: Boolean = true

		def order(x: IntA[A], y: IntA[A]) =
			if (x < y) scalaz.Ordering.LT else if (x == y) scalaz.Ordering.EQ else scalaz.Ordering.GT
	}

	implicit def implicit__vector3UInstance[U<:MUnit] =
		new Equal[Vector3U[U]] with Show[Vector3U[U]] with Monoid[Vector3U[U]] {
			override def shows(f: Vector3U[U]) = f.toString
			override def equalIsNatural: Boolean = true
			def append(f1: Vector3U[U], f2: => Vector3U[U]) = f1 + f2
			def zero: Vector3U[U] = Vector3U.zero[U]
			def equal(f1: Vector3U[U], f2: Vector3U[U]) = f1 == f2
		}

	implicit def implicit__vector2UInstance[U<:MUnit] =
		new Equal[Vector2U[U]] with Show[Vector2U[U]] with Monoid[Vector2U[U]] {
			override def shows(f: Vector2U[U]) = f.toString
			override def equalIsNatural: Boolean = true
			def append(f1: Vector2U[U], f2: => Vector2U[U]) = f1 + f2
			def zero: Vector2U[U] = Vector2U.zero[U]
			def equal(f1: Vector2U[U], f2: Vector2U[U]) = f1 == f2
		}

	implicit def implicit__vector2AInstance[A<:AffineSpace] =
		new Equal[Vector2A[A]] with Show[Vector2A[A]] {
			override def shows(f: Vector2A[A]) = f.toString
			override def equalIsNatural: Boolean = true
			def equal(f1: Vector2A[A], f2: Vector2A[A]) = f1 == f2
		}

	implicit def implicit__vector3AInstance[A<:AffineSpace] =
		new Equal[Vector3A[A]] with Show[Vector3A[A]] {
			override def shows(f: Vector3A[A]) = f.toString
			override def equalIsNatural: Boolean = true
			def equal(f1: Vector3A[A], f2: Vector3A[A]) = f1 == f2
		}

}