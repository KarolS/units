/*
Copyright (c) 2013-2016 Karol M. Stasiak

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

/**
	US customary and British units and their conversions to SI.
*/
object USCustomary {
	import io.github.karols.units.SI._
	import io.github.karols.units._
	import io.github.karols.units.defining._

	type thou = DefineUnit[_t~:_h]
	type point = DefineUnit[_p~:_t]
	type pica = DefineUnit[_p~:_c]
	type inch = DefineUnit[_i~:_n]
	type foot = DefineUnit[_f~:_t]
	type yard = DefineUnit[_y~:_d]
	type mile = DefineUnit[_m~:_i]

	type acre = DefineUnit[_a~:_c]

	type teaspoon = DefineUnit[_t~:_s~:_p]
	type tablespoon = DefineUnit[_T~:_b~:_s~:_p]
	type fluid_ounce = DefineUnit[_f~:_l~:_o~:_z]
	type cup = DefineUnit[_c~:_u~:_p]
	type pint = DefineUnit[_p~:_i~:_n~:_t]
	type quart = DefineUnit[_q~:_t]
	type gallon = DefineUnit[_g~:_a~:_l]
	type barrel = DefineUnit[_b~:_b~:_l]
	type oilBarrel = DefineUnit[_B~:_B~:_L]

	type imperial_fluid_ounce = DefineUnit[_f~:_l~:_o~:_z~:_U~:_K]
	type imperial_gill = DefineUnit[_g~:_i~:_l~:_l~:_U~:_K]
	type imperial_pint = DefineUnit[_p~:_i~:_n~:_t~:_U~:_K]
	type imperial_quart = DefineUnit[_q~:_t~:_U~:_K]
	type imperial_gallon = DefineUnit[_g~:_a~:_l~:_U~:_K]

	type dram   = DefineUnit[_d~:_r]
	type drachm = DefineUnit[_d~:_r]
	type ounce = DefineUnit[_o~:_z]
	type pound = DefineUnit[_l~:_b]
	type stone = DefineUnit[_s~:_t]
	type short_hundredweight = DefineUnit[_c~:_w~:_t]
	type long_hundredweight  = DefineUnit[_c~:_w~:_t~:_U~:_K]
	type short_ton = DefineUnit[_t~:_o~:_n]
	type long_ton  = DefineUnit[_t~:_o~:_n~:_U~:_K]

	implicit val implicit__in_to_th = one[inch].contains(1000)[thou]
	implicit val implicit__pc_to_pt = one[pica].contains(12)[point]
	implicit val implicit__in_to_pc = one[inch].contains(12)[pica]
	implicit val implicit__ft_to_in = one[foot].contains(12)[inch]
	implicit val implicit__yd_to_ft = one[yard].contains(3)[foot]
	implicit val implicit__mi_to_yd = one[mile].contains(5280/3)[yard]
	implicit val implicit__pc_to_th = one[pica].contains(1000.0/12)[thou]
	implicit val implicit__pt_to_th = one[point].contains(1000.0/144)[thou]
	implicit val implicit__in_to_pt = implicit__in_to_pc >> implicit__pc_to_pt
	implicit val implicit__ft_to_pc = implicit__ft_to_in >> implicit__in_to_pc
	implicit val implicit__ft_to_pt = implicit__ft_to_in >> implicit__in_to_pt
	implicit val implicit__ft_to_th = implicit__ft_to_in >> implicit__in_to_th
	implicit val implicit__yd_to_th = implicit__yd_to_ft >> implicit__ft_to_th
	implicit val implicit__yd_to_pt = implicit__yd_to_ft >> implicit__ft_to_pt
	implicit val implicit__yd_to_pc = implicit__yd_to_ft >> implicit__ft_to_pc
	implicit val implicit__yd_to_in = implicit__yd_to_ft >> implicit__ft_to_in
	implicit val implicit__mi_to_th = implicit__mi_to_yd >> implicit__yd_to_th
	implicit val implicit__mi_to_pt = implicit__mi_to_yd >> implicit__yd_to_pt
	implicit val implicit__mi_to_pc = implicit__mi_to_yd >> implicit__yd_to_pc
	implicit val implicit__mi_to_in = implicit__mi_to_yd >> implicit__yd_to_in
	implicit val implicit__mi_to_ft = implicit__mi_to_yd >> implicit__yd_to_ft

	implicit val implicit__th_to_nm = one[thou].contains(25400)[nanometre]
	implicit val implicit__th_to_um = one[thou].contains(25.4)[micrometre]
	implicit val implicit__th_to_mm = one[thou].contains(0.025)[millimetre]
	implicit val implicit__th_to_cm = one[thou].contains(0.00254)[centimetre]
	implicit val implicit__th_to_m  = one[thou].contains(0.0000254)[metre]
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

	implicit val implicit_acre_to_mm2 = one[acre].contains(4046856422.4)[square[millimetre]]
	implicit val implicit_acre_to_cm2 = one[acre].contains(40468564.224)[square[centimetre]]
	implicit val implicit_acre_to_m2  = one[acre].contains(4046.8564224)[square[metre]]
	implicit val implicit_acre_to_a   = one[acre].contains(40.468564224)[are]
	implicit val implicit_acre_to_ha  = one[acre].contains(0.40468564224)[hectare]
	implicit val implicit_acre_to_in2 = one[acre].contains(43560*144)[square[foot]]
	implicit val implicit_acre_to_ft2 = one[acre].contains(43560)[square[foot]]
	implicit val implicit_acre_to_yd2 = one[acre].contains(4840)[square[yard]]
	implicit val implicit_mi2_to_acre = one[square[mile]].contains(640)[acre]

	implicit val implicit__oz_to_dr  = one[ounce].contains(16)[dram]
	implicit val implicit__lb_to_oz  = one[pound].contains(16)[ounce]
	implicit val implicit__lb_to_dr  = one[pound].contains(256)[dram]
	implicit val implicit__st_to_lb  = one[stone].contains(14)[pound]
	implicit val implicit__st_to_oz  = implicit__st_to_lb >> implicit__lb_to_oz
	implicit val implicit__st_to_dr  = implicit__st_to_lb >> implicit__lb_to_dr

	implicit val implicit__cwt_to_st = one[short_hundredweight].contains(100.0/14)[stone]
	implicit val implicit__cwt_to_lb = one[short_hundredweight].contains(100)[pound]
	implicit val implicit__cwt_to_oz = implicit__cwt_to_lb >> implicit__lb_to_oz
	implicit val implicit__cwt_to_dr = implicit__cwt_to_lb >> implicit__lb_to_oz
	implicit val implicit__ton_to_cwt= one[short_ton].contains(20)[short_hundredweight]
	implicit val implicit__ton_to_st = one[short_ton].contains(2000.0/14)[stone]
	implicit val implicit__ton_to_lb = one[short_ton].contains(2000)[pound]
	implicit val implicit__ton_to_oz = implicit__ton_to_lb >> implicit__lb_to_oz
	implicit val implicit__ton_to_dr = implicit__ton_to_lb >> implicit__lb_to_dr

	implicit val implicit__cwt_to_st_UK = one[long_hundredweight].contains(8)[stone]
	implicit val implicit__cwt_to_lb_UK = one[long_hundredweight].contains(112)[pound]
	implicit val implicit__cwt_to_oz_UK = implicit__cwt_to_lb_UK >> implicit__lb_to_oz
	implicit val implicit__cwt_to_dr_UK = implicit__cwt_to_lb_UK >> implicit__lb_to_oz
	implicit val implicit__ton_to_cwt_UK= one[long_ton].contains(20)[long_hundredweight]
	implicit val implicit__ton_to_st_UK = one[long_ton].contains(2000.0/14)[stone]
	implicit val implicit__ton_to_lb_UK = one[long_ton].contains(2000)[pound]
	implicit val implicit__ton_to_oz_UK = implicit__ton_to_lb_UK >> implicit__lb_to_oz
	implicit val implicit__ton_to_dr_UK = implicit__ton_to_lb_UK >> implicit__lb_to_dr

	implicit val implicit__lb_to_kg  = one[pound].contains(0.45359237)[kilogram]
	implicit val implicit__lb_to_dag = implicit__lb_to_kg >> implicit__kg_to_dag
	implicit val implicit__lb_to_g   = implicit__lb_to_kg >> implicit__kg_to_g
	implicit val implicit__st_to_kg  = implicit__st_to_lb >> implicit__lb_to_kg
	implicit val implicit__st_to_dag = implicit__st_to_kg >> implicit__kg_to_dag
	implicit val implicit__st_to_g   = implicit__st_to_kg >> implicit__kg_to_g
	implicit val implicit__cwt_to_kg  = implicit__cwt_to_lb >> implicit__lb_to_kg
	implicit val implicit__cwt_to_dag = implicit__cwt_to_kg >> implicit__kg_to_dag
	implicit val implicit__cwt_to_g   = implicit__cwt_to_kg >> implicit__kg_to_g
	implicit val implicit__cwt_to_t   = implicit__cwt_to_kg >< implicit__t_to_kg
	implicit val implicit__ton_to_kg  = implicit__ton_to_lb >> implicit__lb_to_kg
	implicit val implicit__ton_to_dag = implicit__ton_to_kg >> implicit__kg_to_dag
	implicit val implicit__ton_to_g   = implicit__ton_to_kg >> implicit__kg_to_g
	implicit val implicit__ton_to_t   = implicit__ton_to_kg >< implicit__t_to_kg
	implicit val implicit__cwt_to_kg_UK  = implicit__cwt_to_lb_UK >> implicit__lb_to_kg
	implicit val implicit__cwt_to_dag_UK = implicit__cwt_to_kg_UK >> implicit__kg_to_dag
	implicit val implicit__cwt_to_g_UK   = implicit__cwt_to_kg_UK >> implicit__kg_to_g
	implicit val implicit__cwt_to_t_UK   = implicit__cwt_to_kg_UK >< implicit__t_to_kg
	implicit val implicit__ton_to_kg_UK  = implicit__ton_to_lb_UK >> implicit__lb_to_kg
	implicit val implicit__ton_to_dag_UK = implicit__ton_to_kg_UK >> implicit__kg_to_dag
	implicit val implicit__ton_to_g_UK   = implicit__ton_to_kg_UK >> implicit__kg_to_g
	implicit val implicit__ton_to_t_UK   = implicit__ton_to_kg_UK >< implicit__t_to_kg

	implicit val implicit__t_to_lb   = implicit__t_to_kg  >< implicit__lb_to_kg
	implicit val implicit__oz_to_kg  = implicit__lb_to_oz <> implicit__lb_to_kg
	implicit val implicit__oz_to_dag = implicit__lb_to_oz <> implicit__lb_to_dag
	implicit val implicit__oz_to_g   = implicit__lb_to_oz <> implicit__lb_to_g
	implicit val implicit__oz_to_mg  = implicit__oz_to_g  >> implicit__g_to_mg
	implicit val implicit__dr_to_kg  = implicit__lb_to_dr <> implicit__lb_to_kg
	implicit val implicit__dr_to_dag = implicit__lb_to_dr <> implicit__lb_to_dag
	implicit val implicit__dr_to_g   = implicit__lb_to_dr <> implicit__lb_to_g
	implicit val implicit__dr_to_mg  = implicit__dr_to_g  >> implicit__g_to_mg

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

	implicit val implicit__gal_to_qt_UK    = one[imperial_gallon].contains(4)[imperial_quart]
	implicit val implicit__gal_to_pt_UK    = one[imperial_gallon].contains(8)[imperial_pint]
	implicit val implicit__gal_to_gill_UK  = one[imperial_gallon].contains(32)[imperial_gill]
	implicit val implicit__gal_to_floz_UK  = one[imperial_gallon].contains(160)[imperial_fluid_ounce]
	implicit val implicit__qt_to_pt_UK     = one[imperial_quart] .contains(2)[imperial_pint]
	implicit val implicit__qt_to_gill_UK   = one[imperial_quart] .contains(8)[imperial_gill]
	implicit val implicit__qt_to_floz_UK   = one[imperial_quart] .contains(40)[imperial_fluid_ounce]
	implicit val implicit__pt_to_gill_UK   = one[imperial_pint]  .contains(4)[imperial_gill]
	implicit val implicit__pt_to_floz_UK   = one[imperial_pint]  .contains(20)[imperial_fluid_ounce]
	implicit val implicit__gill_to_floz_UK = one[imperial_gill]  .contains(5)[imperial_fluid_ounce]

	implicit val implicit_gal_to_l_UK  = one[imperial_gallon].contains(4.54609)[litre]
	implicit val implicit_gal_to_cl_UK = one[imperial_gallon].contains(454.609)[centilitre]
	implicit val implicit_gal_to_ml_UK = one[imperial_gallon].contains(4546.09)[millilitre]
	implicit val implicit_qt_to_l_UK  = one[imperial_quart].contains(1.1365225)[litre]
	implicit val implicit_qt_to_cl_UK = one[imperial_quart].contains(113.65225)[centilitre]
	implicit val implicit_qt_to_ml_UK = one[imperial_quart].contains(1136.5225)[millilitre]
	implicit val implicit_pt_to_l_UK  = one[imperial_pint].contains(0.56826125)[litre]
	implicit val implicit_pt_to_cl_UK = one[imperial_pint].contains( 56.826125)[centilitre]
	implicit val implicit_pt_to_ml_UK = one[imperial_pint].contains( 568.26125)[millilitre]
	implicit val implicit_gill_to_l_UK  = one[imperial_gill].contains(0.1420653125)[litre]
	implicit val implicit_gill_to_cl_UK = one[imperial_gill].contains( 14.20653125)[centilitre]
	implicit val implicit_gill_to_ml_UK = one[imperial_gill].contains( 142.0653125)[millilitre]
	implicit val implicit_floz_to_l_UK  = one[imperial_fluid_ounce].contains(0.0284130625)[litre]
	implicit val implicit_floz_to_cl_UK = one[imperial_fluid_ounce].contains(  2.84130625)[centilitre]
	implicit val implicit_floz_to_ml_UK = one[imperial_fluid_ounce].contains(  28.4130625)[millilitre]

	type fahrenheit_deg = DefineUnit[_deg~:_F]
	implicit val implicit__degC_to_degF = one[celsius_deg].contains(1.8)[fahrenheit_deg]

	sealed trait FahrenheitZero
	type FahrenheitScale = DefineAffineSpace[FahrenheitZero, fahrenheit_deg]


	implicit val implicit__fromFahrenheitToCelsius =
		new DoubleATranslationScaling[FahrenheitScale, CelsiusScale](
			-32.of[fahrenheit_deg]
		)

}