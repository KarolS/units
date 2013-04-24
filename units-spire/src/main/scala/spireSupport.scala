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

import spire.algebra._ 
import spire.math._ 
import stasiak.karol.units._
import language.implicitConversions

package object spireSupport {

	implicit def doubleU[U<:MUnit] = new VectorSpace[DoubleU[U], Double] {

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

	implicit def intUL[U<:MUnit] = new Module[IntU[U], Long] {

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
}
