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

@implicitNotFound(msg="Cannot find a ratio to convert ${U} inside ${V}. Are you sure ${U} is a simple unit?")
class PowerDoubleRatio[U<:TSingleUnit, Power<:TInteger, V<:MUnit, N<:TInteger](val ratio: Double) extends AnyVal

object PowerDoubleRatio {
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


}