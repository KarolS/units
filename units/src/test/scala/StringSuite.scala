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
import io.github.karols.units.internal.Strings
import io.github.karols.units._
import defining._

class StringSuite extends FunSuite {

	test("One-character typelevel strings should work") {
		assert(Strings[_A] === "A")
		assert(Strings[_B] === "B")
		assert(Strings[_C] === "C")
		assert(Strings[_D] === "D")
		assert(Strings[_E] === "E")
		assert(Strings[_F] === "F")
		assert(Strings[_G] === "G")
		assert(Strings[_H] === "H")
		assert(Strings[_I] === "I")
		assert(Strings[_J] === "J")
		assert(Strings[_K] === "K")
		assert(Strings[_L] === "L")
		assert(Strings[_M] === "M")
		assert(Strings[_N] === "N")
		assert(Strings[_O] === "O")
		assert(Strings[_P] === "P")
		assert(Strings[_Q] === "Q")
		assert(Strings[_R] === "R")
		assert(Strings[_S] === "S")
		assert(Strings[_T] === "T")
		assert(Strings[_U] === "U")
		assert(Strings[_V] === "V")
		assert(Strings[_W] === "W")
		assert(Strings[_X] === "X")
		assert(Strings[_Y] === "Y")
		assert(Strings[_Z] === "Z")

		assert(Strings[_OMEGA] === "Ω")
		assert(Strings[_at] === "@")
		assert(Strings[_mu] === "µ")
		assert(Strings[_AA] === "Å")
		assert(Strings[_deg] === "°")
		assert(Strings[_POUND] === "£")
		assert(Strings[_DOLLAR] === "$")
		assert(Strings[_EURO] === "€")
		assert(Strings[_YEN] === "¥")
		assert(Strings[_l_] === "ł")
		assert(Strings[_min] === "’")
		assert(Strings[_sec] === "”")
		assert(Strings[_percent] === "%")
		assert(Strings[_permille] === "‰")

		assert(Strings[_a] === "a")
		assert(Strings[_b] === "b")
		assert(Strings[_c] === "c")
		assert(Strings[_d] === "d")
		assert(Strings[_e] === "e")
		assert(Strings[_f] === "f")
		assert(Strings[_g] === "g")
		assert(Strings[_h] === "h")
		assert(Strings[_i] === "i")
		assert(Strings[_j] === "j")
		assert(Strings[_k] === "k")
		assert(Strings[_l] === "l")
		assert(Strings[_m] === "m")
		assert(Strings[_n] === "n")
		assert(Strings[_o] === "o")
		assert(Strings[_p] === "p")
		assert(Strings[_q] === "q")
		assert(Strings[_r] === "r")
		assert(Strings[_s] === "s")
		assert(Strings[_t] === "t")
		assert(Strings[_u] === "u")
		assert(Strings[_v] === "v")
		assert(Strings[_w] === "w")
		assert(Strings[_x] === "x")
		assert(Strings[_y] === "y")
		assert(Strings[_z] === "z")
	}

	test("Long typelevel strings should work") {
		assert(Strings[
			_Q~:_u~:_i~:_c~:_k
			~:_B~:_r~:_o~:_w~:_n
			~:_F~:_o~:_x
			~:_J~:_u~:_m~:_p~:_e~:_d
			~:_O~:_v~:_e~:_r
			~:_T~:_h~:_e
			~:_L~:_a~:_z~:_y
			~:_D~:_o~:_g]
			=== "QuickBrownFoxJumpedOverTheLazyDog")
	}
}