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
package stasiak.karol.units.internal

object Conversions {
	import language.higherKinds
	import language.implicitConversions
	import Bools._
	import Integers._
	import Strings._
	import SingleUnits._
	import UnitImpl._
	import stasiak.karol.units.MUnit

	class BaseIntRatio[U<:MUnit, V<:MUnit](val ratio:Long) extends AnyVal {
		@inline
		def times[Y<:MUnit] = 
			new BaseIntRatio[U#Mul[Y],V#Mul[Y]](ratio)
		@inline
		def dividedBy[Y<:MUnit] = 
			new BaseIntRatio[U#Mul[Y#Invert],V#Mul[Y#Invert]](ratio)
		@inline
		def invert = new BaseDoubleRatio[V,U](1.0/ratio)
		@inline
		def pow2 = this * this
		@inline
		def pow3 = this * this * this
		@inline
		def *[X<:MUnit, Y<:MUnit](that: BaseIntRatio[X,Y]) = 
			new BaseIntRatio[U#Mul[X],V#Mul[Y]](ratio*that.ratio)
		@inline
		def *[X<:MUnit, Y<:MUnit](that: BaseDoubleRatio[X,Y]) = 
			new BaseDoubleRatio[U#Mul[X],V#Mul[Y]](ratio*that.ratio)
		@inline
		def /[X<:MUnit, Y<:MUnit](that: BaseIntRatio[X,Y]) = 
			new BaseDoubleRatio[U#Mul[X#Invert],V#Mul[Y#Invert]](ratio/that.ratio)
		@inline
		def /[X<:MUnit, Y<:MUnit](that: BaseDoubleRatio[X,Y]) = 
			new BaseDoubleRatio[U#Mul[X#Invert],V#Mul[Y#Invert]](ratio/that.ratio)
		@inline
		def ><[Y<:MUnit](that: BaseDoubleRatio[Y,V]) = new BaseDoubleRatio[U,Y](ratio/that.ratio)
		@inline
		def ><[Y<:MUnit](that: BaseIntRatio[Y,V]) = new BaseDoubleRatio[U,Y](ratio.toDouble/that.ratio)
		@inline
		def <>[Y<:MUnit](that: BaseDoubleRatio[U,Y]) = new BaseDoubleRatio[Y,V](ratio/that.ratio)
		@inline
		def <>[Y<:MUnit](that: BaseIntRatio[U,Y]) = new BaseDoubleRatio[Y,V](ratio.toDouble/that.ratio)
		@inline
		def >>[Y<:MUnit](that: BaseIntRatio[V,Y]) = new BaseIntRatio[U,Y](ratio*that.ratio)
		@inline
		def >>[Y<:MUnit](that: BaseDoubleRatio[V,Y]) = new BaseDoubleRatio[U,Y](ratio*that.ratio)
	}
	class UnitAlias[U<:MUnit, V<:MUnit](val unused: Int = 0) extends AnyVal{
		@inline
		def times[Y<:MUnit] = 
			new BaseIntRatio[U#Mul[Y],V#Mul[Y]](1)
		@inline
		def dividedBy[Y<:MUnit] = 
			new BaseIntRatio[U#Mul[Y#Invert],V#Mul[Y#Invert]](1)
		@inline
		def invert = new BaseDoubleRatio[V,U](1.0)
		@inline
		def pow2 = new UnitAlias[U#Mul[U],        V#Mul[V]       ]
		@inline
		def pow3 = new UnitAlias[U#Mul[U]#Mul[U], V#Mul[V]#Mul[V]]
		@inline
		def *[X<:MUnit, Y<:MUnit](that: BaseIntRatio[X,Y]) = 
			new BaseIntRatio[U#Mul[X],V#Mul[Y]](that.ratio)
		@inline
		def *[X<:MUnit, Y<:MUnit](that: BaseDoubleRatio[X,Y]) = 
			new BaseDoubleRatio[U#Mul[X],V#Mul[Y]](that.ratio)
		@inline
		def /[X<:MUnit, Y<:MUnit](that: BaseIntRatio[X,Y]) = 
			new BaseDoubleRatio[U#Mul[X#Invert],V#Mul[Y#Invert]](1.0/that.ratio)
		@inline
		def /[X<:MUnit, Y<:MUnit](that: BaseDoubleRatio[X,Y]) = 
			new BaseDoubleRatio[U#Mul[X#Invert],V#Mul[Y#Invert]](1.0/that.ratio)
		@inline
		def ><[Y<:MUnit](that: BaseDoubleRatio[Y,V]) = new BaseDoubleRatio[U,Y](1.0/that.ratio)
		@inline
		def ><[Y<:MUnit](that: BaseIntRatio[Y,V]) = new BaseDoubleRatio[U,Y](1.0/that.ratio)
		@inline
		def <>[Y<:MUnit](that: BaseDoubleRatio[U,Y]) = new BaseDoubleRatio[Y,V](1.0/that.ratio)
		@inline
		def <>[Y<:MUnit](that: BaseIntRatio[U,Y]) = new BaseDoubleRatio[Y,V](1.0/that.ratio)
		@inline
		def >>[Y<:MUnit](that: BaseIntRatio[V,Y]) = new BaseIntRatio[U,Y](that.ratio)
		@inline
		def >>[Y<:MUnit](that: BaseDoubleRatio[V,Y]) = new BaseDoubleRatio[U,Y](that.ratio)
	}
	class BaseDoubleRatio[U<:MUnit, V<:MUnit](val ratio: Double) extends AnyVal {
		@inline
		def times[Y<:MUnit] = 
			new BaseDoubleRatio[U#Mul[Y],V#Mul[Y]](ratio)
		@inline
		def dividedBy[Y<:MUnit] = 
			new BaseDoubleRatio[U#Mul[Y#Invert],V#Mul[Y#Invert]](ratio)
		@inline
		def invert = new BaseDoubleRatio[V,U](1.0/ratio)
		@inline
		def pow2 = this * this
		@inline
		def pow3 = this * this * this
		@inline
		def *[X<:MUnit, Y<:MUnit](that: BaseDoubleRatio[X,Y]) = 
			new BaseDoubleRatio[U#Mul[X],V#Mul[Y]](ratio*that.ratio)
		@inline
		def *[X<:MUnit, Y<:MUnit](that: BaseIntRatio[X,Y]) = 
			new BaseDoubleRatio[U#Mul[X],V#Mul[Y]](ratio*that.ratio)
		@inline
		def /[X<:MUnit, Y<:MUnit](that: BaseIntRatio[X,Y]) = 
			new BaseDoubleRatio[U#Mul[X#Invert],V#Mul[Y#Invert]](ratio/that.ratio)
		@inline
		def /[X<:MUnit, Y<:MUnit](that: BaseDoubleRatio[X,Y]) = 
			new BaseDoubleRatio[U#Mul[X#Invert],V#Mul[Y#Invert]](ratio/that.ratio)
		@inline
		def ><[Y<:MUnit](that: BaseDoubleRatio[Y,V]) = new BaseDoubleRatio[U,Y](ratio/that.ratio)
		@inline
		def ><[Y<:MUnit](that: BaseIntRatio[Y,V]) = new BaseDoubleRatio[U,Y](ratio/that.ratio)
		@inline
		def <>[Y<:MUnit](that: BaseDoubleRatio[U,Y]) = new BaseDoubleRatio[Y,V](ratio/that.ratio)
		@inline
		def <>[Y<:MUnit](that: BaseIntRatio[U,Y]) = new BaseDoubleRatio[Y,V](ratio.toDouble/that.ratio)
		@inline
		def >>[Y<:MUnit](that: BaseDoubleRatio[V,Y]) = new BaseDoubleRatio[U,Y](ratio*that.ratio)
		@inline
		def >>[Y<:MUnit](that: BaseIntRatio[V,Y]) = new BaseDoubleRatio[U,Y](ratio*that.ratio)
	}
	class DoubleRatio[U<:MUnit, V<:MUnit](val ratio: Double) extends AnyVal
	class IntRatio[U<:MUnit, V<:MUnit](val ratio: Long) extends AnyVal

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

	class PowerIntRatio[U<:TSingleUnit, Power<:TInteger, V<:MUnit, N<:TInteger](val ratio:Long) extends AnyVal
	class PowerDoubleRatio[U<:TSingleUnit, Power<:TInteger, V<:MUnit, N<:TInteger](val ratio: Double) extends AnyVal

	class LeftIntRatio[U<:MUnit, V<:MUnit, W<:MUnit](val ratio: Long) extends AnyVal
	class RightIntRatio[U<:MUnit, V<:MUnit, W<:MUnit](val ratio: Long) extends AnyVal


}