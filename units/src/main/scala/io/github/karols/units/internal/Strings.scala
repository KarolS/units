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

	sealed trait TZ5 {
		type Is0 <: TBool
		type Is1 <: TBool
		type Is2 <: TBool
		type Is3 <: TBool
		type Is4 <: TBool
		type EqualZ5[C<:TZ5] <: TBool
		type GreaterThanZ5[C<:TZ5] <: TBool
	}

	sealed trait TZ5_0 extends TZ5 {
		type Is0 = True
		type Is2 = False
		type Is1 = False
		type Is3 = False
		type Is4 = False
		type EqualZ5[C<:TZ5] = C#Is0
		type GreaterThanZ5[C<:TZ5] = False
	}

	sealed trait TZ5_1 extends TZ5 {
		type Is0 = False
		type Is2 = False
		type Is1 = True
		type Is3 = False
		type Is4 = False
		type EqualZ5[C<:TZ5] = C#Is1
		type GreaterThanZ5[C<:TZ5] = C#Is0
	}

	sealed trait TZ5_2 extends TZ5 {
		type Is0 = False
		type Is2 = True
		type Is1 = False
		type Is3 = False
		type Is4 = False
		type EqualZ5[C<:TZ5] = C#Is2
		type GreaterThanZ5[C<:TZ5] = C#Is0#Or[C#Is1]
	}

	sealed trait TZ5_3 extends TZ5 {
		type Is0 = False
		type Is2 = False
		type Is1 = False
		type Is3 = True
		type Is4 = False
		type EqualZ5[C<:TZ5] = C#Is3
		type GreaterThanZ5[C<:TZ5] = C#Is0#Or[C#Is1]#Or[C#Is2]
	}

	sealed trait TZ5_4 extends TZ5 {
		type Is0 = False
		type Is2 = False
		type Is1 = False
		type Is3 = False
		type Is4 = True
		type EqualZ5[C<:TZ5] = C#Is4
		type GreaterThanZ5[C<:TZ5] = C#Is4#Not
	}

	sealed trait TChar extends TString{
		type High <: TZ5
		type Mid <: TZ5
		type Low  <: TZ5
		type EqualChar[C<:TChar] <: TBool
		type LessOrEqualChar[C<:TChar] <: TBool
		type LessOrEqualHead[H<:TChar, T<:TString] = LessOrEqualChar[H]
	}
	sealed trait AChar[H<:TZ5, M<:TZ5, L<:TZ5] extends TChar with ~:[AChar[H,M,L], EmptyTString] {
		type High = H
		type Mid = M
		type Low  = L
		type EqualChar[C<:TChar] = H#EqualZ5[C#High]#And[L#EqualZ5[C#Low]]#And[M#EqualZ5[C#Mid]]
		type LessOrEqualChar[C<:TChar] =
		C#High#GreaterThanZ5[H] #Or[
			C#High#EqualZ5[H] #And[
				C#Mid#GreaterThanZ5[M] #Or[
					C#Mid#EqualZ5[M] #And [
						C#Low#GreaterThanZ5[L] #Or [C#Low#EqualZ5[L]]
					]
				]
			]
		]

	}
	sealed trait TString {
		type MatchEmptyNonempty[
			IfEmpty<:ResultType,
			IfNonempty[H<:TChar, T<:TString]<:ResultType,
			ResultType] <: ResultType
		type IsEmpty <: TBool
		type Equals[S<:TString] <: TBool
		type Length<:TInteger
		type LessOrEqual[S<:TString] <: TBool
	}
	sealed trait EmptyTString extends TString{
		type MatchEmptyNonempty[
			IfEmpty<:ResultType,
			IfNonempty[He<:TChar, Ta<:TString]<:ResultType,
			ResultType] = IfEmpty
		type IsEmpty = True
		type Equals[S<:TString] = S#IsEmpty
		type Length = _0
		type LessOrEqual[S<:TString] = True
	}
	sealed trait ~:[H<:TChar,T<:TString] extends TString {
		type MatchEmptyNonempty[
			IfEmpty<:ResultType,
			IfNonempty[He<:TChar, Ta<:TString]<:ResultType,
			ResultType] = IfNonempty[H,T]
		type IsEmpty = False
		type Equals[S<:TString] = S#MatchEmptyNonempty[False, E, TBool]
		type E[h<:TChar,t<:TString] = h#EqualChar[H]#And[t#Equals[T]]
		type Length = T#Length#Succ
		type LambdaComparison[H2<:TChar, T2<:TString] =
			If[H#EqualChar[H2],
				T#LessOrEqual[T2],
				H#LessOrEqualChar[H2],
			TBool]
		type LessOrEqual[S<:TString] = S#MatchEmptyNonempty[False, LambdaComparison, TBool]
	}

	type ===[A<:TString,B<:TString] = A#Equals[B]

	type UC0 = _0
	type UC1 = P1
	type LC0 = P2
	type LC1 = P3

	// TODO: fill with more necessary symbols
	val CHARS = Array(
		"@ABCD", //00x
		"EFGHI", //01x
		"JKLMN", //02x
		"OPQRS", //03x
		"TUVWX", //04x
		"YZ`ab", //10x
		"cdefg", //11x
		"hijkl", //12x
		"mnopq", //13x
		"rstuv", //14x
		"wxyzÅ", //20x
		"µΩε é", //21x
		"£¥$€ł", //22x
		"°ʹʺ₫₨", //23x
		"%‰·.\u00a0", //24x
		"₀₂₃₄₅", //30x
		"ₘₙ ()", //31x
		"ₑₕₚₛₜ", //32x - the first character is subscript e; if you see a superscript 1, then it's a font bug
		" 1   ", //33x
		"     ", //34x
		"     ","     ","     ","     ","     ", //4xx
		""
		)// ₛₜₙₚₕₘ

	class TStringName[S<:TString](override val toString:String) extends AnyVal {}
	class ToZ5[T<:TZ5](val toInt: Int) extends AnyVal {}

	implicit val z5_0 = new ToZ5[TZ5_0](0)
	implicit val z5_1 = new ToZ5[TZ5_1](1)
	implicit val z5_2 = new ToZ5[TZ5_2](2)
	implicit val z5_3 = new ToZ5[TZ5_3](3)
	implicit val z5_4 = new ToZ5[TZ5_4](4)

	implicit val emptyStringName = new TStringName[EmptyTString]("")
	implicit def charStringName[C<:TChar](
		implicit headH:ToZ5[C#High], headM:ToZ5[C#Mid], headL:ToZ5[C#Low]) =
		new TStringName[C](CHARS(headH.toInt*5+headM.toInt)(headL.toInt).toString)
	implicit def consStringName[H<:TChar,T<:TString](
		implicit headH:ToZ5[H#High], headM:ToZ5[H#Mid], headL:ToZ5[H#Low], tail:TStringName[T]
		) = new TStringName[H~:T](CHARS(headH.toInt*5+headM.toInt)(headL.toInt)+tail.toString)
	
	def apply[S<:TString](implicit ev: TStringName[S]) = ev.toString

}	