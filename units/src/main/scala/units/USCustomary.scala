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

/** US customary units and their conversions to SI. */
object USCustomary {
	import stasiak.karol.units._
	import stasiak.karol.units.defining._
	import stasiak.karol.units.SI._

	type inch = DefineUnit[_i~:_n]
	type foot = DefineUnit[_f~:_t]
	type yard = DefineUnit[_y~:_d]
	type mile = DefineUnit[_m~:_i]

	type fluid_ounce = DefineUnit[_f~:_l~:_o~:_z]
	type pint = DefineUnit[_p~:_t]
	type quart = DefineUnit[_q~:_t]
	type gallon = DefineUnit[_g~:_a~:_l]

	type ounce = DefineUnit[_o~:_z]
	type pound = DefineUnit[_l~:_b]

	implicit val implicit__ft_to_in = one[foot].contains(12)[inch]
	implicit val implicit__yd_to_ft = one[yard].contains(3)[foot]
	implicit val implicit__mi_to_yd = one[mile].contains(5280/3)[yard]
	implicit val implicit__yd_to_in = implicit__yd_to_ft >> implicit__ft_to_in
	implicit val implicit__mi_to_in = implicit__mi_to_yd >> implicit__yd_to_in
	implicit val implicit__mi_to_ft = implicit__mi_to_yd >> implicit__yd_to_ft

	implicit val implicit__in_to_cm = one[inch].contains(2.54)[centimetre]
	implicit val implicit__in3_to_cm3 = implicit__in_to_cm * implicit__in_to_cm * implicit__in_to_cm
	implicit val implicit__ft_to_cm = implicit__ft_to_in >> implicit__in_to_cm
	implicit val implicit__ft_to_m = one[foot].contains(12*0.0254)[metre]
	implicit val implicit__mi_to_m = implicit__mi_to_ft >> implicit__ft_to_m

	implicit val implicit__lb_to_oz = one[pound].contains(16)[ounce]
	implicit val implicit__lb_to_kg = one[pound].contains(0.45359237)[kilogram]
	implicit val implicit__lb_to_g = implicit__lb_to_kg >> implicit__kg_to_g
	implicit val implicit__t_to_lb = implicit__t_to_kg >< implicit__lb_to_kg
	implicit val implicit__oz_to_g = implicit__lb_to_oz <> implicit__lb_to_g

	implicit val implicit__gal_to_qt = one[gallon].contains(4)[quart]
	implicit val implicit__gal_to_in3 = one[gallon].contains(231)[cube[inch]]
	implicit val implicit__qt_to_pt = one[quart].contains(2)[pint]
	implicit val implicit__pt_to_floz = one[pint].contains(16)[fluid_ounce]
	implicit val implicit__gal_to_pt   = implicit__gal_to_qt   >> implicit__qt_to_pt
	implicit val implicit__gal_to_floz = implicit__gal_to_pt   >> implicit__pt_to_floz
	implicit val implicit__qt_to_floz  = implicit__qt_to_pt    >> implicit__pt_to_floz
	implicit val implicit__qt_to_in3   = implicit__gal_to_qt   <> implicit__gal_to_in3
	implicit val implicit__pt_to_in3   = implicit__gal_to_pt   <> implicit__gal_to_in3
	implicit val implicit__floz_to_in3 = implicit__gal_to_floz <> implicit__gal_to_in3
	//TODO: conversion to SI volume units

	type fahrenheit_deg = DefineUnit[_deg~:_F]
	implicit val implicit__degC_to_degF = one[celsius_deg].contains(1.8)[fahrenheit_deg]

	sealed trait FahrenheitZero
	type FahrenheitScale = DefineAffineSpace[FahrenheitZero, fahrenheit_deg]

	implicit val fromCelsiusToFahrenheit = convertAffineSpace[CelsiusScale,FahrenheitScale]{ 
		x => x * (9/5.0) + 32 
	}
	implicit val fromFahrenheitToCelsius = convertAffineSpace[FahrenheitScale,CelsiusScale]{ 
		x => (x - 32) * (5/9.0)
	}

}