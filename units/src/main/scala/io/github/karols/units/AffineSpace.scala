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
package io.github.karols.units

import language.higherKinds
import language.implicitConversions
import io.github.karols.units.internal.Bools._
import io.github.karols.units.internal.Integers._
import io.github.karols.units.internal.Strings._
import io.github.karols.units.internal.SingleUnits._
import io.github.karols.units.internal.UnitImpl._
import io.github.karols.units.internal.Conversions._
import io.github.karols.units.internal.AffineSpaces._

/**
	Supertype of all affine spaces.

	Affine space is similar to a vector space, but it does not contain a distinguished origin point.
	In order to manipulate points from the affine space, we have to pick the origin (aka the zero point) ourselves.

	Examples of affine spaces are temperature scales, time, (physical) space, and so on.
*/
trait AffineSpace {
	/** Marker type representing the zero point. This type does not have to have any instances */
	type Zero
	/** Unit used in this space. */
	type Unit <: MUnit
}