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

object UnitImpl {
	import language.higherKinds
	import language.implicitConversions
	import Bools._
	import Integers._
	import Strings._
	import SingleUnits._
	trait MUnit {
		type Invert <: MUnit
		type Get[U<:TSingleUnit] <:TInteger
		type MulSingle[S<:TUnitPowerPair] <: MUnit
		type Mul[S<:MUnit] <: MUnit
		type Sqrt <:MUnit
		type Cbrt <:MUnit
		type ToPower[Exp<:TInteger] <: MUnit 
	}
	sealed trait TUnitPowerPair extends MUnit{
		type UnitName <: TSingleUnit
		type Power <: TInteger
		type Get[V<:TSingleUnit] = If[V====UnitName,
			Power,
			_0,
		TInteger]
	}
	trait ^[U<:TSingleUnit, N<:TInteger] extends MUnit with TUnitPowerPair {
		type UnitName = U
		type Power = N
		type Invert = U ^ N#Negate
		type MulSingle[S<:TUnitPowerPair] = 
			S#UnitName#LessEqualGreater[U,
				(U^N)**S,
				(S#Power+N)#ZeroNegPos[
					TScalar,
					({type L[A]=(S#UnitName ^ (S#Power+N))})#L,
					({type L[A]=(S#UnitName ^ (S#Power+N))})#L,
				MUnit],
				S**(U^N),
			MUnit]
		type Mul[S<:MUnit] = S#MulSingle[U^N]
		type ToPower[Exp<:TInteger] = If[Exp == _0,
			TScalar,
			U^(Exp#Mul[N]),
		MUnit]
		type Sqrt = U^(N#Half)
		type Cbrt = U^(N#Third)
	}
	sealed trait TScalar extends MUnit{
		type Get[U<:TSingleUnit] = _0
		type Invert = TScalar
		type MulSingle[S<:TUnitPowerPair] = S
		type Mul[S<:MUnit] = S
		type ToPower[Exp<:TInteger] = TScalar
		type Sqrt = TScalar
		type Cbrt = TScalar
	}
	sealed trait **[T<:MUnit,H<:TUnitPowerPair] extends MUnit {
		type Get[U<:TSingleUnit] = If[H#UnitName ==== U,
			H#Power,
			T#Get[U],
		TInteger]
		//type MatchScalarNonscalar[IfScalar<:ResultType, IfNonscalar[U<:TUnitPowerPair, Tail<:MUnit]<:ResultType, ResultType] = IfNonscalar[H,T]
		type Invert = (T#Invert)**(H#UnitName ^ H#Power#Negate)
		type MulSingle[S<:TUnitPowerPair] = 
			S#UnitName#LessEqualGreater[H#UnitName,
				(T**H)**S,
				(S#Power + H#Power)#ZeroNegPos[
					T,
					({type L[A] = T ** (S#UnitName ^ (S#Power+H#Power))})#L,
					({type L[A] = T ** (S#UnitName ^ (S#Power+H#Power))})#L,
				MUnit],	
				(T#MulSingle[S]) ** H,
			MUnit]

		type Mul[S<:MUnit] = S#Mul[T]#MulSingle[H]
		type ToPower[Exp<:TInteger] = If[Exp == _0,
			TScalar,
			(T#ToPower[Exp]) ** (H#UnitName ^ H#Power#Mul[Exp]),
		MUnit]
		type Sqrt = (T#Sqrt)** (H#UnitName ^ H#Power#Half)
		type Cbrt = (T#Cbrt)** (H#UnitName ^ H#Power#Third)
	}
	
 	class UnitName[U<:MUnit](override val toString:String) extends AnyVal	
}