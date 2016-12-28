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
package io.github.karols.units.internal.ratios
import io.github.karols.units._

import scala.annotation.implicitNotFound

@implicitNotFound(msg="Cannot find a ratio to convert from ${U} to ${V}")
class DoubleRatio[U<:MUnit, V<:MUnit](val ratio: Double) extends AnyVal

object DoubleRatio {
	@inline
	implicit def implicit_oneDoubleRatio[U<:MUnit] = new DoubleRatio[U,U](1.0)

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
	implicit def implicit_doubleRatioAliasEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U,V]
		) = new DoubleRatio[U,V](1)
	@inline
	implicit def implicit_doubleRatioAliasSqEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Sqrt,V#Sqrt]
		) = new DoubleRatio[U,V](1)
	@inline
	implicit def implicit_doubleRatioAliasCbEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Cbrt,V#Cbrt]
		) = new DoubleRatio[U,V](1)
	@inline
	implicit def implicit_doubleRatioAliasRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U,V]
		) = new DoubleRatio[V,U](1)
	@inline
	implicit def implicit_doubleRatioAliasSqRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Sqrt,V#Sqrt]
		) = new DoubleRatio[V,U](1)
	@inline
	implicit def implicit_doubleRatioAliasCbRevEv[U<:MUnit, V<:MUnit](
		implicit declaredRatio:UnitAlias[U#Cbrt,V#Cbrt]
		) = new DoubleRatio[V,U](1)
}