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

import java.time.Duration

import io.github.karols.units._
import io.github.karols.units.SI.Short.{ms, s}
import io.github.karols.units.SI.{day, hour, minute}

package object javatime {
  implicit def implicit__msToDuration(x: IntU[ms]) = Duration.ofMillis(x.value)
  implicit def implicit__sToDuration(x: IntU[s]) = Duration.ofSeconds(x.value)
  implicit def implicit__minToDuration(x: IntU[minute]) = Duration.ofMinutes(x.value)
  implicit def implicit__hourToDuration(x: IntU[hour]) = Duration.ofHours(x.value)
  implicit def implicit__dayToDuration(x: IntU[day]) = Duration.ofDays(x.value)

  implicit def implicit__durationToMs(x: Duration) = x.toMillis.of[ms]
}
