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

class UnitNameSuite extends FunSuite {

	test("Units should get correct names") {
		assert(2.of[metre].mkString === "2 m")
		assert(2.of[newton_repr].mkString === "2 N")
	}

	test("Compound unit names should be correct") {
		assert(2.of[metre × second].mkString === "2 m s")
		assert(2.of[metre / second].mkString === "2 m s^(-1)")
		assert(2.of[second / metre].mkString === "2 m^(-1) s")
		assert(2.of[square[metre]].mkString === "2 m^2")
		assert(2.of[cube[metre]].mkString === "2 m^3")
	}

	test("Units should get correct names after representAll") {
		val string = 1.0.of[square[foot]].representAll[foot,inch].mkString
		assert("""144(\.0+)? in\^2""".r.findFirstIn(string).isDefined)
	}
}