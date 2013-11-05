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
package stasiak

/**
	Main package of the library.

	Importing `stasiak.units._` brings into scope most of its features.
*/
package object units {
	import language.higherKinds
	import language.implicitConversions
	import stasiak.units.internal.ratios._
	import stasiak.units.internal.UnitName
	import stasiak.units.internal.UnitImpl
	import stasiak.units.internal.UnitImpl._
	import stasiak.units.internal.Strings._
	import stasiak.units.internal.Conversions
	import stasiak.units.internal.Conversions._
	import stasiak.units.internal.SingleUnits._
	import stasiak.units.internal.Integers._
	import stasiak.units.internal.AffineSpaces
	import stasiak.units.internal.AffineSpaces._

	type @@[N, U<:MUnit] = WithU[N,U]

	/** Unit division.*/
	type /[U<:MUnit, V<:MUnit] = U#Mul[V#Invert]
	/** Unit multiplication.*/
	type ×[U<:MUnit, V<:MUnit] = U#Mul[V]
	/** Unit multiplication.*/
	type ><[U<:MUnit, V<:MUnit] = U#Mul[V]
	/** Takes unit to the second power.*/
	type square[U<:MUnit] = U#ToPower[P2]
	/** Takes unit to the third power.*/
	type cube[U<:MUnit] = U#ToPower[P3]
	/** Gets inverse of a unit. `inverse[second]` is equivalent to `hertz`.*/
	type inverse[U<:MUnit] = U#Invert

	/** Unit dimensionless values have, which is 1.*/
	type _1 = TDimensionless
	type DoubleRatio[U<:MUnit, V<:MUnit] = stasiak.units.internal.ratios.DoubleRatio[U,V]
	type IntRatio[U<:MUnit, V<:MUnit] = stasiak.units.internal.ratios.IntRatio[U,V]
	type DoubleAffineSpaceConverter[T1<:AffineSpace, T2<:AffineSpace] = stasiak.units.internal.ratios.DoubleAffineSpaceConverter[T1, T2]
	type IntAffineSpaceConverter[T1<:AffineSpace, T2<:AffineSpace] = stasiak.units.internal.ratios.IntAffineSpaceConverter[T1, T2]

	@inline
	implicit class UnitNameBuilder(override val toString:String) extends AnyVal{
		def unitName[U<:MUnit] = new UnitName(toString)
	}

	@inline
	implicit def implicit_widening[U<:MUnit](i: IntU[U]) = i.toDouble
	@inline
	implicit def implicit_wideningA[A<:AffineSpace](i: IntA[A]) = i.toDouble

	@inline
	implicit def implicit_toDimensionlessInt(i:Int) = new IntU[_1](i)
	@inline
	implicit def implicit_toDimensionlessLong(i:Long) = new IntU[_1](i)
	@inline
	implicit def implicit_toDimensionlessFloat(i:Float) = new DoubleU[_1](i)
	@inline
	implicit def implicit_toDimensionlessDouble(i:Double) = new DoubleU[_1](i)
	@inline
	implicit def implicit_toDimensionlessTupleDDD(i:(Double,Double,Double)) =
	Vector3U(i._1.of[_1], i._2.of[_1], i._3.of[_1])

	@inline
	implicit def implicit_toDimensionlessTupleIII(i:(Int,Int,Int)) =
	Vector3U(i._1.toDouble.of[_1], i._2.toDouble.of[_1], i._3.toDouble.of[_1])
	@inline
	implicit def implicit_fromDimensionlessInt(i:IntU[_1]) = i.value
	@inline
	implicit def implicit_fromDimensionlessDouble(i:DoubleU[_1]) = i.value
	@inline
	implicit def implicit_fromDimensionlessTuple(i:Vector3U[_1]) = (i.x.value, i.y.value, i.z.value)
	@inline
	implicit def implicit_float2DoubleUBuilder(value: Float) =new DoubleUBuilder(value.toDouble)
	@inline
	implicit def implicit_dimensionless2DoubleUBuilder(value: DoubleU[_1]) =new DoubleUBuilder(value.value)

	/**Extension methods for everything */
	implicit final class WithUBuilder[N](val underlyingValue: N) extends AnyVal {
		/** Creates a value with a unit. */
		@inline
		def of[U<:MUnit] = new WithU[N,U](underlyingValue)
		/** Creates a value in an affine space. */
		@inline
		def at[A<:AffineSpace] = new WithA[N,A](underlyingValue)

		@inline
		def deca[U<:MUnit] (implicit n:Numeric[N]) =
			WithU[N,U](n.times(underlyingValue,n.fromInt(10)))
		@inline
		def hecto[U<:MUnit](implicit n:Numeric[N]) =
			WithU[N,U](n.times(underlyingValue,n.fromInt(10)))
		@inline
		def deka[U<:MUnit] (implicit n:Numeric[N]) =
			WithU[N,U](n.times(underlyingValue,n.fromInt(10)))
		@inline
		def hekto[U<:MUnit](implicit n:Numeric[N]) =
			WithU[N,U](n.times(underlyingValue,n.fromInt(10)))
		@inline
		def kilo[U<:MUnit] (implicit n:Numeric[N]) =
			WithU[N,U](n.times(underlyingValue,n.fromInt(10)))
		@inline
		def mega[U<:MUnit] (implicit n:Numeric[N]) =
			WithU[N,U](n.times(underlyingValue,n.fromInt(10)))
		@inline
		def giga[U<:MUnit] (implicit n:Numeric[N]) =
			WithU[N,U](n.times(underlyingValue,n.fromInt(10)))

	}

	/** Extention methods for Double. */
	implicit final class DoubleUBuilder(val value: Double) extends AnyVal {
		/** Creates a value with a unit. */
		@inline
		def of[U<:MUnit] = new DoubleU[U](value)
		/** Creates a value in an affine space. */
		@inline
		def at[A<:AffineSpace] = new DoubleA[A](value)

		@inline
		def deca[U<:MUnit] = new DoubleU[U](value*10)
		@inline
		def hecto[U<:MUnit]= new DoubleU[U](value*100)
		@inline
		def deka[U<:MUnit] = new DoubleU[U](value*10)
		@inline
		def hekto[U<:MUnit]= new DoubleU[U](value*100)
		@inline
		def kilo[U<:MUnit] = new DoubleU[U](value*1000)
		@inline
		def mega[U<:MUnit] = new DoubleU[U](value*1000000)
		@inline
		def giga[U<:MUnit] = new DoubleU[U](value*1000000000)
		@inline
		def tera[U<:MUnit] = new DoubleU[U](value*1000000000000L)
		@inline
		def peta[U<:MUnit] = new DoubleU[U](value*1000000000000000L)
		@inline
		def exa [U<:MUnit] = new DoubleU[U](value*1000000000000000000L)

		@inline
		def deci [U<:MUnit] = new DoubleU[U](value/10.0)
		@inline
		def centi[U<:MUnit] = new DoubleU[U](value/100.0)
		@inline
		def milli[U<:MUnit] = new DoubleU[U](value/1000.0)
		@inline
		def micro[U<:MUnit] = new DoubleU[U](value/1000000.0)
		@inline
		def nano [U<:MUnit] = new DoubleU[U](value/1000000000.0)
		@inline
		def pico [U<:MUnit] = new DoubleU[U](value/1000000000000.0)
		@inline
		def femto[U<:MUnit] = new DoubleU[U](value/1000000000000000.0)
		@inline
		def atto [U<:MUnit] = new DoubleU[U](value/1000000000000000000.0)
	}

	@inline
	implicit def implicit_tupleIII2Vector3UBuilder(value: (Int, Int, Int)) =
		new Vector3UBuilder(value._1, value._2, value._3)
	@inline
	implicit def implicit_tupleDDD2Vector3UBuilder(value: (Double, Double, Double)) =
		new Vector3UBuilder(value._1, value._2, value._3)
	@inline
	implicit def implicit_dimensionless2Vector3UBuilder(value: Vector3U[_1]) =
		new Vector3UBuilder(value.x.value, value.y.value, value.z.value)

	class Vector3UBuilder(x: Double, y: Double, z: Double) {
		@inline
		def of[U<:MUnit] = Vector3U[U](x.of, y.of, z.of)
		@inline
		def at[A<:AffineSpace] = Vector3A[A](x.at, y.at, z.at)
	}
	@inline
	implicit def implicit_tupleII2Vector2UBuilder(value: (Int, Int)) =
		new Vector2UBuilder(value._1, value._2)
	@inline
	implicit def implicit_tupleDD2Vector2UBuilder(value: (Double, Double)) =
		new Vector2UBuilder(value._1, value._2)
	@inline
	implicit def implicit_dimensionless2Vector2UBuilder(value: Vector2U[_1]) =
		new Vector2UBuilder(value.x.value, value.y.value)

	class Vector2UBuilder(x: Double, y: Double) {
		@inline
		def of[U<:MUnit] = Vector2U[U](x.of, y.of)
		@inline
		def at[A<:AffineSpace] = Vector2A[A](x.at, y.at)
	}
	@inline
	implicit def implicit_int2IntUBuilder(value: Int) = new IntUBuilder(value.toLong)
	@inline
	implicit def implicit_dimensionless2IntUBuilder(value: IntU[_1]) =new IntUBuilder(value.value)

	/** Extention methods for Long. */
	implicit class IntUBuilder(val value: Long) extends AnyVal {

		/** Creates a value with a unit. */
		@inline
		def of[U<:MUnit] = new IntU[U](value)
		/** Creates a value in an affine space. */
		@inline
		def at[A<:AffineSpace] = new IntA[A](value)

		@inline
		def deca[U<:MUnit] = new IntU[U](value*10)
		@inline
		def hecto[U<:MUnit]= new IntU[U](value*100)
		@inline
		def deka[U<:MUnit] = new IntU[U](value*10)
		@inline
		def hekto[U<:MUnit]= new IntU[U](value*100)
		@inline
		def kilo[U<:MUnit] = new IntU[U](value*1000)
		@inline
		def mega[U<:MUnit] = new IntU[U](value*1000000)
		@inline
		def giga[U<:MUnit] = new IntU[U](value*1000000000)
		@inline
		def tera[U<:MUnit] = new IntU[U](value*1000000000000L)
		@inline
		def peta[U<:MUnit] = new IntU[U](value*1000000000000000L)
		@inline
		def exa [U<:MUnit] = new IntU[U](value*1000000000000000000L)

		@inline
		def deci [U<:MUnit] = new DoubleU[U](value/10.0)
		@inline
		def centi[U<:MUnit] = new DoubleU[U](value/100.0)
		@inline
		def milli[U<:MUnit] = new DoubleU[U](value/1000.0)
		@inline
		def micro[U<:MUnit] = new DoubleU[U](value/1000000.0)
		@inline
		def nano [U<:MUnit] = new DoubleU[U](value/1000000000.0)
		@inline
		def pico [U<:MUnit] = new DoubleU[U](value/1000000000000.0)
		@inline
		def femto[U<:MUnit] = new DoubleU[U](value/1000000000000000.0)
		@inline
		def atto [U<:MUnit] = new DoubleU[U](value/1000000000000000000.0)
	}

	@inline
	implicit def implicit_oneDoubleAffineSpaceConverter[U<:AffineSpace] = new DoubleAffineSpaceConverter[U,U](_)
	@inline
	implicit def implicit_oneIntAffineSpaceConverter[U<:AffineSpace] = new IntAffineSpaceConverter[U,U](_)

	import defining._

	@inline
	implicit def implicit_twoWayDoubleAConverterF[A<:AffineSpace, B<:AffineSpace](
		implicit ev: ReversibleDoubleAConversion[A,B]
	) = new DoubleAffineSpaceConverter[A,B](ev.forward)
	@inline
	implicit def implicit_twoWayDoubleAConverterB[A<:AffineSpace, B<:AffineSpace](
		implicit ev: ReversibleDoubleAConversion[A,B]
	) = new DoubleAffineSpaceConverter[B,A](ev.backward)

	@inline
	implicit def implicit_twoWayIntAConverterF[A<:AffineSpace, B<:AffineSpace](
		implicit ev: ReversibleIntAConversion[A,B]
	) = new IntAffineSpaceConverter[A,B](ev.forwardInt)
	@inline
	implicit def implicit_twoWayIntAConverterB[A<:AffineSpace, B<:AffineSpace](
		implicit ev: ReversibleIntAConversion[A,B]
	) = new IntAffineSpaceConverter[B,A](ev.backwardInt)
}