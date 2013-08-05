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

class ArraySuite extends FunSuite {
	
	test("IntU arrays should decompose") {
		val arr = IntUArray[metre](1.of, 3.of)
		val IntUArray(a,b) = arr
		assert(a == 1.of[metre])
		assert(b == 3.of[metre])
	}

	test("IntU arrays should be concatenated correctly") {
		val arr1 = IntUArray[metre]( 0.of, 10.of)
		val arr2 = IntUArray[metre](20.of, 30.of)
		val arr = IntUArray.concat(arr1, arr2)
		assert(arr(0) ==  0.of[metre])
		assert(arr(1) == 10.of[metre])
		assert(arr(2) == 20.of[metre])
		assert(arr(3) == 30.of[metre])
	}

	test("Empty IntU arrays should work") {
		val arr = IntUArray.empty[metre]
		assert(arr.length == 0)
	}
	
	test("Uniform IntU arrays should work") {
		val arr = IntUArray.fillUniform[metre](3)(9.of)
		assert(arr.length == 3)
		assert(arr(0) == 9.of[metre])
		assert(arr(1) == 9.of[metre])
		assert(arr(2) == 9.of[metre])
	}
	
	test("IntU arrays should update correctly") {
		val arr = new IntUArray[metre](2)
		arr(0) = 775.of[metre]
		arr(1) = 776.of[metre]
		assert(arr(0) == 775.of[metre])
		assert(arr(1) == 776.of[metre])
	}
	
	test("DoubleU arrays should decompose") {
		val arr = DoubleUArray[metre](1.0.of, 3.0.of)
		val DoubleUArray(a,b) = arr
		assert(a == 1.0.of[metre])
		assert(b == 3.0.of[metre])
	}

	test("DoubleU arrays should be concatenated correctly") {
		val arr1 = DoubleUArray[metre]( 0.0.of, 10.0.of)
		val arr2 = DoubleUArray[metre](20.0.of, 30.0.of)
		val arr = DoubleUArray.concat(arr1, arr2)
		assert(arr(0) ==  0.0.of[metre])
		assert(arr(1) == 10.0.of[metre])
		assert(arr(2) == 20.0.of[metre])
		assert(arr(3) == 30.0.of[metre])
	}

	test("Empty DoubleU arrays should work") {
		val arr = DoubleUArray.empty[metre]
	}
	
	test("Uniform DoubleU arrays should work") {
		val arr = DoubleUArray.fillUniform[metre](3)(9.0.of)
		assert(arr.length == 3)
		assert(arr(0) == 9.0.of[metre])
		assert(arr(1) == 9.0.of[metre])
		assert(arr(2) == 9.0.of[metre])
	}
	
	test("DoubleU arrays should update correctly") {
		val arr = new DoubleUArray[metre](2)
		arr(0) = 775.of[metre]
		arr(1) = 776.of[metre]
		assert(arr(0) == 775.of[metre])
		assert(arr(1) == 776.of[metre])
	}

}