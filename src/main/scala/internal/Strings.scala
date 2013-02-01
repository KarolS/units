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

object Strings {
	import language.higherKinds
	import language.implicitConversions
	import Bools._
	import Integers._
	type LambdaTCharTrue[N<:TChar] = True
	type LambdaTCharFalse[N<:TChar] = False
	type LambdaTStringFalse[H<:TChar,T<:TString] = False
	type LambdaNatTrue[N<:TInteger] = True
	type LambdaNatFalse[N<:TInteger] = False
	sealed trait TChar extends TString{
		type High <: TInteger
		type Low  <: TInteger
		type EqualChar[C<:TChar] <: TBool
		type LessOrEqualChar[C<:TChar] <: TBool
		type LessOrEqualHead[H<:TChar, T<:TString] = LessOrEqualChar[H]
	}
	sealed trait AChar[H<:TInteger, L<:TInteger] extends TChar with ~:[AChar[H,L], EmptyTString] {
		type High = H
		type Low  = L
		type EqualChar[C<:TChar] = H#Equal[C#High]#And[L#Equal[C#Low]]
		type LessOrEqualChar[C<:TChar] = H#Sub[C#High]#ZeroNegPos[
			L#Sub[C#Low]#ZeroNegPos[
				True,
				LambdaNatTrue,
				LambdaNatFalse,
			TBool],
			LambdaNatTrue,
			LambdaNatFalse,
		TBool]
	}
	sealed trait TString {
		type MatchEmptyNonempty[IfEmpty<:ResultType, IfNonempty[H<:TChar, T<:TString]<:ResultType, ResultType] <: ResultType
		type Equal[S<:TString] <: TBool
		type Length<:TInteger
		type LessOrEqual[S<:TString] <: TBool
	}
	sealed trait EmptyTString extends TString{
		type MatchEmptyNonempty[IfEmpty<:ResultType, IfNonempty[He<:TChar, Ta<:TString]<:ResultType, ResultType] = IfEmpty
		type Equal[S<:TString] = S#MatchEmptyNonempty[True, LambdaTStringFalse,TBool]
		type Length = _0
		type LessOrEqual[S<:TString] = True
	}
	sealed trait ~:[H<:TChar,T<:TString] extends TString {
		type MatchEmptyNonempty[IfEmpty<:ResultType, IfNonempty[He<:TChar, Ta<:TString]<:ResultType, ResultType] = IfNonempty[H,T]
		type Equal[S<:TString] = S#MatchEmptyNonempty[False, E, TBool]
		type E[h<:TChar,t<:TString] = h#EqualChar[H]#And[t#Equal[T]]
		type Length = T#Length#Succ
		type LambdaComparison[H2<:TChar, T2<:TString] = 
			If[H#EqualChar[H2],
				T#LessOrEqual[T2],
				H#LessOrEqualChar[H2],
			TBool]
		type LessOrEqual[S<:TString] = S#MatchEmptyNonempty[False, LambdaComparison, TBool]
	}
	
	type ===[A<:TString,B<:TString] = A#Equal[B]

	type UC0 = _0
	type UC1 = P1
	type LC0 = P2
	type LC1 = P3

	// TODO: fill with more necessary symbols
	val CHARS = Array(
		"@ABCDEFGHIJKLMNO",//0
		"PQRSTUVWXYZ     ",//1
		"`abcdefghijklmno",//2
		"pqrstuvwxyz     ",//3
		"°    µ          ",//4
		"     Å          ",//5
		"         Ω      ",//6
		""
		)

	class TStringName[S<:TString](override val toString:String) extends AnyVal {
	}
	implicit val emptyStringName = new TStringName[EmptyTString]("")
	implicit def charStringName[C<:TChar](implicit headH:ToInt[C#High], headL:ToInt[C#Low]) =
		new TStringName[C](CHARS(headH.toInt)(headL.toInt).toString)
	implicit def consStringName[H<:TChar,T<:TString](
		implicit headH:ToInt[H#High], headL:ToInt[H#Low], tail:TStringName[T]
		) = new TStringName[H~:T](CHARS(headH.toInt)(headL.toInt)+tail.toString)
	


}	