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
package io.github.karols.units

/** SI units. */
object SI {
	
	import defining._
	import Mechanical._

	/** A system with a single unit: metre, used to measure length */
	val LengthInMetres = System1[length, metre]
	/** A system with a single unit: metre, used to measure length */
	val LengthInMeters = System1[length, metre]
	/** A system with a single unit: centimetre, used to measure length */
	val LengthInCentimetres = System1[length, centimetre]
	/** A system with a single unit: centimetre, used to measure length */
	val LengthInCentimeters = System1[length, centimetre]
	/** A system with a single unit: kilometre, used to measure length */
	val LengthInKilometres = System1[length, kilometre]
	/** A system with a single unit: kilometre, used to measure length */
	val LengthInKilometers = System1[length, kilometre]
	/** A system with a single unit: hour, used to measure time */
	val TimeInHours = System1[time, hour]
	/** A system with a single unit: second, used to measure time */
	val TimeInSeconds = System1[time, second]
	/** A system with a single unit: gram, used to measure mass */
	val MassInGrams = System1[mass, gram]
	/** A system with a single unit: kilogram, used to measure mass */
	val MassInKilograms = System1[mass, kilogram]

	/** Standard metre-kilogram-second mechanical system */
	val MKS = LengthInMetres & MassInKilograms & TimeInSeconds
	/** Centimetre-gram-second mechanical system */
	val CGS = LengthInCentimetres & MassInGrams & TimeInSeconds

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
	type hertz = _1 / second
	type coulomb = ampere × second
	type volt = watt / ampere
	type ohm = volt / ampere
	type pascal = newton × square[metre]
	type farad = coulomb / volt
	type siemens = coulomb / volt
	type weber = joule / ampere
	type tesla = newton / (ampere × metre)
	type henry = weber / ampere
	type bequerel = _1 / second
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

	implicit val implicit__newton_alias = alias[newton, newton_repr]
	implicit val implicit__joule_alias = alias[joule, joule_repr]
	implicit val implicit__watt_alias = alias[watt, watt_repr]
	implicit val implicit__hertz_alias = alias[hertz, hertz_repr]
	implicit val implicit__coulomb_alias = alias[coulomb, coulomb_repr]
	implicit val implicit__volt_alias = alias[volt, volt_repr]
	implicit val implicit__ohm_alias = alias[ohm, ohm_repr]
	implicit val implicit__pascal_alias = alias[pascal, pascal_repr]
	implicit val implicit__farad_alias = alias[farad, farad_repr]
	implicit val implicit__siemens_alias = alias[siemens, siemens_repr]
	implicit val implicit__weber_alias = alias[weber, weber_repr]
	implicit val implicit__tesla_alias = alias[tesla, tesla_repr]
	implicit val implicit__henry_alias = alias[henry, henry_repr]
	implicit val implicit__bequerel_alias = alias[bequerel, bequerel_repr]
	implicit val implicit__gray_alias = alias[gray, gray_repr]
	implicit val implicit__katal_alias = alias[katal, katal_repr]

	// mass units
	type milligram = DefineUnit[_m~:_g]
	type gram = DefineUnit[_g]
	type decagram = DefineUnit[_d~:_a~:_g]
	type dekagram = decagram
	type tonne = DefineUnit[_t]
	implicit val implicit__kg_to_g  = one[kilogram].contains(1000)[gram]
	implicit val implicit__kg_to_dag = one[kilogram].contains(100)[decagram]
	implicit val implicit__dag_to_g  = one[decagram].contains(10)[gram]
	implicit val implicit__dag_to_mg = one[decagram].contains(10000)[milligram]
	implicit val implicit__g_to_mg  = one[gram    ].contains(1000)[milligram]
	implicit val implicit__kg_to_mg = one[kilogram].contains(1000000)[milligram]
	implicit val implicit__t_to_kg  = one[tonne   ].contains(1000)[kilogram]
	implicit val implicit__t_to_dag = one[tonne   ].contains(100000)[decagram]
	implicit val implicit__t_to_g   = one[tonne   ].contains(1000000)[gram]
	implicit val implicit__t_to_mg  = one[tonne   ].contains(1000000000)[milligram]

	// distance units
	type angstrom = DefineUnit[_AA]
	type nanometre = DefineUnit[_n~:_m]
	type micrometre = DefineUnit[_mu~:_m]
	type millimetre = DefineUnit[_m~:_m]
	type centimetre = DefineUnit[_c~:_m]
	type kilometre = DefineUnit[_k~:_m]
	implicit val implicit__km_to_m  = one[kilometre ].contains(1000)[metre]
	implicit val implicit__km_to_cm = one[kilometre ].contains(1000000)[centimetre]
	implicit val implicit__km_to_mm = one[kilometre ].contains(1000000000)[millimetre]
	implicit val implicit__km_to_um = one[kilometre ].contains(1000000000000L)[micrometre]
	implicit val implicit__km_to_nm = one[kilometre ].contains(1000000000000000L)[nanometre]
	implicit val implicit__m_to_cm  = one[metre     ].contains(100)[centimetre]
	implicit val implicit__m_to_mm  = one[metre     ].contains(1000)[millimetre]
	implicit val implicit__m_to_um  = one[metre     ].contains(1000000)[micrometre]
	implicit val implicit__m_to_nm  = one[metre     ].contains(1000000000)[nanometre]
	implicit val implicit__cm_to_mm = one[centimetre].contains(10)[millimetre]
	implicit val implicit__cm_to_um = one[centimetre].contains(10000)[micrometre]
	implicit val implicit__cm_to_nm = one[centimetre].contains(10000000)[nanometre]
	implicit val implicit__mm_to_um = one[millimetre].contains(1000)[micrometre]
	implicit val implicit__mm_to_nm = one[millimetre].contains(1000000)[nanometre]
	implicit val implicit__um_to_nm = one[micrometre].contains(1000)[nanometre]
	
	implicit val implicit__km_to_AA = one[kilometre ].contains(10000000000000L)[angstrom]
	implicit val implicit__m_to_AA  = one[metre     ].contains(10000000000L)[angstrom]
	implicit val implicit__cm_to_AA = one[centimetre].contains(100000000)[angstrom]
	implicit val implicit__mm_to_AA = one[millimetre].contains(10000000)[angstrom]
	implicit val implicit__um_to_AA = one[micrometre].contains(10000)[angstrom]
	implicit val implicit__nm_to_AA = one[nanometre ].contains(10)[angstrom]

	// area units
	type are     = DefineUnit[_a]
	type hectare = DefineUnit[_h~:_a]
	implicit val implicit__ha_to_a   = one[hectare].contains(100)[are]
	implicit val implicit__a_to_m2   = one[are].contains(100)[metre × metre]
	implicit val implicit__km2_to_ha = one[kilometre × kilometre].contains(100)[hectare]
	implicit val implicit__ha_to_m2  = implicit__ha_to_a   >> implicit__a_to_m2
	implicit val implicit__km2_to_a  = implicit__km2_to_ha >> implicit__ha_to_a

	// volume units
	type millilitre = DefineUnit[_m~:_l]
	type centilitre = DefineUnit[_c~:_l]
	type litre      = DefineUnit[_l]
	type hectolitre = DefineUnit[_h~:_l]
	implicit val implicit__m3_to_hl  = one[cube[metre]].contains( 10)[hectolitre]
	implicit val implicit__hl_to_l   = one[hectolitre ].contains(100)[litre]
	implicit val implicit__l_to_cl   = one[litre      ].contains(100)[centilitre]
	implicit val implicit__cl_to_ml  = one[centilitre ].contains( 10)[millilitre]
	implicit val implicit__cl_to_cm3 = one[centilitre ].contains( 10)[cube[centimetre]]
	implicit val implicit__m3_to_l   = implicit__m3_to_hl >> implicit__hl_to_l
	implicit val implicit__l_to_ml   = implicit__l_to_cl  >> implicit__cl_to_ml
	implicit val implicit__l_to_cm3  = implicit__l_to_cl  >> implicit__cl_to_cm3
	implicit val implicit__ml_to_cm3 = alias[cube[centimetre], millilitre]

	// time units
	type nanosecond  = DefineUnit[_n~:_s]
	type microsecond = DefineUnit[_mu~:_s]
	type millisecond = DefineUnit[_m~:_s]
	type minute = DefineUnit[_m~:_i~:_n]
	type hour   = DefineUnit[_h]
	type day    = DefineUnit[_d]
	type week   = DefineUnit[_w~:_e~:_e~:_k]
	implicit val implicit__s_to_ns   = one[second].contains(1000000000)[nanosecond]
	implicit val implicit__s_to_us   = one[second].contains(1000000)[microsecond]
	implicit val implicit__s_to_ms   = one[second].contains(1000)[millisecond]
	implicit val implicit__min_to_s  = one[minute].contains(60)[second]
	implicit val implicit__h_to_min  = one[hour  ].contains(60)[minute]
	implicit val implicit__d_to_h    = one[day   ].contains(24)[hour]
	implicit val implicit__week_to_d = one[week  ].contains(7)[day]
	implicit val implicit__ms_to_ns  = one[millisecond].contains(1000000)[nanosecond]
	implicit val implicit__us_to_ns  = one[microsecond].contains(1000)[nanosecond]
	implicit val implicit__ms_to_us  = one[millisecond].contains(1000)[microsecond]
	implicit val implicit__h_to_s      = implicit__h_to_min  >> implicit__min_to_s
	implicit val implicit__d_to_min    = implicit__d_to_h    >> implicit__h_to_min
	implicit val implicit__d_to_s      = implicit__d_to_h    >> implicit__h_to_s
	implicit val implicit__week_to_h   = implicit__week_to_d >> implicit__d_to_h
	implicit val implicit__week_to_min = implicit__week_to_h >> implicit__h_to_min
	implicit val implicit__week_to_s   = implicit__week_to_h >> implicit__h_to_s
	implicit val implicit__min_to_ms   = implicit__min_to_s  >> implicit__s_to_ms
	implicit val implicit__min_to_us   = implicit__min_to_s  >> implicit__s_to_us
	implicit val implicit__min_to_ns   = implicit__min_to_s  >> implicit__s_to_ns
	implicit val implicit__h_to_ms  = implicit__h_to_s >> implicit__s_to_ms
	implicit val implicit__h_to_us  = implicit__h_to_s >> implicit__s_to_us
	implicit val implicit__h_to_ns  = implicit__h_to_s >> implicit__s_to_ns
	implicit val implicit__d_to_ms   = implicit__d_to_s  >> implicit__s_to_ms
	implicit val implicit__d_to_us   = implicit__d_to_s  >> implicit__s_to_us
	implicit val implicit__d_to_ns   = implicit__d_to_s  >> implicit__s_to_ns
	implicit val implicit__week_to_ms  = implicit__week_to_s >> implicit__s_to_ms
	implicit val implicit__week_to_us  = implicit__week_to_s >> implicit__s_to_us
	implicit val implicit__week_to_ns  = implicit__week_to_s >> implicit__s_to_ns

	// speed unit conversions
	implicit val implicit__mps_to_cmps = implicit__m_to_cm.dividedBy[second]
	implicit val implicit__kmph_to_mps = implicit__km_to_m / implicit__h_to_s

	// pressure units
	type bar = DefineUnit[_b~:_a~:_r]
	type millibar = DefineUnit[_m~:_b~:_a~:_r]
	type hectopascal = DefineUnit[_h~:_P~:_a]
	type atmosphere = DefineUnit[_a~:_t~:_m]
	type torr = DefineUnit[_T~:_o~:_r~:_r]
	implicit val implicit__bar_to_mbar = one[bar].contains(1000)[millibar]
	implicit val implicit__bar_to_hPa  = one[bar].contains(1000)[hectopascal]
	implicit val implicit__mbar_to_Pa  = one[millibar].contains(100)[pascal]
	implicit val implicit__hPa_to_Pa   = one[hectopascal].contains(100)[pascal]
	implicit val implicit__bar_to_Pa   = implicit__bar_to_hPa >> implicit__hPa_to_Pa
	implicit val implicit__atm_to_Pa   = one[atmosphere].contains(101325)[pascal]
	implicit val implicit__atm_to_Torr = one[atmosphere].contains(720)[torr]
	implicit val implicit__atm_to_hPa  = implicit__atm_to_Pa >< implicit__hPa_to_Pa
	implicit val implicit__atm_to_bar  = implicit__atm_to_Pa >< implicit__bar_to_Pa
	implicit val implicit__atm_to_mbar = implicit__atm_to_Pa >< implicit__mbar_to_Pa
	implicit val implicit__Torr_to_Pa  = implicit__atm_to_Torr <> implicit__atm_to_Pa
	implicit val implicit__Torr_to_hPa = implicit__atm_to_Torr <> implicit__atm_to_hPa
	implicit val implicit__Torr_to_bar = implicit__atm_to_Torr <> implicit__atm_to_bar
	implicit val implicit__Torr_to_mbar = implicit__atm_to_Torr <> implicit__atm_to_mbar

	// energy units
	type kilocalorie = DefineUnit[_k~:_c~:_a~:_l]
	implicit val implicit__kcal_to_J = one[kilocalorie].contains(4184)[joule]

	// temperature units
	type celsius_deg = DefineUnit[_deg~:_C]
	implicit val implicit__kelvin_celsius_eq = alias[kelvin, celsius_deg]

	//temperature affine spaces

	sealed trait KelvinZero
	sealed trait CelsiusZero

	type KelvinScale = DefineAffineSpace[KelvinZero, kelvin]
	type CelsiusScale = DefineAffineSpace[CelsiusZero, celsius_deg]

	implicit val implicit__celsiusKelvin = matchingAffineSpacePoints(
		-273.15.at[CelsiusScale], 0.at[KelvinScale],
		0.at[CelsiusScale], 273.15.at[KelvinScale])

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


	/** Shorter symbols for some SI units. */
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