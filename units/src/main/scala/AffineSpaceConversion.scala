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
package stasiak.karol.units.defining

import language.higherKinds
import language.implicitConversions
import stasiak.karol.units._
import stasiak.karol.units.internal.ratios._
import stasiak.karol.units.internal.UnitImpl._
import stasiak.karol.units.internal.Strings
import stasiak.karol.units.internal.Strings._
import stasiak.karol.units.internal.Integers._
import stasiak.karol.units.internal.Conversions._
import stasiak.karol.units.internal.AffineSpaces
import stasiak.karol.units.internal.AffineSpaces._
import stasiak.karol.units.internal.SingleUnits._

sealed trait ReversibleDoubleAConversion[A<:AffineSpace, B<:AffineSpace]{
	val forward: DoubleA[A]=>DoubleA[B]
	val backward: DoubleA[B]=>DoubleA[A]
}

sealed trait ReversibleIntAConversion[A<:AffineSpace, B<:AffineSpace]{
	val forwardInt: IntA[A]=>IntA[B]
	val backwardInt: IntA[B]=>IntA[A]
}

class DoubleATranslation[A<:AffineSpace, B<:AffineSpace](
	val vector: DoubleU[A#Unit]
)(implicit ev: A#Unit =:= B#Unit) extends ReversibleDoubleAConversion[A,B] {
	val forward = (a:DoubleA[A]) => (a.value + vector.value).at[B]
	val backward = (b:DoubleA[B]) => (b.value - vector.value).at[A]
}

class DoubleAScalingTranslation[A<:AffineSpace, B<:AffineSpace](
	val scale: DoubleU[B#Unit / A#Unit],
	val vector: DoubleU[B#Unit]
) extends ReversibleDoubleAConversion[A,B] {
	val forward = (a:DoubleA[A]) => (a.value*scale.value + vector.value).at[B]
	val backward = (b:DoubleA[B]) => ((b.value - vector.value)/scale.value).at[A]
}

class DoubleATranslationScaling[A<:AffineSpace, B<:AffineSpace](
	val vector: DoubleU[A#Unit],
	val scale: DoubleU[B#Unit / A#Unit]
) extends ReversibleDoubleAConversion[A,B] {
	val forward = (a:DoubleA[A]) => ((a.value + vector.value)*scale.value + vector.value).at[B]
	val backward = (b:DoubleA[B]) => (b.value / scale.value - vector.value).at[A]
}

class IntATranslation[A<:AffineSpace, B<:AffineSpace](
	val vector: IntU[A#Unit]
)(implicit ev: A#Unit =:= B#Unit) extends ReversibleDoubleAConversion[A,B] with ReversibleIntAConversion[A,B] {
	val forward = (a:DoubleA[A]) => (a.value + vector.value).at[B]
	val backward = (b:DoubleA[B]) => (b.value - vector.value).at[A]
	val forwardInt = (a:IntA[A]) => (a.value + vector.value).at[B]
	val backwardInt = (b:IntA[B]) => (b.value - vector.value).at[A]
}
