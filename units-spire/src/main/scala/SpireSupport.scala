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

import scala.math.Numeric
import spire.algebra._ 
import spire.math._ 
import stasiak.karol.units._
import language.implicitConversions

package object spireSupport {

	implicit def implicit__doubleU[U<:MUnit] = new VectorSpace[DoubleU[U], Double] {

		implicit def scalar: Field[Double] = Field[Double]

		override def additive: AbGroup[DoubleU[U]] = new AbGroup[DoubleU[U]] {
			def id = 0.0.of[U]
			def op(x: DoubleU[U], y: DoubleU[U]) = x + y
			def inverse(x: DoubleU[U]) = -x
		}

		def zero = 0.0.of[U]
		def negate(x: DoubleU[U]) = -x
		override def minus(x: DoubleU[U], y: DoubleU[U]) = x - y
		def plus(x: DoubleU[U], y: DoubleU[U]) = x + y
		def timesl(d: Double, x: DoubleU[U]) = x times d
		override def divr(x: DoubleU[U], d: Double) = x dividedBy d
	}
	
	implicit def implicit__withU[N,U<:MUnit](implicit n: Numeric[N]) = new Module[Any, N] {

		implicit def scalar: Ring[N] = Ring[N]

		override def additive: AbGroup[Any] = new AbGroup[Any] {
			def id: Any = n.zero.of[U].asInstanceOf[Any]
			def op(x: Any, y: Any): Any = 
				x.asInstanceOf[WithU[N,U]] + y.asInstanceOf[WithU[N,U]]
			def inverse(x: Any): Any = -x.asInstanceOf[WithU[N,U]]
		}

		def zero: Any = n.zero.of[U]
		def negate(x: Any): Any = -x.asInstanceOf[WithU[N,U]]
		override def minus(x: Any, y: Any): Any = 
			x.asInstanceOf[WithU[N,U]] - y.asInstanceOf[WithU[N,U]]
		def plus(x: Any, y: Any): Any = 
			x.asInstanceOf[WithU[N,U]] + y.asInstanceOf[WithU[N,U]]
		def timesl(d: N, x: Any): Any = x.asInstanceOf[WithU[N,U]] times d
		
	}.asInstanceOf[Module[WithU[N,U],N]]
	
	implicit def intUI[U<:MUnit] = new Module[IntU[U], Int] {

		implicit def scalar: Ring[Int] = Ring[Int]

		override def additive: AbGroup[IntU[U]] = new AbGroup[IntU[U]] {
			def id = 0.of[U]
			def op(x: IntU[U], y: IntU[U]): IntU[U] = x + y
			def inverse(x: IntU[U]): IntU[U] = -x
		}

		def zero = 0.of[U]
		def negate(x: IntU[U]): IntU[U] = -x
		override def minus(x: IntU[U], y: IntU[U]): IntU[U] = x - y
		def plus(x: IntU[U], y: IntU[U]): IntU[U] = x + y
		def timesl(d: Int, x: IntU[U]): IntU[U] = x * d
		
	}

	implicit def implicit__intUL[U<:MUnit] = new Module[IntU[U], Long] {

		implicit def scalar: Ring[Long] = Ring[Long]

		override def additive: AbGroup[IntU[U]] = new AbGroup[IntU[U]] {
			def id = 0.of[U]
			def op(x: IntU[U], y: IntU[U]): IntU[U] = x + y
			def inverse(x: IntU[U]): IntU[U] = -x
		}

		def zero = 0.of[U]
		def negate(x: IntU[U]): IntU[U] = -x
		override def minus(x: IntU[U], y: IntU[U]): IntU[U] = x - y
		def plus(x: IntU[U], y: IntU[U]): IntU[U] = x + y
		def timesl(d: Long, x: IntU[U]): IntU[U] = x times d
		
	}

	implicit def implicit__vector3U[U<:MUnit] = new VectorSpace[Vector3U[U], Double] {

		implicit def scalar: Field[Double] = Field[Double]

		override def additive: AbGroup[Vector3U[U]] = new AbGroup[Vector3U[U]] {
			def id = Vector3U.zero[U]
			def op(x: Vector3U[U], y: Vector3U[U]) = x + y
			def inverse(x: Vector3U[U]) = -x
		}

		def zero = Vector3U.zero[U]
		def negate(x: Vector3U[U]) = -x
		override def minus(x: Vector3U[U], y: Vector3U[U]) = x - y
		def plus(x: Vector3U[U], y: Vector3U[U]) = x + y
		def timesl(d: Double, x: Vector3U[U]) = x times d
		override def divr(x: Vector3U[U], d: Double) = x dividedBy d
	}

	implicit def implicit__vector2U[U<:MUnit] = new VectorSpace[Vector2U[U], Double] {

		implicit def scalar: Field[Double] = Field[Double]

		override def additive: AbGroup[Vector2U[U]] = new AbGroup[Vector2U[U]] {
			def id = Vector2U.zero[U]
			def op(x: Vector2U[U], y: Vector2U[U]) = x + y
			def inverse(x: Vector2U[U]) = -x
		}

		def zero = Vector2U.zero[U]
		def negate(x: Vector2U[U]) = -x
		override def minus(x: Vector2U[U], y: Vector2U[U]) = x - y
		def plus(x: Vector2U[U], y: Vector2U[U]) = x + y
		def timesl(d: Double, x: Vector2U[U]) = x times d
		override def divr(x: Vector2U[U], d: Double) = x dividedBy d
	}

}
