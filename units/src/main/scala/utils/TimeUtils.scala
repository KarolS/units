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
package stasiak.units.utils

object TimeUtils {
	
	import stasiak.units.SI._
	import stasiak.units._
	import stasiak.units.defining._
	import scala.concurrent.duration.{Duration=>CD}
	import java.util.concurrent.{TimeUnit=>TU}
	import language.implicitConversions

	/** 1970-01-01 */
	sealed trait UnixEpoch

	type UnixEpochSeconds = DefineAffineSpace[UnixEpoch, second]
	type UnixEpochMillis  = DefineAffineSpace[UnixEpoch, millisecond]
	type UnixEpochNanos   = DefineAffineSpace[UnixEpoch, nanosecond]

	/** Current time in Unix Epoch. */
	def currentTimeMillis(): IntA[UnixEpochMillis] = System.currentTimeMillis().at[UnixEpochMillis]

	/** Sleep for a given amount of time. */
	def sleep[U<:MUnit](time: IntU[U])(implicit ev: DoubleRatio[U, millisecond]){
		Thread.sleep(time.convert[millisecond].value.toInt)
	}

	/** Sleep for a given amount of time. */
	def sleep[U<:MUnit](time: DoubleU[U])(implicit ev: DoubleRatio[U, millisecond]){
		Thread.sleep(time.convert[millisecond].value.toInt)
	}

	implicit def implicit__nanos_to_cd(t: IntU[nanosecond]) = CD(t.value, TU.NANOSECONDS)
	implicit def implicit__micros_to_cd(t: IntU[microsecond]) = CD(t.value, TU.MICROSECONDS)
	implicit def implicit__millis_to_cd(t: IntU[millisecond]) = CD(t.value, TU.MILLISECONDS)
	implicit def implicit__s_to_cd(t: IntU[second]) = CD(t.value, TU.SECONDS)
	implicit def implicit__min_to_cd(t: IntU[minute]) = CD(t.value, TU.MINUTES)
	implicit def implicit__hour_to_cd(t: IntU[hour]) = CD(t.value, TU.HOURS)
	implicit def implicit__day_to_cd(t: IntU[day]) = CD(t.value, TU.DAYS)
	implicit def implicit__week_to_cd(t: IntU[week]) = CD(t.value * 7, TU.DAYS)

	implicit def implicit__nanos_to_cdd(t: DoubleU[nanosecond]) = CD(t.value, TU.NANOSECONDS)
	implicit def implicit__micros_to_cdd(t: DoubleU[microsecond]) = CD(t.value, TU.MICROSECONDS)
	implicit def implicit__millis_to_cdd(t: DoubleU[millisecond]) = CD(t.value, TU.MILLISECONDS)
	implicit def implicit__s_to_cdd(t: DoubleU[second]) = CD(t.value, TU.SECONDS)
	implicit def implicit__min_to_cdd(t: DoubleU[minute]) = CD(t.value, TU.MINUTES)
	implicit def implicit__hour_to_cdd(t: DoubleU[hour]) = CD(t.value, TU.HOURS)
	implicit def implicit__day_to_cdd(t: DoubleU[day]) = CD(t.value, TU.DAYS)
	implicit def implicit__week_to_cdd(t: DoubleU[week]) = CD(t.value * 7, TU.DAYS)

}