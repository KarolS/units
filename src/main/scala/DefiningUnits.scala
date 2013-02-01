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
package stasiak.karol.units

object DefiningUnits {
	import language.higherKinds
	import language.implicitConversions
	import stasiak.karol.units.internal.UnitImpl._
	import stasiak.karol.units.internal.Strings
	import stasiak.karol.units.internal.Strings._
	import stasiak.karol.units.internal.Integers._
	import stasiak.karol.units.internal.ValuesWithUnits._
	import stasiak.karol.units.internal.Conversions._
	import stasiak.karol.units.internal.AffineSpaces
	import stasiak.karol.units.internal.AffineSpaces._
	import stasiak.karol.units.internal.SingleUnits._

	@inline
	def one[U<:MUnit] = new OneBuilder[U]

	type DefineUnit[S<:TString] = ASingleUnit[S,S]^P1
	type DefineAffineSpace[Z, U<:MUnit] = AffineSpaces.DefineAffineSpace[Z, U]

	type ~:[H<:TChar,T<:TString] = Strings.~:[H,T]
	
	@inline
	def convertAffineSpace[T1<:AffineSpace, T2<:AffineSpace](f: Double => Double) = 
		new DoubleAffineSpaceConverter[T1,T2](f)
	@inline
	def convertIntAffineSpace[T1<:AffineSpace, T2<:AffineSpace](f: Long => Long) = 
		new IntAffineSpaceConverter[T1,T2](f)

	@inline
	def productInt[F1<:MUnit,F2<:MUnit,T1<:MUnit,T2<:MUnit](
		implicit r1: BaseIntRatio[F1,T2], r2: BaseIntRatio[F2,T2]
		) = r1*r2
	@inline
	def product[F1<:MUnit,F2<:MUnit,T1<:MUnit,T2<:MUnit](
		implicit r1: DoubleRatio[F1,T2], r2: DoubleRatio[F2,T2]
		) = new BaseDoubleRatio[F1#Mul[F2], T1#Mul[T2]](r1.ratio * r2.ratio)
	
	@inline
	def alias[F<:MUnit, T<:MUnit] = new UnitAlias[F,T]

	type _a = AChar[LC0,P1]
	type _b = AChar[LC0,P2]
	type _c = AChar[LC0,P3]
	type _d = AChar[LC0,P4]
	type _e = AChar[LC0,P5]
	type _f = AChar[LC0,P6]
	type _g = AChar[LC0,P7]
	type _h = AChar[LC0,P8]
	type _i = AChar[LC0,P9]
	type _j = AChar[LC0,P10]
	type _k = AChar[LC0,P11]
	type _l = AChar[LC0,P12]
	type _m = AChar[LC0,P13]
	type _n = AChar[LC0,P14]
	type _o = AChar[LC0,P15]
	type _p = AChar[LC1,_0]
	type _q = AChar[LC1,P1]
	type _r = AChar[LC1,P2]
	type _s = AChar[LC1,P3]
	type _t = AChar[LC1,P4]
	type _u = AChar[LC1,P5]
	type _v = AChar[LC1,P6]
	type _w = AChar[LC1,P7]
	type _x = AChar[LC1,P8]
	type _y = AChar[LC1,P9]
	type _z = AChar[LC1,P10]
	type _A = AChar[UC0,P1]
	type _B = AChar[UC0,P2]
	type _C = AChar[UC0,P3]
	type _D = AChar[UC0,P4]
	type _E = AChar[UC0,P5]
	type _F = AChar[UC0,P6]
	type _G = AChar[UC0,P7]
	type _H = AChar[UC0,P8]
	type _I = AChar[UC0,P9]
	type _J = AChar[UC0,P10]
	type _K = AChar[UC0,P11]
	type _L = AChar[UC0,P12]
	type _M = AChar[UC0,P13]
	type _N = AChar[UC0,P14]
	type _O = AChar[UC0,P15]
	type _P = AChar[UC1,_0]
	type _Q = AChar[UC1,P1]
	type _R = AChar[UC1,P2]
	type _S = AChar[UC1,P3]
	type _T = AChar[UC1,P4]
	type _U = AChar[UC1,P5]
	type _V = AChar[UC1,P6]
	type _W = AChar[UC1,P7]
	type _X = AChar[UC1,P8]
	type _Y = AChar[UC1,P9]
	type _Z = AChar[UC1,P10]
	type _deg = AChar[P4,_0]
	type _mu = AChar[P4,P5]
	type _OMEGA = AChar[P6,P9]
	type _AA = AChar[P5,P5]
}