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
package io.github.karols.units.internal.ratios
import io.github.karols.units._
import io.github.karols.units.defining._

class DoubleAffineSpaceConverter[T1<:AffineSpace, T2<:AffineSpace](val f: Double => Double)

object DoubleAffineSpaceConverter {

	@inline
	implicit def implicit_twoWayDoubleAConverterF[A<:AffineSpace, B<:AffineSpace](
		implicit ev: ReversibleDoubleAConversion[A,B]
	) = new DoubleAffineSpaceConverter[A,B](ev.forward)

	@inline
	implicit def implicit_twoWayDoubleAConverterB[A<:AffineSpace, B<:AffineSpace](
		implicit ev: ReversibleDoubleAConversion[A,B]
	) = new DoubleAffineSpaceConverter[B,A](ev.backward)

	@inline
	implicit def implicit_oneDoubleAffineSpaceConverter[U<:AffineSpace] = new DoubleAffineSpaceConverter[U,U](_)
}