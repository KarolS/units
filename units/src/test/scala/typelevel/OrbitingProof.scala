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

package io.github.karols.units.typelevel

import io.github.karols.units._
import io.github.karols.units.defining._

// This trait has only to compile
sealed trait OrbitingProof {

	//astronomical unit
	type AU = DefineUnit[_A~:_U]
	//year
	type year = DefineUnit[_y~:_r]
	//some undefined mass unit
	type M = DefineUnit[_M]

	val M = 1.of[M]

	def a = (G * M / (sun-earth).lengthSq) * (sun-earth).unit

	val G = (2*3.141592).pow2.of[cube[AU]/(M×square[year])]

	// G M / r^2 = v^2 / r
	// G = v^2 r / M

	def advanceTime(t: DoubleU[year]) {
		earth = earth + v*t
		v = v + a*t
	}

	var sun = (0,0,0).of[AU]
	var earth = (1,0,0).of[AU]
	var v = Vector3U.y[_1] * (G * M / 1.of[AU]).sqrt
}