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
import stasiak.karol.units.{DoubleRatio=>_, _}
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
	val forward: Double=>Double
	val backward: Double=>Double
}

sealed trait ReversibleIntAConversion[A<:AffineSpace, B<:AffineSpace]{
	val forwardInt: Long=>Long
	val backwardInt: Long=>Long
}

/** 
	A two-way conversion between affine spaces with the same underlying units.
	`vector` is the distance between the zeroes of the spaces.
	Instances of this class should be implicit.
*/
class DoubleATranslation[A<:AffineSpace, B<:AffineSpace](
	val vector: DoubleU[A#Unit]
)(implicit ev: A#Unit =:= B#Unit) extends ReversibleDoubleAConversion[A,B] {
	val forward = (a:Double) => (a + vector.value)
	val backward = (b:Double) => (b - vector.value)
}

/** 
	A two-way conversion between affine spaces with different underlying units.
	`scale` is the conversion between the units.
	`vector` is the distance between the zeroes of the space B and scaled space A.
	Instances of this class should be implicit.
*/
class DoubleAScalingTranslation[A<:AffineSpace, B<:AffineSpace](
	val scale: DoubleU[B#Unit / A#Unit],
	val vector: DoubleU[B#Unit]
) extends ReversibleDoubleAConversion[A,B] {

	def this(vector: DoubleU[B#Unit])(implicit ev: DoubleRatio[A#Unit, B#Unit], erasureAvoidance: Unit=:=Unit) {
		this(1.0.represent[A#Unit, B#Unit].value.of[B#Unit / A#Unit], vector)
	}	

	val forward = (a:Double) => (a*scale.value + vector.value)
	val backward = (b:Double) => ((b - vector.value)/scale.value)
}

/** 
	A two-way conversion between affine spaces with different underlying units.
	`scale` is the conversion between the units.
	`vector` is the distance between the zeroes of the space B and scaled space A.
	Instances of this class should be implicit.
*/
class DoubleATranslationScaling[A<:AffineSpace, B<:AffineSpace](
	val vector: DoubleU[A#Unit],
	val scale: DoubleU[B#Unit / A#Unit]
) extends ReversibleDoubleAConversion[A,B] {

	def this(vector: DoubleU[A#Unit])(implicit ev: DoubleRatio[A#Unit, B#Unit], erasureAvoidance: Unit=:=Unit) {
		this(vector, 1.0.represent[A#Unit, B#Unit].value.of[B#Unit / A#Unit])
	}

	val forward = (a:Double) => ((a + vector.value)*scale.value)
	val backward = (b:Double) => (b / scale.value - vector.value)
}

/** 
	A two-way conversion between affine spaces with the same underlying units.
	`vector` is the distance between the zeroes of the spaces.
	Instances of this class should be implicit.
*/
class IntATranslation[A<:AffineSpace, B<:AffineSpace](
	val vector: IntU[A#Unit]
)(implicit ev: A#Unit =:= B#Unit) extends ReversibleDoubleAConversion[A,B] with ReversibleIntAConversion[A,B] {
	val forward = (a:Double) => (a + vector.value)
	val backward = (b:Double) => (b - vector.value)
	val forwardInt = (a:Long) => (a + vector.value)
	val backwardInt = (b:Long) => (b - vector.value)
}
