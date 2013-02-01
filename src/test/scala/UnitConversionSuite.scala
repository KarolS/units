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
import Units._
import DefiningUnits._
import units.SI._
import units.USCustomary._

class UnitConversionSuite extends FunSuite {
	
	test("Smaller units should be implicitly converted to bigger units") {
		assert(2.of[inch] + 1.of[foot] === 14.of[inch])
		assert(2.of[ounce] + 1.of[pound] === 18.of[ounce])
		assert(3.of[metre×metre] + 5.of[are] === 503.of[metre×metre])
	}

	test("Units should be correctly implicitly converted in comparisons") {
		assert(2.of[inch] >~ 5.of[centimetre])
		assert(3.of[foot] <~ 1.of[metre])
	}

	test("Units should be correctly explicitly converted in other powers") {
		assert(144.of[square[inch]].convert[square[foot]] == 1.0.of[square[foot]])
		assert(1728.of[cube[inch]].convert[cube[foot]] == 1.0.of[cube[foot]])

		assert(1.of[square[foot]].convert[square[inch]] == 144.0.of[square[inch]])
		assert(1.of[cube[foot]].convert[cube[inch]] == 1728.0.of[cube[inch]])
		
		assert(1.of[square[foot]].convertToInt[square[inch]] == 144.of[square[inch]])
		assert(1.of[cube[foot]].convertToInt[cube[inch]] == 1728.of[cube[inch]])
	}
}