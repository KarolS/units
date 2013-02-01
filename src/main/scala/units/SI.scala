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
package stasiak.karol.units.units

object SI {
	import stasiak.karol.units.Units._
	import stasiak.karol.units.DefiningUnits._

	type metre = DefineUnit[_m]
	type second = DefineUnit[_s]
	type kilogram = DefineUnit[_k~:_g]
	type ampere = DefineUnit[_A]
	type kelvin = DefineUnit[_K]
	type candela = DefineUnit[_c~:_d]
	type mole = DefineUnit[_m~:_o~:_l]

	type newton = (metre × kilogram) / (second × second)
	type joule = newton × metre
	type watt = joule / second
	type hertz = Scalar / second
	type coulomb = ampere × second
	type volt = watt / ampere
	type ohm = volt / ampere
	type pascal = newton × square[metre]
	type farad = coulomb / volt
	type siemens = coulomb / volt
	type weber = joule / ampere
	type tesla = newton / (ampere × metre)
	type henry = weber / ampere
	type bequerel = Scalar / second
	type gray = joule / kilogram
	type sievert = joule / kilogram
	type katal = mole / second

	type newton_repr = DefineUnit[_N]
	type joule_repr = DefineUnit[_J]
	type watt_repr = DefineUnit[_W]
	type hertz_repr = DefineUnit[_H~:_z]
	type coulomb_repr = DefineUnit[_C]
	type volt_repr = DefineUnit[_V]
	type ohm_repr = DefineUnit[_OMEGA]
	type pascal_repr = DefineUnit[_P~:_a]
	type farad_repr = DefineUnit[_F]
	type siemens_repr = DefineUnit[_S]
	type weber_repr = DefineUnit[_S]
	type tesla_repr = DefineUnit[_T]
	type henry_repr = DefineUnit[_H]
	type bequerel_repr = DefineUnit[_B~:_q]
	type gray_repr = DefineUnit[_G~:_y]
	type katal_repr = DefineUnit[_k~:_a~:_t]

	implicit val newton_alias = alias[newton, newton_repr]
	implicit val joule_alias = alias[joule, joule_repr]
	implicit val watt_alias = alias[watt, watt_repr]
	implicit val hertz_alias = alias[hertz, hertz_repr]
	implicit val coulomb_alias = alias[coulomb, coulomb_repr]
	implicit val volt_alias = alias[ohm, ohm_repr]
	implicit val ohm_alias = alias[ohm, ohm_repr]
	implicit val pascal_alias = alias[pascal, pascal_repr]
	implicit val farad_alias = alias[farad, farad_repr]
	implicit val siemens_alias = alias[siemens, siemens_repr]
	implicit val weber_alias = alias[weber, weber_repr]
	implicit val tesla_alias = alias[tesla, tesla_repr]
	implicit val henry_alias = alias[henry, henry_repr]
	implicit val bequerel_alias = alias[bequerel, bequerel_repr]
	implicit val gray_alias = alias[gray, gray_repr]
	implicit val katal_alias = alias[katal, katal_repr]

	// mass units
	type milligram = DefineUnit[_m~:_g]
	type gram = DefineUnit[_g]
	type tonne = DefineUnit[_t]
	implicit val kg_to_g  = one[kilogram].contains(1000)[gram]
	implicit val g_to_mg  = one[gram    ].contains(1000)[milligram]
	implicit val kg_to_mg = one[kilogram].contains(1000000)[milligram]
	implicit val t_to_kg  = one[tonne   ].contains(1000)[kilogram]
	implicit val t_to_g   = one[tonne   ].contains(1000000)[gram]
	implicit val t_to_mg  = one[tonne   ].contains(1000000000)[milligram]

	// distance units
	type angstrom = DefineUnit[_AA]
	type nanometre = DefineUnit[_n~:_m]
	type micrometre = DefineUnit[_mu~:_m]
	type millimetre = DefineUnit[_m~:_m]
	type centimetre = DefineUnit[_c~:_m]
	type kilometre = DefineUnit[_k~:_m]
	implicit val km_to_m  = one[kilometre ].contains(1000)[metre]
	implicit val m_to_cm  = one[metre     ].contains(100)[centimetre]
	implicit val m_to_mm  = one[metre     ].contains(1000)[millimetre]
	implicit val m_to_um  = one[metre     ].contains(1000000)[micrometre]
	implicit val m_to_nm  = one[metre     ].contains(1000000000)[nanometre]
	implicit val cm_to_mm = one[centimetre].contains(10)[millimetre]
	implicit val cm_to_um = one[centimetre].contains(10000)[micrometre]
	implicit val cm_to_nm = one[centimetre].contains(10000000)[nanometre]
	implicit val mm_to_um = one[millimetre].contains(1000)[micrometre]
	implicit val mm_to_nm = one[millimetre].contains(1000000)[nanometre]
	implicit val um_to_nm = one[micrometre].contains(1000)[nanometre]
	implicit val m_to_AA  = one[metre     ].contains(10000000000L)[angstrom]
	implicit val cm_to_AA = one[centimetre].contains(100000000)[angstrom]
	implicit val mm_to_AA = one[millimetre].contains(10000000)[angstrom]
	implicit val um_to_AA = one[micrometre].contains(10000)[angstrom]
	implicit val nm_to_AA = one[nanometre ].contains(10)[angstrom]

	// area units
	type are     = DefineUnit[_a]
	type hectare = DefineUnit[_h~:_a]
	implicit val ha_to_a   = one[hectare].contains(100)[are]
	implicit val a_to_m2   = one[are].contains(100)[metre × metre]
	implicit val km2_to_ha = one[kilometre × kilometre].contains(100)[hectare]
	implicit val ha_to_m2  = ha_to_a  >> a_to_m2
	implicit val km2_to_a  = km2_to_ha >> ha_to_a

	// volume units
	type millilitre = DefineUnit[_m~:_l]
	type centilitre = DefineUnit[_c~:_l]
	type litre      = DefineUnit[_l]
	type hectolitre = DefineUnit[_h~:_l]
	implicit val m3_to_hl  = one[cube[metre]].contains( 10)[hectolitre]
	implicit val hl_to_l   = one[hectolitre ].contains(100)[litre]
	implicit val l_to_cl   = one[litre      ].contains(100)[centilitre]
	implicit val cl_to_ml  = one[centilitre ].contains( 10)[millilitre]
	implicit val cl_to_cm3 = one[centilitre ].contains( 10)[cube[centimetre]]
	implicit val m3_to_l   = m3_to_hl >> hl_to_l
	implicit val l_to_ml   = l_to_cl  >> cl_to_ml
	implicit val l_to_cm3  = l_to_cl  >> cl_to_cm3
	implicit val ml_to_cm3 = alias[cube[centimetre], millilitre]

	// time units
	type nanosecond  = DefineUnit[_n~:_s]
	type microsecond = DefineUnit[_mu~:_s]
	type millisecond = DefineUnit[_m~:_s]
	type minute = DefineUnit[_m~:_i~:_n]
	type hour   = DefineUnit[_h]
	type day    = DefineUnit[_d]
	type week   = DefineUnit[_w~:_e~:_e~:_k]
	implicit val s_to_ns   = one[second].contains(1000000000)[nanosecond]
	implicit val s_to_us   = one[second].contains(1000000)[microsecond]
	implicit val s_to_ms   = one[second].contains(1000)[millisecond]
	implicit val min_to_s  = one[minute].contains(60)[second]
	implicit val h_to_min  = one[hour  ].contains(60)[minute]
	implicit val d_to_h    = one[day   ].contains(24)[hour]
	implicit val week_to_d = one[week  ].contains(7)[day]
	implicit val h_to_s      = h_to_min  >> min_to_s
	implicit val d_to_min    = d_to_h    >> h_to_min
	implicit val d_to_s      = d_to_h    >> h_to_s
	implicit val week_to_h   = week_to_d >> d_to_h
	implicit val week_to_min = week_to_h >> h_to_min
	implicit val week_to_s   = week_to_h >> h_to_s

	// speed unit conversions
	val mps_to_cmps = m_to_cm.dividedBy[second]
	val kmph_to_mps = km_to_m / h_to_s

	// pressure units
	type bar = DefineUnit[_b~:_a~:_r]
	type millibar = DefineUnit[_m~:_b~:_a~:_r]
	type hectopascal = DefineUnit[_h~:_P~:_a]
	type atmosphere = DefineUnit[_a~:_t~:_m]
	type torr = DefineUnit[_T~:_o~:_r~:_r]
	implicit val bar_to_mbar = one[bar].contains(1000)[millibar]
	implicit val bar_to_hPa  = one[bar].contains(1000)[hectopascal]
	implicit val mbar_to_Pa  = one[millibar].contains(100)[pascal]
	implicit val hPa_to_Pa   = one[hectopascal].contains(100)[pascal]
	implicit val bar_to_Pa   = bar_to_hPa >> hPa_to_Pa
	implicit val atm_to_Pa   = one[atmosphere].contains(101325)[pascal]
	implicit val atm_to_Torr = one[atmosphere].contains(720)[torr]
	implicit val atm_to_hPa  = atm_to_Pa >< hPa_to_Pa
	implicit val atm_to_bar  = atm_to_Pa >< bar_to_Pa
	implicit val atm_to_mbar = atm_to_Pa >< mbar_to_Pa
	implicit val Torr_to_Pa  = atm_to_Torr <> atm_to_Pa
	implicit val Torr_to_hPa = atm_to_Torr <> atm_to_hPa
	implicit val Torr_to_bar = atm_to_Torr <> atm_to_bar
	implicit val Torr_to_mbar = atm_to_Torr <> atm_to_mbar

	// energy units
	type kilocalorie = DefineUnit[_k~:_c~:_a~:_l]
	implicit val kcal_to_J = one[kilocalorie].contains(4184)[joule]

	// temperature units
	type celsius_deg = DefineUnit[_deg~:_C]
	implicit val kelvin_celsius_eq = alias[kelvin, celsius_deg]

	//temperature affine spaces

	sealed trait KelvinZero
	sealed trait CelsiusZero

	type KelvinScale = DefineAffineSpace[KelvinZero, kelvin]
	type CelsiusScale = DefineAffineSpace[CelsiusZero, celsius_deg]

	implicit val fromCelsiusToKelvin = convertAffineSpace[CelsiusScale,KelvinScale]{ _ + 273.15 }
	implicit val fromKelvinToCelsius = convertAffineSpace[KelvinScale,CelsiusScale]{ _ - 273.15 }


	// alternative spelling
	type nanometer  = nanometre
	type micrometer = micrometre
	type millimeter = millimetre
	type centimeter = centimetre
	type meter      = metre
	type kilometer  = kilometre
	type milliliter = millilitre
	type centiliter = centilitre
	type liter      = litre
	type hectoliter = hectolitre


	object Short {
		type km = kilometre
		type m  = metre
		type cm = centimetre
		type mm = millimetre
		type µm = micrometre
		type nm = nanometre
		type Å  = angstrom

		type t  = tonne
		type kg = kilogram
		type g  = gram
		type mg = milligram

		type h  = hour
		type min = minute
		type s  = second
		type ms = millisecond
		type µs = microsecond
		type ns = nanosecond

		type hl = hectolitre
		type l  = litre
		type cl = centilitre
		type ml = millilitre

		type hL = hectolitre
		type L  = litre
		type cL = centilitre
		type mL = millilitre

		type ha = hectare
		type a  = are

		type atm  = atmosphere
		type mbar = millibar
		type hPa  = hectopascal
		type Torr = torr

		type mol  = mole
		type cd   = candela
		type kcal = kilocalorie

		type N  = newton
		type J  = joule
		type C  = coulomb
		type A  = ampere
		type W  = watt
		type V  = volt
		type Ω  = ohm
		type Hz = hertz
		type Pa = pascal
		type F  = farad
		type S  = siemens
		type Wb = weber
		type T  = tesla
		type Hr = henry
		type Bq = bequerel
		type Gy = gray
		type Sv = sievert
		type kat = katal
	}
}