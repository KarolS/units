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
package io.github.karols.units_tests

import org.scalatest.FunSuite
import io.github.karols.units._
import defining._
import SI._
import USCustomary._
import arrays._
import scala.math._

class WithASuite extends FunSuite {

	test("Addition should work") {
		val i = BigDecimal(1).at[CelsiusScale]
		val j = BigDecimal(2).of[celsius_deg]
		val sum: WithA[BigDecimal,CelsiusScale] = i+j
		assert(sum === BigDecimal(3).at[CelsiusScale])
	}
	test("Subtraction should work") {
		val i = BigInt(1).at[CelsiusScale]
		val j = BigInt(2).of[celsius_deg]
		val sum: WithA[BigInt,CelsiusScale] = i-j
		assert(sum === BigInt(-1).at[CelsiusScale])
	}
	test("Difference should work") {
		val i = BigInt(1).at[CelsiusScale]
		val j = BigInt(2).at[CelsiusScale]
		val diff: BigInt @@ celsius_deg = i--j
		assert(diff === BigInt(-1).of[celsius_deg])
	}
	test("Sorting should work"){
		val l: List[WithA[BigInt, CelsiusScale]] = List(1,4,2).map(i=>BigInt(i).at[CelsiusScale])
		val s: List[WithA[BigInt, CelsiusScale]] = l.sorted
		val e: List[WithA[BigInt, CelsiusScale]] = List(1,2,4).map(i=>BigInt(i).at[CelsiusScale])
		assert(s === e)
	}
}