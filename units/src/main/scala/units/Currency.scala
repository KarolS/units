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

/**
Some of currencies of the world.
*/
object Currency {

	import stasiak.karol.units._
	import stasiak.karol.units.defining._

	type AED = DefineUnit[_A~:_E~:_D]
	type ARS = DefineUnit[_A~:_R~:_S]
	type AUD = DefineUnit[_A~:_U~:_D]
	type BRL = DefineUnit[_B~:_R~:_L]
	type CAD = DefineUnit[_C~:_A~:_D]
	type CHF = DefineUnit[_C~:_H~:_F]
	type CNY = DefineUnit[_C~:_N~:_Y]
	type COP = DefineUnit[_C~:_O~:_P]
	type CZK = DefineUnit[_C~:_Z~:_K]
	type DKK = DefineUnit[_D~:_K~:_K]
	type EUR = DefineUnit[_E~:_U~:_R]
	type GBP = DefineUnit[_G~:_B~:_P]
	type HKD = DefineUnit[_H~:_K~:_D]
	type HUF = DefineUnit[_H~:_U~:_F]
	type IDR = DefineUnit[_I~:_D~:_R]
	type ILS = DefineUnit[_I~:_L~:_S]
	type INR = DefineUnit[_I~:_N~:_R]
	type IQD = DefineUnit[_I~:_Q~:_D]
	type IRR = DefineUnit[_I~:_R~:_R]
	type JPY = DefineUnit[_J~:_P~:_Y]
	type KRW = DefineUnit[_K~:_R~:_W]
	type KZT = DefineUnit[_K~:_Z~:_T]
	type LTL = DefineUnit[_L~:_T~:_L]
	type LVL = DefineUnit[_L~:_V~:_L]
	type MXN = DefineUnit[_M~:_X~:_N]
	type NOK = DefineUnit[_N~:_O~:_K]
	type PKR = DefineUnit[_P~:_K~:_R]
	type PLN = DefineUnit[_P~:_L~:_N]
	type SEK = DefineUnit[_S~:_E~:_K]
	type THB = DefineUnit[_T~:_H~:_B]
	type TRY = DefineUnit[_T~:_R~:_Y]
	type USD = DefineUnit[_U~:_S~:_D]
	type VEF = DefineUnit[_V~:_E~:_F]
	type XAF = DefineUnit[_X~:_A~:_F]
	type XCD = DefineUnit[_X~:_C~:_D]
	type XPF = DefineUnit[_X~:_P~:_F]
	type ZAR = DefineUnit[_Z~:_A~:_R]

	// TODO: more currencies

	/** Short names for some currencies. Only those that have unique abbreviations were used.*/
	object Short {

		type Kč = CZK
		type Lt = LTL
		type Lv = LVL
		type zł = PLN
		type 元 = CNY
		
	}

}