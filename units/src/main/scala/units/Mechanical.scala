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
package stasiak.units

import defining._

/** Abstract definition of mechanical units, for use with explicit polymorphism. */
object Mechanical {

	type length = DefineUnit[_l~:_e~:_n~:_g~:_t~:_h]
	type time = DefineUnit[_t~:_i~:_m~:_e]
	type mass = DefineUnit[_m~:_a~:_s~:_s]

	/** ^ ^ = length² */
	type area = length×length
	/** ^ ^ = length³ */
	type volume = length×area

	/** ^ ^ = 1 / time */
	type frequency = _1/time

	/** ^ ^ = length / time */
	type velocity = length/time
	/** ^ ^ = length / time */
	type speed = length/time
	/** ^ ^ = length / time² */
	type acceleration = velocity/time
	/** ^ ^ = length / time³ */
	type jerk = acceleration/time
	/** ^ ^ = length / time⁴ */
	type jounce = jerk/time

	/** ^ ^ = mass / volume = mass / length³ */
	type density = mass/volume
	/** ^ ^ = mass × acceleration = mass × length / time² */
	type force = mass×acceleration
	/** ^ ^ = force × length = mass × length² / time² */
	type work = force×length
	/** ^ ^ = force × length = mass × length² / time² */
	type energy = work
	/** ^ ^ = work / time = mass × length² / time³ */
	type power = work/time
	/** ^ ^ = force / area = mass / (length × time²) */
	type pressure = force/area

	/** ^ ^ = mass × velocity = mass × length / time */
	type momentum = mass×velocity
	/** ^ ^ = angle / time */
	type angular_velocity = _1/time
	/** ^ ^ = mass × angular velocity = mass × angle / time */
	type angular_momentum = mass×angular_velocity
	/** ^ ^ = force × length = mass × length² / time² */
	type torque = force×length

}