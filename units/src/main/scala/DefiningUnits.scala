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
package io.github.karols.units

/**
	Package containing helper types and methods for defining new units
	and ratios between units.

	It also contains a set of type-level characters,
	used for defining type-level unit identifiers.

	Usage:

	`import io.github.karols.units.defining._`
*/
package object defining {
	import language.higherKinds
	import language.implicitConversions
	import io.github.karols.units.internal.ratios._
	import io.github.karols.units.internal.UnitImpl._
	import io.github.karols.units.internal.Strings
	import io.github.karols.units.internal.Strings._
	import io.github.karols.units.internal.Integers._
	import io.github.karols.units.internal.Conversions._
	import io.github.karols.units.internal.AffineSpaces
	import io.github.karols.units.internal.AffineSpaces._
	import io.github.karols.units.internal.SingleUnits._

	/** Helper for defining unit ratios. Syntax: `one[kilometre].contains(1000)[metre]` */
	@inline def one[U<:MUnit] = new OneBuilder[U]

	/** Defines a unit of measure identified by given type-level string. */
	type DefineUnit[S<:TString] = ASingleUnit[S]^P1

	/** Defines a 1-dimensional affine space using given unit and starting at given zero point.*/
	type DefineAffineSpace[Z, U<:MUnit] = AffineSpaces.DefineAffineSpace[Z, U]

	/** String constructor. Separate type-level characters with `~:` to create a type-level string. */
	type ~:[H<:TChar,T<:TString] = Strings.~:[H,T]

	/**
		Creates a one-way affine space converter.
		You should store it in an implicit val.
	*/
	@inline
	def convertAffineSpace[T1<:AffineSpace, T2<:AffineSpace](f: Double => Double) =
		new DoubleAffineSpaceConverter[T1,T2](f)

	/**
		Creates a one-way integer affine space converter.
		You should store it in an implicit val.
	*/
	@inline
	def convertIntAffineSpace[T1<:AffineSpace, T2<:AffineSpace](f: Long => Long) =
		new IntAffineSpaceConverter[T1,T2](f)

	/**
		Creates a two-way affine space converter,
		based on two points x and y defined in two affine spaces.
		You should store it in an implicit val.
	*/
	@inline
	def matchingAffineSpacePoints[A<:AffineSpace, B<:AffineSpace](
		xA: DoubleA[A], xB: DoubleA[B],
		yA: DoubleA[A], yB: DoubleA[B]
	) = new DoubleATwoValues[A,B](xA, xB, yA, yB)

	/**
		Creates a two-way affine space converter,
		based on one points defined in two affine spaces.
		The affine spaces should have the same base unit.
		This defines a translation – a conversion that
		simply shifts values by a constant displacement.
		You should store it in an implicit val.
	*/
	@inline
	def matchingAffineSpacePoint[A<:AffineSpace, B<:AffineSpace](
		xA: DoubleA[A], xB: DoubleA[B]
	)(implicit ev: A#Unit =:= B#Unit) =
		new DoubleATranslation[A,B]((xA.value - xB.value).of[A#Unit])

	@inline
	def productInt[F1<:MUnit,F2<:MUnit,T1<:MUnit,T2<:MUnit](
		implicit r1: BaseIntRatio[F1,T2], r2: BaseIntRatio[F2,T2]
		) = r1*r2
	@inline
	def product[F1<:MUnit,F2<:MUnit,T1<:MUnit,T2<:MUnit](
		implicit r1: DoubleRatio[F1,T2], r2: DoubleRatio[F2,T2]
		) = new BaseDoubleRatio[F1#Mul[F2], T1#Mul[T2]](r1.ratio * r2.ratio)

	@inline def alias[F<:MUnit, T<:MUnit] = new UnitAlias[F,T]

	/** commercial at sign (@) */
	type _at = AChar[TZ5_0, TZ5_0, TZ5_0]

	type _A = AChar[TZ5_0, TZ5_0, TZ5_1]
	type _B = AChar[TZ5_0, TZ5_0, TZ5_2]
	type _C = AChar[TZ5_0, TZ5_0, TZ5_3]
	type _D = AChar[TZ5_0, TZ5_0, TZ5_4]
	type _E = AChar[TZ5_0, TZ5_1, TZ5_0]
	type _F = AChar[TZ5_0, TZ5_1, TZ5_1]
	type _G = AChar[TZ5_0, TZ5_1, TZ5_2]
	type _H = AChar[TZ5_0, TZ5_1, TZ5_3]
	type _I = AChar[TZ5_0, TZ5_1, TZ5_4]
	type _J = AChar[TZ5_0, TZ5_2, TZ5_0]
	type _K = AChar[TZ5_0, TZ5_2, TZ5_1]
	type _L = AChar[TZ5_0, TZ5_2, TZ5_2]
	type _M = AChar[TZ5_0, TZ5_2, TZ5_3]
	type _N = AChar[TZ5_0, TZ5_2, TZ5_4]
	type _O = AChar[TZ5_0, TZ5_3, TZ5_0]
	type _P = AChar[TZ5_0, TZ5_3, TZ5_1]
	type _Q = AChar[TZ5_0, TZ5_3, TZ5_2]
	type _R = AChar[TZ5_0, TZ5_3, TZ5_3]
	type _S = AChar[TZ5_0, TZ5_3, TZ5_4]
	type _T = AChar[TZ5_0, TZ5_4, TZ5_0]
	type _U = AChar[TZ5_0, TZ5_4, TZ5_1]
	type _V = AChar[TZ5_0, TZ5_4, TZ5_2]
	type _W = AChar[TZ5_0, TZ5_4, TZ5_3]
	type _X = AChar[TZ5_0, TZ5_4, TZ5_4]
	type _Y = AChar[TZ5_1, TZ5_0, TZ5_0]
	type _Z = AChar[TZ5_1, TZ5_0, TZ5_1]

	type _a = AChar[TZ5_1, TZ5_0, TZ5_3]
	type _b = AChar[TZ5_1, TZ5_0, TZ5_4]
	type _c = AChar[TZ5_1, TZ5_1, TZ5_0]
	type _d = AChar[TZ5_1, TZ5_1, TZ5_1]
	type _e = AChar[TZ5_1, TZ5_1, TZ5_2]
	type _f = AChar[TZ5_1, TZ5_1, TZ5_3]
	type _g = AChar[TZ5_1, TZ5_1, TZ5_4]
	type _h = AChar[TZ5_1, TZ5_2, TZ5_0]
	type _i = AChar[TZ5_1, TZ5_2, TZ5_1]
	type _j = AChar[TZ5_1, TZ5_2, TZ5_2]
	type _k = AChar[TZ5_1, TZ5_2, TZ5_3]
	type _l = AChar[TZ5_1, TZ5_2, TZ5_4]
	type _m = AChar[TZ5_1, TZ5_3, TZ5_0]
	type _n = AChar[TZ5_1, TZ5_3, TZ5_1]
	type _o = AChar[TZ5_1, TZ5_3, TZ5_2]
	type _p = AChar[TZ5_1, TZ5_3, TZ5_3]
	type _q = AChar[TZ5_1, TZ5_3, TZ5_4]
	type _r = AChar[TZ5_1, TZ5_4, TZ5_0]
	type _s = AChar[TZ5_1, TZ5_4, TZ5_1]
	type _t = AChar[TZ5_1, TZ5_4, TZ5_2]
	type _u = AChar[TZ5_1, TZ5_4, TZ5_3]
	type _v = AChar[TZ5_1, TZ5_4, TZ5_4]
	type _w = AChar[TZ5_2, TZ5_0, TZ5_0]
	type _x = AChar[TZ5_2, TZ5_0, TZ5_1]
	type _y = AChar[TZ5_2, TZ5_0, TZ5_2]
	type _z = AChar[TZ5_2, TZ5_0, TZ5_3]

	/** angström sign (Å) */
	type _AA = AChar[TZ5_2, TZ5_0, TZ5_4]

	/** micro sign (µ) */
	type _mu = AChar[TZ5_2, TZ5_1, TZ5_0]
	/** ohm sign (Ω) */
	type _OMEGA = AChar[TZ5_2, TZ5_1, TZ5_1]

	/** pound sign (£) */
	type _POUND = AChar[TZ5_2, TZ5_2, TZ5_0]
	/** yen sign (¥) */
	type _YEN = AChar[TZ5_2, TZ5_2, TZ5_1]
	/** dollar sign ($) */
	type _DOLLAR = AChar[TZ5_2, TZ5_2, TZ5_2]
	/** euro sign (€) */
	type _EURO = AChar[TZ5_2, TZ5_2, TZ5_3]
	/** lowercase L with stroke (ł) */
	type _l_ = AChar[TZ5_2, TZ5_2, TZ5_4]

	/** degree sign (°) */
	type _deg = AChar[TZ5_2, TZ5_3, TZ5_0]
	/** angular minute sign (’) */
	type _min = AChar[TZ5_2, TZ5_3, TZ5_1]
	/** angular second sign (”) */
	type _sec = AChar[TZ5_2, TZ5_3, TZ5_2]

	/** percent sign (%) */
	type _percent = AChar[TZ5_2, TZ5_4, TZ5_0]
	/** permille sign (‰) */
	type _permille = AChar[TZ5_2, TZ5_4, TZ5_1]

}