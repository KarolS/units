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
package io.github.karols.units_tests

import org.scalatest.FunSuite
import io.github.karols.units._
import defining._
import SI._
import USCustomary._

class QuickShowcaseSuite extends FunSuite {

	test("Quick showcase from README.md should work") {
		type USD = DefineUnit[_U~:_S~:_D]
		type EUR = DefineUnit[_E~:_U~:_R]

		implicit val EUR_to_USD = one[EUR].contains(1.25)[USD]

		val priceInUSA     =  200.of[USD/square[foot]]
		val priceInGermany = 1500.of[EUR/square[metre]]

		val area: IntU[square[centimetre]] = 200.of[centimetre] * 550.of[centimetre]

		val costInUSA:     DoubleU[USD] = priceInUSA     * area.convert[foot × foot]
		val costInGermany: DoubleU[EUR] = priceInGermany * area.convert[metre × metre]

		assert(null ne s"You can buy tiles in Germany for ${costInGermany.mkString}.")
		assert(null ne s"You can buy tiles in USA for ${costInUSA.mkString}.")

		if(costInUSA >~ costInGermany) {
			assert(true)
		} else {
			assert(false)
		}
	}
}