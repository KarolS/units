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
package io.github.karols.units.internal.ratios
import io.github.karols.units.internal._
import io.github.karols.units.internal.Conversions._
import io.github.karols.units._
import io.github.karols.units.internal.UnitImpl
import io.github.karols.units.internal.UnitImpl._
import io.github.karols.units.internal.Strings._
import io.github.karols.units.internal.Conversions
import io.github.karols.units.internal.Conversions._
import io.github.karols.units.internal.SingleUnits._
import io.github.karols.units.internal.Integers._
import io.github.karols.units.internal.AffineSpaces
import io.github.karols.units.internal.AffineSpaces._
import scala.annotation.implicitNotFound

@implicitNotFound(msg="Cannot find an integer ratio to coalesce ${U} and ${V}")
class RightIntRatio[U<:MUnit, V<:MUnit, W<:MUnit](val ratio: Long) extends AnyVal

object RightIntRatio {
	@inline
	implicit def implicit_oneRightIntRatio[U<:MUnit] = new RightIntRatio[U,U,U](1)
	@inline
	implicit def implicit_rightIntRatio[U<:MUnit, V<:MUnit](implicit ev: IntRatio[U,V]) =
		new RightIntRatio[U,V,V](1)
	@inline
	implicit def implicit_rightIntRatioRev[U<:MUnit, V<:MUnit](implicit ev: IntRatio[V,U]) =
		new RightIntRatio[U,V,U](ev.ratio)

}