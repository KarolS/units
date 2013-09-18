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

	type point = DefineUnit[_p~:_t]
	type pica = DefineUnit[_p~:_c]
	type inch = DefineUnit[_i~:_n]
	type foot = DefineUnit[_f~:_t]
	type yard = DefineUnit[_y~:_d]
	type mile = DefineUnit[_m~:_i]

	type teaspoon = DefineUnit[_t~:_s~:_p]
	type tablespoon = DefineUnit[_T~:_b~:_s~:_p]
	type fluid_ounce = DefineUnit[_f~:_l~:_o~:_z]
	type cup = DefineUnit[_c~:_u~:_p]
	type pint = DefineUnit[_p~:_i~:_n~:_t]
	type quart = DefineUnit[_q~:_t]
	type gallon = DefineUnit[_g~:_a~:_l]
	type barrel = DefineUnit[_b~:_b~:_l]
	type oilBarrel = DefineUnit[_B~:_B~:_L]

	type ounce = DefineUnit[_o~:_z]
	type pound = DefineUnit[_l~:_b]

	implicit val implicit__pc_to_pt = one[pica].contains(12)[point]
	implicit val implicit__in_to_pc = one[inch].contains(12)[pica]
	implicit val implicit__ft_to_in = one[foot].contains(12)[inch]
	implicit val implicit__yd_to_ft = one[yard].contains(3)[foot]
	implicit val implicit__mi_to_yd = one[mile].contains(5280/3)[yard]
	implicit val implicit__in_to_pt = implicit__in_to_pc >> implicit__pc_to_pt
	implicit val implicit__ft_to_pc = implicit__ft_to_in >> implicit__in_to_pc
	implicit val implicit__ft_to_pt = implicit__ft_to_in >> implicit__in_to_pt
	implicit val implicit__yd_to_pt = implicit__yd_to_ft >> implicit__ft_to_pt
	implicit val implicit__yd_to_pc = implicit__yd_to_ft >> implicit__ft_to_pc
	implicit val implicit__yd_to_in = implicit__yd_to_ft >> implicit__ft_to_in
	implicit val implicit__mi_to_pt = implicit__mi_to_yd >> implicit__yd_to_pt
	implicit val implicit__mi_to_pc = implicit__mi_to_yd >> implicit__yd_to_pc
	implicit val implicit__mi_to_in = implicit__mi_to_yd >> implicit__yd_to_in
	implicit val implicit__mi_to_ft = implicit__mi_to_yd >> implicit__yd_to_ft

	implicit val implicit__in_to_um = one[inch].contains(25400)[micrometre]
	implicit val implicit__in_to_mm = one[inch].contains(25.4)[millimetre]
	implicit val implicit__in_to_cm = one[inch].contains(2.54)[centimetre]
	implicit val implicit__in_to_m  = one[inch].contains(0.0254)[metre]
	implicit val implicit__ft_to_um = one[foot].contains(304800)[micrometre]
	implicit val implicit__yd_to_um = one[yard].contains(914400)[micrometre]
	implicit val implicit__ft_to_mm = one[foot].contains(304.8)[millimetre]
	implicit val implicit__yd_to_mm = one[yard].contains(914.4)[millimetre]
	implicit val implicit__ft_to_cm = one[foot].contains(30.48)[centimetre]
	implicit val implicit__yd_to_cm = one[yard].contains(91.44)[centimetre]
	// implicit val implicit__ft_to_dm = one[foot].contains(3.048)[decimetre]
	// implicit val implicit__yd_to_dm = one[yard].contains(9.144)[decimetre]
	implicit val implicit__ft_to_m  = one[foot].contains(0.3048)[metre]
	implicit val implicit__yd_to_m  = one[yard].contains(0.9144)[metre]
	implicit val implicit__mi_to_mm = one[mile].contains(1609344)[millimetre]
	implicit val implicit__mi_to_cm = one[mile].contains(160934.4)[centimetre]
	// implicit val implicit__mi_to_dm = one[mile].contains(16093.44)[decimetre]
	implicit val implicit__mi_to_m  = one[mile].contains(1609.344)[metre]
	implicit val implicit__mi_to_km = one[mile].contains(1.609344)[kilometre]
	implicit val implicit__in3_to_cm3 = implicit__in_to_cm.pow3
	implicit val implicit__inps_to_cmps = implicit__in_to_cm.dividedBy[second]
	implicit val implicit__ftps_to_cmps = implicit__ft_to_cm.dividedBy[second]
	implicit val implicit__ydps_to_cmps = implicit__yd_to_cm.dividedBy[second]
	implicit val implicit__inps_to_mps  = implicit__in_to_m .dividedBy[second]
	implicit val implicit__ftps_to_mps  = implicit__ft_to_m .dividedBy[second]
	implicit val implicit__ydps_to_mps  = implicit__yd_to_m .dividedBy[second]
	implicit val implicit__mips_to_kmps = implicit__mi_to_km.dividedBy[second]
	implicit val implicit__miph_to_kmph = implicit__mi_to_km.dividedBy[hour]

	implicit val implicit__lb_to_oz  = one[pound].contains(16)[ounce]

	implicit val implicit__lb_to_kg  = one[pound].contains(0.45359237)[kilogram]
	implicit val implicit__lb_to_dag = implicit__lb_to_kg >> implicit__kg_to_dag
	implicit val implicit__lb_to_g   = implicit__lb_to_kg >> implicit__kg_to_g
	implicit val implicit__t_to_lb = implicit__t_to_kg >< implicit__lb_to_kg
	implicit val implicit__oz_to_g = implicit__lb_to_oz <> implicit__lb_to_g

	implicit val implicit__BBL_to_gal = one[oilBarrel].contains(42)[gallon]
	implicit val implicit__BBL_to_qt  = one[oilBarrel].contains(168)[quart]
	implicit val implicit__bbl_to_gal = one[barrel].contains(31.5)[gallon]
	implicit val implicit__bbl_to_qt  = one[barrel].contains(126)[quart]
	implicit val implicit__gal_to_qt = one[gallon].contains(4)[quart]
	implicit val implicit__gal_to_in3 = one[gallon].contains(231)[cube[inch]]
	implicit val implicit__qt_to_pint = one[quart].contains(2)[pint]
	implicit val implicit__pint_to_floz = one[pint].contains(16)[fluid_ounce]
	implicit val implicit__pint_to_cup = one[pint].contains(2)[cup]
	implicit val implicit__cup_to_floz = one[cup].contains(8)[fluid_ounce]
	implicit val implicit__floz_to_Tbsp = one[fluid_ounce].contains(2)[tablespoon]
	implicit val implicit__Tbsp_to_tsp = one[tablespoon].contains(3)[teaspoon]

	implicit val implicit__floz_to_tsp = implicit__floz_to_Tbsp >> implicit__Tbsp_to_tsp
	implicit val implicit__cup_to_tsp  = implicit__cup_to_floz  >> implicit__floz_to_tsp
	implicit val implicit__pint_to_tsp = implicit__pint_to_cup  >> implicit__cup_to_tsp
	implicit val implicit__qt_to_tsp   = implicit__qt_to_pint   >> implicit__pint_to_tsp
	implicit val implicit__gal_to_tsp  = implicit__gal_to_qt    >> implicit__qt_to_tsp
	implicit val implicit__bbl_to_tsp  = implicit__bbl_to_qt    >> implicit__qt_to_tsp
	implicit val implicit__BBL_to_tsp  = implicit__BBL_to_qt    >> implicit__qt_to_tsp
	implicit val implicit__cup_to_Tbsp  = implicit__cup_to_floz  >> implicit__floz_to_Tbsp
	implicit val implicit__pint_to_Tbsp = implicit__pint_to_cup  >> implicit__cup_to_Tbsp
	implicit val implicit__qt_to_Tbsp   = implicit__qt_to_pint   >> implicit__pint_to_Tbsp
	implicit val implicit__gal_to_Tbsp  = implicit__gal_to_qt    >> implicit__qt_to_Tbsp
	implicit val implicit__bbl_to_Tbsp  = implicit__bbl_to_qt    >> implicit__qt_to_Tbsp
	implicit val implicit__BBL_to_Tbsp  = implicit__BBL_to_qt    >> implicit__qt_to_Tbsp
	implicit val implicit__qt_to_floz   = implicit__qt_to_pint   >> implicit__pint_to_floz
	implicit val implicit__gal_to_floz  = implicit__gal_to_qt    >> implicit__qt_to_floz
	implicit val implicit__bbl_to_floz  = implicit__bbl_to_qt    >> implicit__qt_to_floz
	implicit val implicit__BBL_to_floz  = implicit__BBL_to_qt    >> implicit__qt_to_floz
	implicit val implicit__qt_to_cup  = implicit__qt_to_pint   >> implicit__pint_to_cup
	implicit val implicit__gal_to_cup = implicit__gal_to_qt    >> implicit__qt_to_cup
	implicit val implicit__bbl_to_cup = implicit__bbl_to_qt    >> implicit__qt_to_cup
	implicit val implicit__BBL_to_cup = implicit__BBL_to_qt    >> implicit__qt_to_cup
	implicit val implicit__gal_to_pint = implicit__gal_to_qt    >> implicit__qt_to_pint
	implicit val implicit__bbl_to_pint = implicit__bbl_to_qt    >> implicit__qt_to_pint
	implicit val implicit__BBL_to_pint = implicit__BBL_to_qt    >> implicit__qt_to_pint

	implicit val implicit__BBL_to_in3  = implicit__BBL_to_gal  >> implicit__gal_to_in3
	implicit val implicit__bbl_to_in3  = implicit__bbl_to_gal  >> implicit__gal_to_in3
	implicit val implicit__qt_to_in3   = implicit__gal_to_qt   <> implicit__gal_to_in3
	implicit val implicit__pint_to_in3 = implicit__gal_to_pint <> implicit__gal_to_in3
	implicit val implicit__cup_to_in3  = implicit__gal_to_floz <> implicit__gal_to_in3
	implicit val implicit__floz_to_in3 = implicit__gal_to_floz <> implicit__gal_to_in3
	implicit val implicit__tbsp_to_in3 = implicit__gal_to_Tbsp <> implicit__gal_to_in3
	implicit val implicit__tsp_to_in3  = implicit__gal_to_tsp  <> implicit__gal_to_in3

	implicit val implicit__tsp_to_cm3  = one[gallon].contains(4.92892159375)[cube[centimetre]]
	implicit val implicit__tbsp_to_cm3 = one[gallon].contains(14.78676478125)[cube[centimetre]]
	implicit val implicit__floz_to_cm3 = one[gallon].contains(29.5735295625)[cube[centimetre]]
	implicit val implicit__cup_to_cm3  = one[gallon].contains(236.5882365)[cube[centimetre]]
	implicit val implicit__pint_to_cm3 = one[gallon].contains(473.176473)[cube[centimetre]]
	implicit val implicit__qt_to_cm3   = one[gallon].contains(946.352946)[cube[centimetre]]
	implicit val implicit__gal_to_cm3  = one[gallon].contains(3785.411784)[cube[centimetre]]
	implicit val implicit__tsp_to_ml  = one[gallon].contains(4.92892159375)[millilitre]
	implicit val implicit__tbsp_to_ml = one[gallon].contains(14.78676478125)[millilitre]
	implicit val implicit__floz_to_ml = one[gallon].contains(29.5735295625)[millilitre]
	implicit val implicit__cup_to_ml  = one[gallon].contains(236.5882365)[millilitre]
	implicit val implicit__pint_to_ml = one[gallon].contains(473.176473)[millilitre]
	implicit val implicit__qt_to_ml   = one[gallon].contains(946.352946)[millilitre]
	implicit val implicit__gal_to_ml  = one[gallon].contains(3785.411784)[millilitre]
	implicit val implicit__tsp_to_cl  = one[gallon].contains(0.492892159375)[centilitre]
	implicit val implicit__tbsp_to_cl = one[gallon].contains(1.478676478125)[centilitre]
	implicit val implicit__floz_to_cl = one[gallon].contains(2.95735295625)[centilitre]
	implicit val implicit__cup_to_cl  = one[gallon].contains(23.65882365)[centilitre]
	implicit val implicit__pint_to_cl = one[gallon].contains(47.3176473)[centilitre]
	implicit val implicit__qt_to_cl   = one[gallon].contains(94.6352946)[centilitre]
	implicit val implicit__gal_to_cl  = one[gallon].contains(378.5411784)[centilitre]
	implicit val implicit__tsp_to_l  = one[gallon].contains(0.00492892159375)[litre]
	implicit val implicit__tbsp_to_l = one[gallon].contains(0.01478676478125)[litre]
	implicit val implicit__floz_to_l = one[gallon].contains(0.0295735295625)[litre]
	implicit val implicit__cup_to_l  = one[gallon].contains(0.2365882365)[litre]
	implicit val implicit__pint_to_l = one[gallon].contains(0.473176473)[litre]
	implicit val implicit__qt_to_l   = one[gallon].contains(0.946352946)[litre]
	implicit val implicit__gal_to_l  = one[gallon].contains(3.785411784)[litre]
	implicit val implicit__bbl_to_l  = one[barrel].contains(119.240471196)[litre]
	implicit val implicit__BBL_to_l  = one[oilBarrel].contains(158.987294928)[litre]
	implicit val implicit__bbl_to_hl  = one[barrel].contains(1.19240471196)[hectolitre]
	implicit val implicit__BBL_to_hl  = one[oilBarrel].contains(1.58987294928)[hectolitre]
	implicit val implicit__bbl_to_m3  = one[barrel].contains(0.119240471196)[cube[metre]]
	implicit val implicit__BBL_to_m3  = one[oilBarrel].contains(0.158987294928)[cube[metre]]

	type fahrenheit_deg = DefineUnit[_deg~:_F]
	implicit val implicit__degC_to_degF = one[celsius_deg].contains(1.8)[fahrenheit_deg]

	sealed trait FahrenheitZero
	type FahrenheitScale = DefineAffineSpace[FahrenheitZero, fahrenheit_deg]

		
	implicit val implicit__fromFahrenheitToCelsius = 
		new DoubleATranslationScaling[FahrenheitScale, CelsiusScale](
			-32.of[fahrenheit_deg]
		)

}