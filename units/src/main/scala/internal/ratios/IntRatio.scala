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
package stasiak.units.internal.ratios
import stasiak.units.internal._
import stasiak.units.internal.Conversions._
import stasiak.units._
import stasiak.units.internal.UnitImpl
import stasiak.units.internal.UnitImpl._
import stasiak.units.internal.Strings._
import stasiak.units.internal.Conversions
import stasiak.units.internal.Conversions._
import stasiak.units.internal.SingleUnits._
import stasiak.units.internal.Integers._
import stasiak.units.internal.AffineSpaces
import stasiak.units.internal.AffineSpaces._
import scala.annotation.implicitNotFound

@implicitNotFound(msg="Cannot find an integer ratio to convert from ${U} to ${V}")
class IntRatio[U<:MUnit, V<:MUnit](val ratio: Long) extends AnyVal

object IntRatio {
	@inline
	implicit def implicit_oneIntRatio[U<:MUnit] = new IntRatio[U,U](1)
	@inline
	implicit def implicit_intRatioEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U,V]
		) = new IntRatio[U,V](declaredRatio.ratio)
	@inline
	implicit def implicit_squareIntRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U#Sqrt,V#Sqrt]
		) = new IntRatio[U,V](declaredRatio.ratio * declaredRatio.ratio)
	@inline
	implicit def implicit_cubeIntRatio[U<:MUnit, V<:MUnit](
		implicit declaredRatio:BaseIntRatio[U#Cbrt,V#Cbrt]
		) = new IntRatio[U,V](declaredRatio.ratio * declaredRatio.ratio * declaredRatio.ratio)
	@inline
	implicit def implicit_intRatioAliasEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U,V]
		) = new IntRatio[U,V](1)
	@inline
	implicit def implicit_intRatioAliasSqEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Sqrt,V#Sqrt]
		) = new IntRatio[U,V](1)
	@inline
	implicit def implicit_intRatioAliasCbEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Cbrt,V#Cbrt]
		) = new IntRatio[U,V](1)
	@inline
	implicit def implicit_intRatioAliasRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U,V]
		) = new IntRatio[V,U](1)
	@inline
	implicit def implicit_intRatioAliasSqRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Sqrt,V#Sqrt]
		) = new IntRatio[V,U](1)
	@inline
	implicit def implicit_intRatioAliasCbRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Cbrt,V#Cbrt]
		) = new IntRatio[V,U](1)

}