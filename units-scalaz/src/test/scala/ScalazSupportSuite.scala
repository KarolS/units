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

package io.github.karols.units

import org.scalatest.FunSuite
import io.github.karols.units.scalazSupport._
import SI._
import USCustomary._
import scalaz._
import scalaz.Scalaz._

class ScalazSupportSuite extends FunSuite {

	test("IntU is a monoid") {
		val l = 2.of[metre]
		assert(4.of[metre] == (l |+| l))
	}

	test("DoubleU is a monoid") {
		val l = 2.0.of[metre]
		assert(4.0.of[metre] == (l |+| l))
	}

	test("Vector3U is a monoid") {
		val l = (1,2,3).of[metre]
		assert((2,4,6).of[metre] == (l |+| l))
	}

	test("Vector2U is a monoid") {
		val l = (12,3).of[metre]
		assert((24,6).of[metre] == (l |+| l))
	}

}