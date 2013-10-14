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
package stasiak.karol.units.internal.ratios
import stasiak.karol.units.internal._
import stasiak.karol.units.internal.Conversions._
import stasiak.karol.units._
import stasiak.karol.units.internal.UnitImpl
import stasiak.karol.units.internal.UnitImpl._
import stasiak.karol.units.internal.Strings._
import stasiak.karol.units.internal.Conversions
import stasiak.karol.units.internal.Conversions._
import stasiak.karol.units.internal.SingleUnits._
import stasiak.karol.units.internal.Integers._
import stasiak.karol.units.internal.AffineSpaces
import stasiak.karol.units.internal.AffineSpaces._

class BaseDoubleRatio[U<:MUnit, V<:MUnit](val ratio: Double) extends AnyVal {
	@inline
	def times[Y<:MUnit] =
		new BaseDoubleRatio[U#Mul[Y],V#Mul[Y]](ratio)
	@inline
	def dividedBy[Y<:MUnit] =
		new BaseDoubleRatio[U#Mul[Y#Invert],V#Mul[Y#Invert]](ratio)
	@inline
	def invert = new BaseDoubleRatio[V,U](1.0/ratio)
	@inline
	def pow2 = this * this
	@inline
	def pow3 = this * this * this
	@inline
	def *[X<:MUnit, Y<:MUnit](that: BaseDoubleRatio[X,Y]) =
		new BaseDoubleRatio[U#Mul[X],V#Mul[Y]](ratio*that.ratio)
	@inline
	def *[X<:MUnit, Y<:MUnit](that: BaseIntRatio[X,Y]) =
		new BaseDoubleRatio[U#Mul[X],V#Mul[Y]](ratio*that.ratio)
	@inline
	def /[X<:MUnit, Y<:MUnit](that: BaseIntRatio[X,Y]) =
		new BaseDoubleRatio[U#Mul[X#Invert],V#Mul[Y#Invert]](ratio/that.ratio)
	@inline
	def /[X<:MUnit, Y<:MUnit](that: BaseDoubleRatio[X,Y]) =
		new BaseDoubleRatio[U#Mul[X#Invert],V#Mul[Y#Invert]](ratio/that.ratio)
	@inline
	def ><[Y<:MUnit](that: BaseDoubleRatio[Y,V]) = new BaseDoubleRatio[U,Y](ratio/that.ratio)
	@inline
	def ><[Y<:MUnit](that: BaseIntRatio[Y,V]) = new BaseDoubleRatio[U,Y](ratio/that.ratio)
	@inline
	def <>[Y<:MUnit](that: BaseDoubleRatio[U,Y]) = new BaseDoubleRatio[Y,V](ratio/that.ratio)
	@inline
	def <>[Y<:MUnit](that: BaseIntRatio[U,Y]) = new BaseDoubleRatio[Y,V](ratio.toDouble/that.ratio)
	@inline
	def >>[Y<:MUnit](that: BaseDoubleRatio[V,Y]) = new BaseDoubleRatio[U,Y](ratio*that.ratio)
	@inline
	def >>[Y<:MUnit](that: BaseIntRatio[V,Y]) = new BaseDoubleRatio[U,Y](ratio*that.ratio)
}
