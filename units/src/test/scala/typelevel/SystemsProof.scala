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
package stasiak.karol.units.typelevel

import stasiak.karol.units._
import stasiak.karol.units.defining._
import stasiak.karol.units.SI._
import stasiak.karol.units.USCustomary._

// This trait has only to compile
sealed trait SystemsProof{

	type L = DefineUnit[_L]
	type T = DefineUnit[_T]

	val MPS = System2[L, metre, T, second]

	{
		def speed(distance: DoubleU[L], time: DoubleU[T]) : DoubleU[L/T] = distance/time
		val l = 2.0.of[metre]
		val t = 1.0.of[second]
		val MPS(v) = speed(MPS[L](l), MPS[T](t))
		val v2: DoubleU[metre/second] = v
	}
	{
		def position(x0: DoubleU[L], v0: DoubleU[L/T], a: DoubleU[L/square[T]], t:DoubleU[T]) =
			x0 + v0*t + a*t*t/2

		val x0 = 5.of[metre]
		val v0 = 1.of[metre/second]
		val a = 0.5.of[metre/square[second]]
		val t = 30.of[second]

		val MPS(result) = position(MPS[L](x0), MPS[L/T](v0), MPS[L/square[T]](a), MPS[T](t))
	}
	{
		import stasiak.karol.units.Mechanical._
		import stasiak.karol.units.SI._
		def position(x0: DoubleU[length], v0: DoubleU[speed], a: DoubleU[acceleration], t:DoubleU[time]) =
			x0 + v0*t + a*t*t/2

		val x0 = 5.of[metre]
		val v0 = 1.of[metre/second]
		val a = 0.5.of[metre/square[second]]
		val t = 30.of[second]

		val MKS(result) = position(MKS[length](x0), MKS[speed](v0), MKS[acceleration](a), MKS[time](t))
	}
}