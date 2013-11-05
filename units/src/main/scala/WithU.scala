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

object WithU {
	// TODO: circumvent erasure-related problems
	implicit def _orderingInstance[N, U<:MUnit](implicit o:Ordering[N]): Ordering[WithU[N,U]] =
		new Ordering[WithU[N,U]]{
			override def compare(x:WithU[N,U], y:WithU[N,U]) =
				o.compare(x.value, y.value)
		}
}

/**
	A value with a unit of measure.

	'''Warning: this is an experimental feature
	and may be subject to removal or severe redesign.'''
*/
case class WithU[@specialized N, U<:MUnit](val value:N) {

	@inline
	def mkString(implicit name: UnitName[U]) = value.toString + name.toString

	@inline
	override def toString = value.toString

	/** Add a value with the same unit. */
	def +(i: WithU[N,U])(implicit n: Numeric[N]) = WithU[N,U](n.plus(value,i.value))

	/** Subtract a value with the same unit. */
	def -(i: WithU[N,U])(implicit n: Numeric[N]) = WithU[N,U](n.minus(value,i.value))


	/** Negate this value. */
	def unary_-(implicit n: Numeric[N]) = WithU[N,U](n.negate(value))


	/** Multiply by a value with a unit. */
	def *[V<:MUnit](i: WithU[N,V])(implicit n: Numeric[N]) =
		WithU[N,U#Mul[V]](n.times(value,i.value))
	/** Multiply by a dimensionless value. */
	def *(i: N)(implicit n: Numeric[N]) =
		WithU[N,U](n.times(value,i))
	/** Multiply by a dimensionless value. */
	def times(i: Int)(implicit n: Numeric[N]) =
		WithU[N,U](n.times(value,n.fromInt(i)))

	/** Divide by a value with a unit. */
	def /[V<:MUnit](i: WithU[N,V])(implicit n: Fractional[N]) =
		WithU[N,U#Mul[V#Invert]](n.div(value,i.value))
	/** Divide by a dimensionless value. */
	def /(i: N)(implicit n: Fractional[N]) =
		WithU[N,U](n.div(value,i))
	/** Divide by a dimensionless value. */
	def dividedBy(i: Int)(implicit n: Fractional[N]) =
		WithU[N,U](n.div(value,n.fromInt(i)))

	def < (i: WithU[N,U])(implicit o:Ordering[N]) = o.compare(value,i.value) <  0
	def <=(i: WithU[N,U])(implicit o:Ordering[N]) = o.compare(value,i.value) <= 0
	def > (i: WithU[N,U])(implicit o:Ordering[N]) = o.compare(value,i.value) >  0
	def >=(i: WithU[N,U])(implicit o:Ordering[N]) = o.compare(value,i.value) >= 0
}