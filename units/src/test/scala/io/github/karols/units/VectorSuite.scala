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

class VectorSuite extends FunSuite {

	test("Dot product and norms for 3D vectors should work correctly") {
		val v1 = (1,1,1).of[metre]
		val v1absSq: DoubleU[square[metre]] = v1.absSq
		assert(3.of[square[metre]] == v1absSq)
		val v2 = (1,2,2).of[second]
		val v2abs: DoubleU[second] = v2.abs
		assert((3.of[second] - v2abs) < 1.nano[second])
		assert((5.of[metre×second] - v1*v2) < 1.nano[metre×second])
	}

	test("Dot product and norms for 2D vectors should work correctly") {
		val v1 = (1,1).of[metre]
		val v1absSq: DoubleU[square[metre]] = v1.absSq
		assert(2.of[square[metre]] == v1.absSq)
		val v2 = (3,4).of[second]
		val v2abs: DoubleU[second] = v2.abs
		assert((5.of[second] - v2.abs) < 1.nano[second])
		assert((7.of[metre×second] - v1*v2) < 1.nano[metre×second])
	}

	test("Vector cross product should work correctly"){
		assert(Vector3U.z[metre] == Vector3U.x[metre] *** Vector3U.y[metre])
	}

  test("Vectors arrays should sum") {
    assert(
      Vector3U(3.of[metre], 2.of[metre], 2.of[metre]) ===
        Vector3UArray(
          Vector3U(1.of[metre], 1.of[metre], 1.of[metre]),
          Vector3U(2.of[metre], 1.of[metre], 1.of[metre])
        ).sum)
    assert(
      Vector2U(3.of[metre], 2.of[metre]) ===
        Vector2UArray(
          Vector2U(1.of[metre], 1.of[metre]),
          Vector2U(2.of[metre], 1.of[metre])
        ).sum)
  }

  test("Vectors should average") {
    assert(
      Vector2A(4.at[CelsiusScale], 3.at[CelsiusScale]) ===
        Vector2AArray(
          Vector2A(5.at[CelsiusScale], 4.at[CelsiusScale]),
          Vector2A(3.at[CelsiusScale], 2.at[CelsiusScale])
        ).avg)
    assert(
      Vector3A(4.at[CelsiusScale], 3.at[CelsiusScale], 3.at[CelsiusScale]) ===
        Vector3AArray(
          Vector3A(5.at[CelsiusScale], 4.at[CelsiusScale], 4.at[CelsiusScale]),
          Vector3A(3.at[CelsiusScale], 2.at[CelsiusScale], 2.at[CelsiusScale])
        ).avg)
  }

}