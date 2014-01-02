/*
Copyright (c) 2013-2014 Karol M. Stasiak

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

import io.github.karols.units.SI._
import io.github.karols.units.SI.Short._
import org.joda.time._
import language.implicitConversions

package object jodaSupport {
	implicit def implicit__msToDuration(x: IntU[ms]) = Duration.millis(x.value)
	implicit def implicit__sToDuration(x: IntU[s]) = Duration.standardSeconds(x.value)
	implicit def implicit__minToDuration(x: IntU[minute]) = Duration.standardMinutes(x.value)
	implicit def implicit__hourToDuration(x: IntU[hour]) = Duration.standardHours(x.value)
	implicit def implicit__dayToDuration(x: IntU[day]) = Duration.standardDays(x.value)

	implicit def implicit__sToJ(x: IntU[s]) = Seconds.seconds(x.value.toInt)
	implicit def implicit__minToJ(x: IntU[minute]) = Minutes.minutes(x.value.toInt)
	implicit def implicit__hourToJ(x: IntU[hour]) = Hours.hours(x.value.toInt)

	implicit def implicit__durationToMs(x: Duration) = x.getMillis.of[ms]
	implicit def implicit__jToH(x: Hours) = x.getHours.of[hour]
	implicit def implicit__jToMin(x: Minutes) = x.getMinutes.of[minute]
	implicit def implicit__jToS(x: Seconds) = x.getSeconds.of[s]
}