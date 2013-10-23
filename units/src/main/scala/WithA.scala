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
package stasiak.karol.units

import language.higherKinds
import language.implicitConversions
import language.existentials
import stasiak.karol.units.internal.ratios._
import stasiak.karol.units.internal.Bools._
import stasiak.karol.units.internal.Integers._
import stasiak.karol.units.internal.Strings._
import stasiak.karol.units.internal.SingleUnits._
import stasiak.karol.units.internal.UnitImpl._
import stasiak.karol.units.internal.Conversions._
import stasiak.karol.units.internal.UnionType._
import stasiak.karol.units.internal.UnitName
import scala.math
import scala.math.{Numeric, Fractional}

object WithA {
	// TODO: circumvent erasure-related problems
	implicit def _orderingInstance[N, A<:AffineSpace](implicit o:Ordering[N]) = new Ordering[Any]{
		override def compare(x:Any, y:Any) =
			o.compare(x.asInstanceOf[WithA[N,A]].value, y.asInstanceOf[WithA[N,A]].value)
	}.asInstanceOf[Ordering[WithA[N,A]]]
}

/**
	A value within an affine space.

	'''Warning: this is an experimental feature
	and may be subject to removal or severe redesign.'''
*/
case class WithA[N, A<:AffineSpace](val value:N) extends AnyVal {

	@inline
	def mkString(implicit name: UnitName[A#Unit]) = value.toString + name.toString

	@inline
	override def toString = value.toString

	/** Add a value with the same unit. */
	def +(i: WithU[N,A#Unit])(implicit n: Numeric[N]) = WithA[N,A](n.plus(value,i.value))

	/** Subtract a value with the same unit. */
	def -(i: WithU[N,A#Unit])(implicit n: Numeric[N]) = WithA[N,A](n.minus(value,i.value))

	/** Subtract a value with the same unit. */
	def --(i: WithA[N,A])(implicit n: Numeric[N]) = WithU[N,A#Unit](n.minus(value,i.value))

	@inline def fromZero = new WithU[N,A#Unit](value)

	def < (i: WithA[N,A])(implicit o:Ordering[N]) = o.compare(value,i.value) <  0
	def <=(i: WithA[N,A])(implicit o:Ordering[N]) = o.compare(value,i.value) <= 0
	def > (i: WithA[N,A])(implicit o:Ordering[N]) = o.compare(value,i.value) >  0
	def >=(i: WithA[N,A])(implicit o:Ordering[N]) = o.compare(value,i.value) >= 0
}