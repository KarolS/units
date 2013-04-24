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
package stasiak.karol

package object units {
	import language.higherKinds
	import language.implicitConversions
	import stasiak.karol.units.internal.UnitImpl
	import stasiak.karol.units.internal.UnitImpl._
	import stasiak.karol.units.internal.Strings._
	import stasiak.karol.units.internal.Conversions
	import stasiak.karol.units.internal.Conversions._
	import stasiak.karol.units.internal.SingleUnits._
	import stasiak.karol.units.internal.Integers._
	import stasiak.karol.units.internal.AffineSpaces
	import stasiak.karol.units.internal.AffineSpaces._

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
	type DoubleRatio[U<:MUnit, V<:MUnit] = Conversions.DoubleRatio[U,V]
	type IntRatio[U<:MUnit, V<:MUnit] = Conversions.IntRatio[U,V]
	type DoubleAffineSpaceConverter[T1<:AffineSpace, T2<:AffineSpace] = AffineSpaces.DoubleAffineSpaceConverter[T1, T2]
	type IntAffineSpaceConverter[T1<:AffineSpace, T2<:AffineSpace] = AffineSpaces.IntAffineSpaceConverter[T1, T2]

	class TUnitPowerPairName[U<:TUnitPowerPair](w:String){
		override def toString = w
	}
	@inline
	implicit def implicit_unitPowerPairName[U<:TUnitPowerPair](
		implicit stringName: TStringName[U#UnitName#Name], power:ToInt[U#Power]
		) = new TUnitPowerPairName[U](
		" "+stringName.toString +(
			if(power.toInt<0)  "^("+power.toInt+")" else (if (power.toInt>1) "^"+power.toInt else "")
		)
	)
	@inline
	implicit val implicit_dimensionlessName = new UnitName[_1]("")
	@inline
	implicit def implicit_consUnitName[H<:TUnitPowerPair, T<:MUnit](implicit h:TUnitPowerPairName[H], t:UnitName[T]) = 
		new UnitName[T**H](h.toString+t.toString)
	@inline
	implicit def implicit_singleUnitName[H<:TUnitPowerPair](implicit h:TUnitPowerPairName[H]) = 
		new UnitName[H](h.toString)


	@inline
	implicit class UnitNameBuilder(override val toString:String) extends AnyVal{
		def unitName[U<:MUnit] = new UnitName(toString)
	}


	@inline
	implicit def implicit_widening[U<:MUnit](i: IntU[U]) = i.toDouble

	@inline
	implicit def implicit_toScalarInt(i:Int) = new IntU[_1](i)
	@inline
	implicit def implicit_toScalarLong(i:Long) = new IntU[_1](i)
	@inline
	implicit def implicit_toScalarFloat(i:Float) = new DoubleU[_1](i)
	@inline
	implicit def implicit_toScalarDouble(i:Double) = new DoubleU[_1](i)
	@inline
	implicit def implicit_fromScalarInt(i:IntU[_1]) = i.value
	@inline
	implicit def implicit_fromScalarDouble(i:DoubleU[_1]) = i.value

	@inline
	implicit def implicit_float2DoubleUBuilder(value: Float) =new DoubleUBuilder(value.toDouble)
	@inline
	implicit def implicit_scalar2DoubleUBuilder(value: DoubleU[_1]) =new DoubleUBuilder(value.value)

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
	implicit def implicit_oneDoubleRatio[U<:MUnit] = new DoubleRatio[U,U](1.0)
	@inline
	implicit def implicit_oneIntRatio[U<:MUnit] = new IntRatio[U,U](1)
	@inline
	implicit def implicit_intRatioEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U,V]
		) = new IntRatio[U,V](declaredRatio.ratio)
	@inline
	implicit def implicit_doubleRatioEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseDoubleRatio[U,V]
		) = new DoubleRatio[U,V](declaredRatio.ratio)
	@inline
	implicit def implicit_doubleRatioIntEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U,V]
		) = new DoubleRatio[U,V](declaredRatio.ratio)
	@inline
	implicit def implicit_revDoubleRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseDoubleRatio[U,V]
		) = new DoubleRatio[V,U](1.0/declaredRatio.ratio)
	@inline
	implicit def implicit_revIntRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U,V]
		) = new DoubleRatio[V,U](1.0/declaredRatio.ratio)

	@inline
	implicit def implicit_squareIntRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U#Sqrt,V#Sqrt]
		) = new IntRatio[U,V](declaredRatio.ratio * declaredRatio.ratio)
	@inline
	implicit def implicit_cubeIntRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U#Cbrt,V#Cbrt]
		) = new IntRatio[U,V](declaredRatio.ratio * declaredRatio.ratio * declaredRatio.ratio)
	@inline
	implicit def implicit_squareDoubleRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseDoubleRatio[U#Sqrt,V#Sqrt]
		) = new DoubleRatio[U,V](declaredRatio.ratio * declaredRatio.ratio)
	@inline
	implicit def implicit_cubeDoubleRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseDoubleRatio[U#Cbrt,V#Cbrt]
		) = new DoubleRatio[U,V](declaredRatio.ratio * declaredRatio.ratio * declaredRatio.ratio)
	@inline
	implicit def implicit_squareDoubleIntRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U#Sqrt,V#Sqrt]
		) = new DoubleRatio[U,V](declaredRatio.ratio * declaredRatio.ratio)
	@inline
	implicit def implicit_cubeDoubleIntRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U#Cbrt,V#Cbrt]
		) = new DoubleRatio[U,V](declaredRatio.ratio * declaredRatio.ratio * declaredRatio.ratio)

	@inline
	implicit def implicit_squareRevIntRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U#Sqrt,V#Sqrt]
		) = new DoubleRatio[V,U](1.0/(declaredRatio.ratio * declaredRatio.ratio))
	@inline
	implicit def implicit_cubeRevIntRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U#Cbrt,V#Cbrt]
		) = new DoubleRatio[V,U](1.0/(declaredRatio.ratio * declaredRatio.ratio * declaredRatio.ratio))
	@inline
	implicit def implicit_squareRevDoubleRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseDoubleRatio[U#Sqrt,V#Sqrt]
		) = new DoubleRatio[V,U](1.0/(declaredRatio.ratio * declaredRatio.ratio))
	@inline
	implicit def implicit_cubeRevDoubleRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseDoubleRatio[U#Cbrt,V#Cbrt]
		) = new DoubleRatio[V,U](1.0/(declaredRatio.ratio * declaredRatio.ratio * declaredRatio.ratio))

	@inline
	implicit def implicit_intRatioAliasEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U,V]
		) = new IntRatio[U,V](1)
	@inline
	implicit def implicit_doubleRatioAliasEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U,V]
		) = new DoubleRatio[U,V](1)
	@inline
	implicit def implicit_intRatioAliasSqEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Sqrt,V#Sqrt]
		) = new IntRatio[U,V](1)
	@inline
	implicit def implicit_doubleRatioAliasSqEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Sqrt,V#Sqrt]
		) = new DoubleRatio[U,V](1)
	@inline
	implicit def implicit_intRatioAliasCbEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Cbrt,V#Cbrt]
		) = new IntRatio[U,V](1)
	@inline
	implicit def implicit_doubleRatioAliasCbEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Cbrt,V#Cbrt]
		) = new DoubleRatio[U,V](1)

	@inline
	implicit def implicit_intRatioAliasRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U,V]
		) = new IntRatio[V,U](1)
	@inline
	implicit def implicit_doubleRatioAliasRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U,V]
		) = new DoubleRatio[V,U](1)
	@inline
	implicit def implicit_intRatioAliasSqRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Sqrt,V#Sqrt]
		) = new IntRatio[V,U](1)
	@inline
	implicit def implicit_doubleRatioAliasSqRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Sqrt,V#Sqrt]
		) = new DoubleRatio[V,U](1)
	@inline
	implicit def implicit_intRatioAliasCbRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Cbrt,V#Cbrt]
		) = new IntRatio[V,U](1)
	@inline
	implicit def implicit_doubleRatioAliasCbRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Cbrt,V#Cbrt]
		) = new DoubleRatio[V,U](1)



	@inline
	implicit def implicit_zeroPowerDoubleRatio[U<:TSingleUnit, V<:MUnit] = 
		new PowerDoubleRatio[U,P1,V,_0](1.0)
	@inline
	implicit def implicit_positivePowerDoubleRatio[U<:TSingleUnit, V<:MUnit, N<:TInteger](
		implicit ev:DoubleRatio[U^P1,V], prev:PowerDoubleRatio[U,P1,V,N]
		) = new PowerDoubleRatio[U,P1,V,Inc[N]](prev.ratio*ev.ratio)
	@inline
	implicit def implicit_negativePowerDoubleRatio[U<:TSingleUnit, V<:MUnit, N<:TInteger](
		implicit ev:DoubleRatio[U^P1,V], prev:PowerDoubleRatio[U,P1,V,N]
		) = new PowerDoubleRatio[U,P1,V,Dec[N]](prev.ratio/ev.ratio)

	@inline
	implicit def implicit_zeroPowerIntRatio[U<:TSingleUnit, V<:MUnit] = 
		new PowerIntRatio[U,P1,V,_0](1)
	@inline
	implicit def implicit_positivePowerIntRatio[U<:TSingleUnit, V<:MUnit, N<:TInteger](
		implicit ev:IntRatio[U^P1,V], prev:PowerIntRatio[U,P1,V,N]
		) = new PowerIntRatio[U,P1,V,Inc[N]](prev.ratio*ev.ratio)

	@inline
	implicit def implicit_oneLeftIntRatio[U<:MUnit] = new LeftIntRatio[U,U,U](1)
	@inline
	implicit def implicit_oneRightIntRatio[U<:MUnit] = new RightIntRatio[U,U,U](1)
	@inline
	implicit def implicit_leftIntRatio[U<:MUnit, V<:MUnit](implicit ev: IntRatio[U,V]) = 
		new LeftIntRatio[U,V,V](ev.ratio)
	@inline
	implicit def implicit_rightIntRatio[U<:MUnit, V<:MUnit](implicit ev: IntRatio[U,V]) = 
		new RightIntRatio[U,V,V](1)
	@inline
	implicit def implicit_leftIntRatioRev[U<:MUnit, V<:MUnit](implicit ev: IntRatio[V,U]) = 
		new LeftIntRatio[U,V,U](1)
	@inline
	implicit def implicit_rightIntRatioRev[U<:MUnit, V<:MUnit](implicit ev: IntRatio[V,U]) = 
		new RightIntRatio[U,V,U](ev.ratio)
		
	@inline
	implicit def implicit_oneDoubleAffineSpaceConverter[U<:AffineSpace] = new DoubleAffineSpaceConverter[U,U](_)
	@inline
	implicit def implicit_oneIntAffineSpaceConverter[U<:AffineSpace] = new IntAffineSpaceConverter[U,U](_)

}