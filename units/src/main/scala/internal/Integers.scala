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
package io.github.karols.units.internal

object Integers {
	import Bools._
	import language.higherKinds
	sealed trait TInteger {
		type Succ <: TInteger
		type Pred <: TInteger
		type Half <: TInteger
		type Third <: TInteger
		type DivisibleByTwo <: TBool
		type DivisibleByThree <: TBool
		type Negate <: TInteger
		type Add[X<:TInteger] <: TInteger
		type RevSub[X<:TInteger] <: TInteger
		type Sub[X<:TInteger] <: TInteger
		type Mul[X<:TInteger] <: TInteger
		type ZeroNegPos[IfZero<:ResultType, IfNeg[N<:TInteger]<:ResultType, IfPos[N<:TInteger]<:ResultType, ResultType] <: ResultType
		type Equal[X<:TInteger] <: TBool
	}
	type LambdaNatTrue[N<:TInteger] = True
	type LambdaNatFalse[N<:TInteger] = False
	type LambdaNatNothing[N<:TInteger] = Nothing
	sealed trait NegZ extends TInteger
	sealed trait PosZ extends TInteger
	sealed trait _0 extends TInteger with NegZ with PosZ{
		type Succ = Inc[_0]
		type Pred = Dec[_0]
		type Half = _0
		type Third = _0
		type DivisibleByTwo  = True
		type DivisibleByThree = True
		type Negate = _0
		type Add[X<:TInteger] = X
		type RevSub[X<:TInteger] = X
		type Sub[X<:TInteger] = X#RevSub[_0]
		type Mul[X<:TInteger] = _0
		type ZeroNegPos[IfZero<:ResultType, IfNeg[N<:TInteger]<:ResultType, IfPos[N<:TInteger]<:ResultType, ResultType] = IfZero
		type Equal[X<:TInteger] <: X#ZeroNegPos[True, LambdaNatFalse, LambdaNatFalse, TBool]
	}
	sealed trait Inc[N <: TInteger] extends TInteger with PosZ {
		type Succ = Inc[Inc[N]]
		type Pred = N
		type Half = If[DivisibleByTwo,
			Inc[N#Pred#Half],
			Nothing,
		TInteger]
		type Third = If[DivisibleByThree,
			Inc[N#Pred#Pred#Third],
			Nothing,
		TInteger]
		type DivisibleByTwo  = N#DivisibleByTwo#Not
		type DivisibleByThree = N#ZeroNegPos[
			False,
			LambdaNatFalse,
			({type L[X<:TInteger] = X#Pred#DivisibleByThree})#L,
		TBool]
		type Negate = Dec[N#Negate]
		type Add[X<:TInteger] = N#Add[X#Succ]
		type RevSub[X<:TInteger] = N#RevSub[X#Pred]
		type Sub[X<:TInteger] = X#RevSub[N#Succ]
		type Mul[X<:TInteger] = N#Mul[X]#Add[X]
		type ZeroNegPos[IfZero<:ResultType, IfNeg[N<:TInteger]<:ResultType, IfPos[N<:TInteger]<:ResultType, ResultType] = IfPos[N]
		type Equal[X<:TInteger] <: X#ZeroNegPos[False, LambdaNatFalse, N#Equal, TBool]
	}
	sealed trait Dec[N <: TInteger] extends TInteger with NegZ {
		type Succ = N
		type Pred = Dec[Dec[N]]
		type Half = If[DivisibleByTwo,
			Dec[N#Succ#Half],
			Nothing,
		TInteger]
		type Third = If[DivisibleByThree,
			Dec[N#Succ#Succ#Third],
			Nothing,
		TInteger]
		type DivisibleByTwo  = N#DivisibleByTwo#Not
		type DivisibleByThree = N#ZeroNegPos[
			False,
			({type L[X<:TInteger] = X#Succ#DivisibleByThree})#L,
			LambdaNatFalse,
		TBool]
		type Negate = Inc[N#Negate]
		type Add[X<:TInteger] = N#Add[X#Pred]
		type RevSub[X<:TInteger] = N#RevSub[X#Succ]
		type Sub[X<:TInteger] = X#RevSub[N#Pred]
		type Mul[X<:TInteger] = N#Mul[X]#Sub[X]
		type ZeroNegPos[IfZero<:ResultType, IfNeg[N<:TInteger]<:ResultType, IfPos[N<:TInteger]<:ResultType, ResultType] = IfNeg[N]
		type Equal[X<:TInteger] <: X#ZeroNegPos[False, N#Equal, LambdaNatFalse, TBool]
	}

	type P1 = Inc[_0]
	type P2 = Inc[P1]
	type P3 = Inc[P2]
	type P4 = Inc[P3]
	type P5 = Inc[P4]
	type P6 = Inc[P5]
	type P7 = Inc[P6]
	type P8 = Inc[P7]
	type P9 = Inc[P8]
	type P10 = Inc[P9]
	type P11 = Inc[P10]
	type P12 = Inc[P11]
	type P13 = Inc[P12]
	type P14 = Inc[P13]
	type P15 = Inc[P14]
	
	type N1 = Dec[_0]
	type N2 = Dec[N1]
	type N3 = Dec[N2]
	type N4 = Dec[N3]
	type N5 = Dec[N4]
	type N6 = Dec[N5]
	type N7 = Dec[N6]
	type N8 = Dec[N7]
	type N9 = Dec[N8]
	
	type +[A<:TInteger,B<:TInteger] = A#Add[B]
	type -[A<:TInteger,B<:TInteger] = A#Sub[B]
	type ==[A<:TInteger,B<:TInteger] = A#Equal[B]
	
	class ToInt[N<:TInteger](val toInt:Int) extends AnyVal {
		override def toString = toInt.toString
	}
	def printlnN[N<:TInteger]()(implicit toInt: ToInt[N]) = println(toInt.toInt)


	implicit val print0:ToInt[_0] = new ToInt[_0](0)
	implicit def printPos[N<:PosZ](implicit toInt: ToInt[N]):ToInt[Inc[N]]= new ToInt[Inc[N]](toInt.toInt + 1)
	implicit def printNeg[N<:NegZ](implicit toInt: ToInt[N]):ToInt[Dec[N]]= new ToInt[Dec[N]](toInt.toInt - 1)

}