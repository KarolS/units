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
package io.github.karols.units.internal

object Conversions {
	import io.github.karols.units.MUnit
	import io.github.karols.units.internal.ratios._

	import language.{higherKinds, implicitConversions}


	@inline
	def productInt[F1<:MUnit,F2<:MUnit,T1<:MUnit,T2<:MUnit](
		implicit r1: BaseIntRatio[F1,T2], r2: BaseIntRatio[F2,T2]
		) = r1*r2
	@inline
	def product[F1<:MUnit,F2<:MUnit,T1<:MUnit,T2<:MUnit](
		implicit r1: DoubleRatio[F1,T2], r2: DoubleRatio[F2,T2]
		) = new BaseDoubleRatio[F1#Mul[F2], T1#Mul[T2]](r1.ratio * r2.ratio)
	@inline
	def alias[F<:MUnit, T<:MUnit] = new BaseIntRatio[F,T](1)


	class OneContainsOfIntBuilder[U<:MUnit](ratio: Long) {
		@inline
		def apply[V<:MUnit]() = new BaseIntRatio[U,V](ratio)
	}
	class OneContainsOfDoubleBuilder[U<:MUnit](ratio: Double) {
		@inline
		def apply[V<:MUnit]() = new BaseDoubleRatio[U,V](ratio)
	}
	class OneBuilder[U<:MUnit] {
		@inline
		def contains(ratio: Long)   = new OneContainsOfIntBuilder[U](ratio)
		@inline
		def contains(ratio: Int)    = new OneContainsOfIntBuilder[U](ratio)
		@inline
		def contains(ratio: Double) = new OneContainsOfDoubleBuilder[U](ratio)
		@inline
		def contains(ratio: Float)  = new OneContainsOfDoubleBuilder[U](ratio)
	}

}