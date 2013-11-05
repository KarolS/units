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
package stasiak.units

import language.higherKinds
import language.implicitConversions
import language.existentials
import stasiak.units.internal.Bools._
import stasiak.units.internal.Integers._
import stasiak.units.internal.Strings._
import stasiak.units.internal.SingleUnits._
import stasiak.units.internal.UnitImpl._
import stasiak.units.internal.Conversions._
import scala.math

/** Supertype of all units of measure. */
trait MUnit {
	/**
		@see stasiak.units./
		@see [[stasiak.units._1]]
	*/
	type Invert <: MUnit
	type Get[U<:TSingleUnit] <:TInteger
	type MulSingle[S<:TUnitPowerPair] <: MUnit
	/** @see stasiak.units.× */
	type Mul[S<:MUnit] <: MUnit
	type Sqrt <:MUnit
	type Cbrt <:MUnit
	/** @see [[stasiak.units.square]] */
	type IsSquare <: TBool
	/** @see [[stasiak.units.cube]] */
	type IsCube <: TBool
	type ToPower[Exp<:TInteger] <: MUnit
	type Substitute[S<:TSingleUnit, V<:MUnit] <: MUnit
}
