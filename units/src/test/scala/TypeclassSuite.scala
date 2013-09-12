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

class TypeclassSuite extends FunSuite {

	test("Lists of IntA should be sorted correctly."){
		val a = List(2.at[CelsiusScale], 4.at[CelsiusScale], 1.at[CelsiusScale])
		assert(a.sorted === List(1.at[CelsiusScale], 2.at[CelsiusScale], 4.at[CelsiusScale]))
	}


	test("Lists of DoubleA should be sorted correctly."){
		val a = List(2.0.at[CelsiusScale], 4.0.at[CelsiusScale], 1.0.at[CelsiusScale])
		assert(a.sorted === List(1.0.at[CelsiusScale], 2.0.at[CelsiusScale], 4.0.at[CelsiusScale]))
	}

	test("Lists of IntU should be sorted correctly."){
		val a = List(2.of[metre], 4.of[metre], 1.of[metre])
		assert(a.sorted === List(1.of[metre], 2.of[metre], 4.of[metre]))
	}

	test("Lists of DoubleU should be sorted correctly."){
		val a = List(2.0.of[metre], 4.0.of[metre], 1.0.of[metre])
		assert(a.sorted === List(1.0.of[metre], 2.0.of[metre], 4.0.of[metre]))
	}

}