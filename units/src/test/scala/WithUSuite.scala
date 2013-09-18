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
package stasiak.karol.units_tests

import org.scalatest.FunSuite
import stasiak.karol.units._
import defining._
import SI._
import USCustomary._
import arrays._
import scala.math._

class WithUSuite extends FunSuite {

	test("Addition should work") {
		val i = BigDecimal(1).of[metre]
		val j = BigDecimal(2).of[metre]
		val sum: BigDecimal @@ metre = i+j
		assert(sum === BigDecimal(3).of[metre])
	}
	test("Subtraction should work") {
		val i = BigInt(1).of[metre]
		val j = BigInt(2).of[metre]
		val diff: BigInt @@ metre = i-j
		assert(diff === BigInt(-1).of[metre])
	}
	test("Multiplication should work") {
		val i = BigInt(1).of[metre]
		val j = BigInt(2).of[metre]
		val product: BigInt @@ square[metre] = i*j
		assert(product === BigInt(2).of[square[metre]])
	}
	test("Sorting should work"){
		val l: List[BigInt @@ second] = List(1,4,2).map(i=>BigInt(i).of[second])
		val s: List[BigInt @@ second] = l.sorted
		val e: List[BigInt @@ second] = List(1,2,4).map(i=>BigInt(i).of[second])
		assert(s === e)
	} 
}