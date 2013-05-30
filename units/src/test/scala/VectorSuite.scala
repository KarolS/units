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

import org.scalatest.FunSuite
import defining._
import SI._
import USCustomary._
import arrays._

class VectorSuite extends FunSuite {
	
	test("Dot product and norms for 3D vectors should work correctly") {
		val v1 = (1,1,1).of[metre]
		assert(3.of[square[metre]] == v1.absSq)
		val v2 = (1,2,2).of[second]
		assert((3.of[second] - v2.abs) < 1.nano[second])
		assert((5.of[metre×second] - v1*v2) < 1.nano[metre×second])
	}

	test("Dot product and norms for 2D vectors should work correctly") {
		val v1 = (1,1).of[metre]
		assert(2.of[square[metre]] == v1.absSq)
		val v2 = (3,4).of[second]
		assert((5.of[second] - v2.abs) < 1.nano[second])
		assert((7.of[metre×second] - v1*v2) < 1.nano[metre×second])
	}
	
	test("Vector cross product should work correctly"){
		assert(Vector3U.z[metre] == Vector3U.x[metre] *** Vector3U.y[metre])
	}
	
}