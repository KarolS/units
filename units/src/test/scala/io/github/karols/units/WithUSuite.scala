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

import org.scalatest.FunSuite
import io.github.karols.units._
import defining._
import SI._
import USCustomary._
import arrays._
import scala.math._

class WithUSuite extends FunSuite {

	test("Addition should work") {
		val i = BigDecimal(1).of[metre]
		val j = BigDecimal(2).of[metre]
		val sum: BigDecimal @@ metre = i + j
		assert(sum === BigDecimal(3).of[metre])
	}
	test("Subtraction should work") {
		val i = BigInt(1).of[metre]
		val j = BigInt(2).of[metre]
		val diff: BigInt @@ metre = i - j
		assert(diff === BigInt(-1).of[metre])
	}
	test("Multiplication should work") {
		val i = BigInt(1).of[metre]
		val j = BigInt(2).of[metre]
		val product: BigInt @@ square[metre] = i * j
		assert(product === BigInt(2).of[square[metre]])
	}
	test("Sorting should work"){
		val l: List[BigInt @@ second] = List(1,4,2).map(i=>BigInt(i).of[second])
		val s: List[BigInt @@ second] = l.sorted
		val e: List[BigInt @@ second] = List(1,2,4).map(i=>BigInt(i).of[second])
		assert(s === e)
	}
	test("Superlative prefixes should work"){
		assert(1.deca[metre] === 10.of[metre])
		assert(1.hecto[metre] === 10.deca[metre])
		assert(1.kilo[metre] === 10.hecto[metre])
		assert(1.mega[metre] === 1000.kilo[metre])
		assert(1.giga[metre] === 1000.mega[metre])
		assert(1.tera[metre] === 1000.giga[metre])
	}
	test("Diminutive prefixes should work"){
		assert(10.deci[metre] === 1.0.of[metre])
		assert(10.centi[metre] === 1.deci[metre])
		assert(10.milli[metre] === 1.centi[metre])
		assert(1000.micro[metre] === 1.milli[metre])
		assert(1000.nano[metre] === 1.micro[metre])
		assert(1000.pico[metre] === 1.nano[metre])
		assert(1000.femto[metre] === 1.pico[metre])
		assert(1000.atto[metre] === 1.femto[metre])
	}

}