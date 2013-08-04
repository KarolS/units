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
import language.higherKinds
import language.implicitConversions
import Bools._
import Integers._
import Strings._
import SingleUnits._
import UnitImpl._
import stasiak.karol.units.MUnit
import scala.annotation.implicitNotFound

@implicitNotFound(msg="Cannot find a human-friendly name for unit ${U}")
class UnitName[U<:MUnit](override val toString: String) extends AnyVal	

object UnitName {
	@inline
	implicit val implicit_dimensionlessName = new UnitName[TDimensionless]("")
	@inline
	implicit def implicit_consUnitName[H<:TUnitPowerPair, T<:MUnit](implicit h:TUnitPowerPairName[H], t:UnitName[T]) = 
		new UnitName[T**H](h.toString + " " + t.toString)
	@inline
	implicit def implicit_singleUnitName[H<:TUnitPowerPair](implicit h:TUnitPowerPairName[H]) = 
		new UnitName[H](h.toString)
}

class TUnitPowerPairName[U<:TUnitPowerPair](w: String){
	override def toString = w
}
object TUnitPowerPairName {
	@inline
	implicit def implicit_unitPowerPairName[U<:TUnitPowerPair](
		implicit stringName: TStringName[U#UnitName#Name], power:ToInt[U#Power]
		) = new TUnitPowerPairName[U](
		" " + stringName.toString + (
			if(power.toInt<0)  s"^(${power.toInt})" else (if (power.toInt>1) s"^${power.toInt}" else "")
		)
	)
}