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
package stasiak.units.constants

import stasiak.units._
import stasiak.units.SI._
import stasiak.units.SI.Short._

/** Common constants used in physics. */
object Physical {

	/** Speed of light in the vacuum (c = 299792458 m/s) */
	val speedOfLight = 299792458L.of[m/s]

	/** Gravitation constant (G = 6.6738480·10^-11^ m^3^/(kg·s^2^)) */
	val gravitation = 6.6738480e-11.of[cube[m]/(kg × square[s])]

	/** Planck constant (h = 6.6260695729·10^-34^ J·s) */
	val planckConstant = 6.6260695729e-34.of[J×s]

	/** Reduced Planck constant (ħ = h/2π = 1.05457172647·10^-34^ J·s) */
	val reducedPlanckConstant = 1.05457172647e-34.of[J×s]

	/** Elementary charge (e = 1.60217656535·10^-19^ C) */
	val elementaryCharge = 1.60217656535e-19.of[C]

	/** Magnetic constant aka vacuum permeability (µ,,0,, = 1.256637061·10^-6^ N/A^2^) */
	val magneticConstant = 1.256637061e-6.of[N/square[A]]

	/** Electric constant aka vacuum permittivity (ε,,0,, = 8.854187817·10^-12^ F/m) */
	val electricConstant = 8.854187817e-12.of[F/m]

	/** Mass of an electron (m,,e,, = 9.1093829140·10^-31^ kg) */
	val electronMass = 9.1093829140e-31.of[kg]

	/** Mass of a proton (m,,p,, = 1.67262177774·10^-27^ kg) */
	val protonMass = 1.67262177774e-27.of[kg]

	/** Avogadro's number (N,,A,, = 6.0221412927·10^23^ 1/mol) */
	val avogadrosNumber = 6.0221412927e23.of[_1/mol]

	/** Short (one/two letter long) aliases for the constants. */
	object Short {
		/** Speed of light in the vacuum (c = 299792458 m/s) */
		val c = speedOfLight
		/** Gravitation constant (G = 6.6738480·10^-11^ m^3^/(kg·s^2^)) */
		val G = gravitation
		/** Planck constant (h = 6.6260695729·10^-34^ J·s) */
		val h = planckConstant
		/** Reduced Planck constant (ħ = h/2π = 1.05457172647·10^-34^ J·s) */
		val ħ = reducedPlanckConstant
		/** Elementary charge (e = 1.60217656535·10^-19^ C) */
		val e = elementaryCharge
		/** Magnetic constant aka vacuum permeability (µ,,0,, = 1.256637061·10^-6^ N/A^2^) */
		val µ0 = magneticConstant
		/** Electric constant aka vacuum permittivity (ε,,0,, = 8.854187817·10^-12^ F/m) */
		val ε0 = electricConstant
		/** Mass of an electron (m,,e,, = 9.1093829140·10^-31^ kg) */
		val m_e = electronMass
		/** Mass of a proton (m,,p,, = 1.67262177774·10^-27^ kg) */
		val m_p = protonMass
		/** Avogadro's number (N,,A,, = 6.0221412927·10^23^ 1/mol) */
		val N_A = avogadrosNumber
	}

}