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
package stasiak.karol.units.constants

import stasiak.karol.units._
import stasiak.karol.units.SI._
import stasiak.karol.units.SI.Short._

object Physical {

	val speedOfLight = 299792458L.of[m/s]
	val gravitation = 6.6738480e-11.of[cube[m]/(kg × square[s])]
	val planckConstant = 6.6260695729e-34.of[J×s]
	val reducedPlanckConstant = 1.05457172647e-34.of[J×s]
	val elementaryCharge = 1.60217656535e-19.of[C]
	val magneticConstant = 1.256637061e-6.of[N/square[A]]
	val electricConstant = 8.854187817e-12.of[F/m]
	val electronMass = 9.1093829140e-31.of[kg]
	val protonMass = 1.67262177774e-27.of[kg]
	val avogadrosNumber = 6.0221412927e23.of[_1/mol]

	object Short {
		val c = speedOfLight
		val G = gravitation
		val h = planckConstant
		val ħ = reducedPlanckConstant
		val e = elementaryCharge
		val µ0 = magneticConstant
		val ε0 = electricConstant
		val m_e = electronMass
		val m_p = protonMass
		val N_A = avogadrosNumber
	}

}