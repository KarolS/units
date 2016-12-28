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
	
	test("Filling out DoubleU arrays should work") {
		var i = 0
		val arr = DoubleUArray.fill[metre](3){
			i += 1
			i*i.of[metre]
		}
		assert(arr.length == 3)
		assert(arr(0) == 1.0.of[metre])
		assert(arr(1) == 4.0.of[metre])
		assert(arr(2) == 9.0.of[metre])
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
	
	test("Filling out DoubleA arrays should work") {
		var i = 0
		val arr = DoubleAArray.fill[CelsiusScale](3){
			i += 1
			(i*i).at[CelsiusScale]
		}
		assert(arr.length == 3)
		assert(arr(0) == 1.0.at[CelsiusScale])
		assert(arr(1) == 4.0.at[CelsiusScale])
		assert(arr(2) == 9.0.at[CelsiusScale])
	}

	test("Uniform DoubleA arrays should work") {
		val arr = DoubleAArray.fillUniform[CelsiusScale](3)(9.0.at)
		assert(arr.length == 3)
		assert(arr(0) == 9.0.at[CelsiusScale])
		assert(arr(1) == 9.0.at[CelsiusScale])
		assert(arr(2) == 9.0.at[CelsiusScale])
	}

	test("Copying DoubleA arrays should work") {
		val src = DoubleAArray.at[CelsiusScale](11, 22, 33)
		var dest = new DoubleAArray[CelsiusScale](2)
		DoubleAArray.copy(src, 1, dest, 0, 2)
		assert(dest(0) == 22.at[CelsiusScale])
		assert(dest(1) == 33.at[CelsiusScale])
	}

	test("Copying DoubleU arrays should work") {
		val src = DoubleUArray.of[metre](11, 22, 33)
		var dest = new DoubleUArray[metre](2)
		DoubleUArray.copy(src, 1, dest, 0, 2)
		assert(dest(0) == 22.of[metre])
		assert(dest(1) == 33.of[metre])
	}

	test("Copying Vector2U arrays should work") {
		val src = Vector2UArray.of[metre]((11,111), (22,222), (33,333))
		var dest = new Vector2UArray[metre](2)
		Vector2UArray.copy(src, 1, dest, 0, 2)
		assert(dest.x(0) == 22.of[metre])
		assert(dest.x(1) == 33.of[metre])
		assert(dest.y(0) == 222.of[metre])
		assert(dest.y(1) == 333.of[metre])
	}

	test("Copying Vector3U arrays should work") {
		val src = Vector3UArray.of[metre]((11,111,1111), (22,222,2222), (33,333,3333))
		var dest = new Vector3UArray[metre](2)
		Vector3UArray.copy(src, 1, dest, 0, 2)
		assert(dest.x(0) == 22.of[metre])
		assert(dest.x(1) == 33.of[metre])
		assert(dest.y(0) == 222.of[metre])
		assert(dest.y(1) == 333.of[metre])
		assert(dest.z(0) == 2222.of[metre])
		assert(dest.z(1) == 3333.of[metre])
	}
	test("Copying Vector2A arrays should work") {
		val src = Vector2AArray.at[CelsiusScale]((11,111), (22,222), (33,333))
		var dest = new Vector2AArray[CelsiusScale](2)
		Vector2AArray.copy(src, 1, dest, 0, 2)
		assert(dest.x(0) == 22.at[CelsiusScale])
		assert(dest.x(1) == 33.at[CelsiusScale])
		assert(dest.y(0) == 222.at[CelsiusScale])
		assert(dest.y(1) == 333.at[CelsiusScale])
	}

	test("Copying Vector3A arrays should work") {
		val src = Vector3AArray.at[CelsiusScale]((11,111,1111), (22,222,2222), (33,333,3333))
		var dest = new Vector3AArray[CelsiusScale](2)
		Vector3AArray.copy(src, 1, dest, 0, 2)
		assert(dest.x(0) == 22.at[CelsiusScale])
		assert(dest.x(1) == 33.at[CelsiusScale])
		assert(dest.y(0) == 222.at[CelsiusScale])
		assert(dest.y(1) == 333.at[CelsiusScale])
		assert(dest.z(0) == 2222.at[CelsiusScale])
		assert(dest.z(1) == 3333.at[CelsiusScale])
	}

}