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

	/** UAE dinar*/
	type AED = DefineUnit[_A~:_E~:_D]
	/** Albanian lek */
	type ALL = DefineUnit[_A~:_L~:_L]
	/** Armenian dram */
	type AMD = DefineUnit[_A~:_M~:_D]
	/** Angolan kwanza */
	type AOA = DefineUnit[_A~:_O~:_A]
	/** Argentinian peso */
	type ARS = DefineUnit[_A~:_R~:_S]
	/** Australian dollar */
	type AUD = DefineUnit[_A~:_U~:_D]
	/** Azeri manat */
	type AZN = DefineUnit[_A~:_Z~:_N]
	/** Bengali taka */
	type BDT = DefineUnit[_B~:_D~:_T]
	/** Bulgarian lev */
	type BGN = DefineUnit[_B~:_G~:_N]
	/** Brazilian rial */
	type BRL = DefineUnit[_B~:_R~:_L]
	/** Canadian dollar */
	type CAD = DefineUnit[_C~:_A~:_D]
	/** Swiss franc */
	type CHF = DefineUnit[_C~:_H~:_F]
	/** Chilean peso */
	type CLP = DefineUnit[_C~:_L~:_P]
	/** Chinese yuan */
	type CNY = DefineUnit[_C~:_N~:_Y]
	/** Colombian peso */
	type COP = DefineUnit[_C~:_O~:_P]
	/** Cuban convertible peso */
	type CUC = DefineUnit[_C~:_U~:_C]
	/** Cuban peso */
	type CUP = DefineUnit[_C~:_U~:_P]
	/** Czech koruna */
	type CZK = DefineUnit[_C~:_Z~:_K]
	/** Danish krone */
	type DKK = DefineUnit[_D~:_K~:_K]
	/** Algerian dinar */
	type DZD = DefineUnit[_D~:_Z~:_D]
	/** Egyptian pound */
	type EGP = DefineUnit[_E~:_G~:_P]
	/** Euro */
	type EUR = DefineUnit[_E~:_U~:_R]
	/** British pound */
	type GBP = DefineUnit[_G~:_B~:_P]
	/** Georgian lari */
	type GEL = DefineUnit[_G~:_E~:_L]
	/** Hong Kong dollar */
	type HKD = DefineUnit[_H~:_K~:_D]
	/** Hungarian forint */
	type HUF = DefineUnit[_H~:_U~:_F]
	/** Croatian kuna */
	type HRK = DefineUnit[_H~:_R~:_K]
	/** Indonesian rupiah */
	type IDR = DefineUnit[_I~:_D~:_R]
	/** Israeli shekel */
	type ILS = DefineUnit[_I~:_L~:_S]
	/** Indian rupee */
	type INR = DefineUnit[_I~:_N~:_R]
	/** Iraqi dinar */
	type IQD = DefineUnit[_I~:_Q~:_D]
	/** Iranian rial */
	type IRR = DefineUnit[_I~:_R~:_R]
	/** Icelandic krona */
	type ISK = DefineUnit[_I~:_S~:_K]
	/** Japanese yen */
	type JPY = DefineUnit[_J~:_P~:_Y]
	/** South Korean won */
	type KRW = DefineUnit[_K~:_R~:_W]
	/** Kuwaiti dinar */
	type KWD = DefineUnit[_K~:_W~:_D]
	/** Kazakh tenge */
	type KZT = DefineUnit[_K~:_Z~:_T]
	/** Lithuanian lit */
	type LTL = DefineUnit[_L~:_T~:_L]
	/** Latvian lat */
	type LVL = DefineUnit[_L~:_V~:_L]
	/** Moroccan dirham */
	type MAD = DefineUnit[_M~:_A~:_D]
	/** Macedonian denar */
	type MKD = DefineUnit[_M~:_K~:_D]
	/** Mexican peso */
	type MXN = DefineUnit[_M~:_X~:_N]
	/** Malaysian ringgit */
	type MYR = DefineUnit[_M~:_Y~:_R]
	/* Nigerian naira */
	type NGN = DefineUnit[_N~:_G~:_N]
	/** Norwegian krone */
	type NOK = DefineUnit[_N~:_O~:_K]
	/** New Zealand dollar */
	type NZD = DefineUnit[_N~:_Z~:_D]
	/** Omani rial */
	type OMR = DefineUnit[_O~:_M~:_R]
	/** Qatari riyal */
	type QAR = DefineUnit[_Q~:_A~:_R]
	/** Peruvian peso */
	type PEN = DefineUnit[_P~:_E~:_N]
	/** Filipino peso */
	type PHP = DefineUnit[_P~:_H~:_P]
	/** Pakistani rupee */
	type PKR = DefineUnit[_P~:_K~:_R]
	/** Polish zloty */
	type PLN = DefineUnit[_P~:_L~:_N]
	/** Romanian lei */
	type RON = DefineUnit[_R~:_O~:_N]
	/** Serbian dinar */
	type RSD = DefineUnit[_R~:_S~:_D]
	/** Russian ruble */
	type RUB = DefineUnit[_R~:_U~:_B]
	/** Saudi riyal */
	type SAR = DefineUnit[_S~:_A~:_R]
	/** Swedish krona */
	type SEK = DefineUnit[_S~:_E~:_K]
	/** Singaporean dollar */
	type SGD = DefineUnit[_S~:_G~:_D]
	/** Syrian pound */
	type SYP = DefineUnit[_S~:_Y~:_P]
	/** Thai bhat */
	type THB = DefineUnit[_T~:_H~:_B]
	/** Tunisian dinar */
	type TND = DefineUnit[_T~:_N~:_D]
	/** Turkish lira */
	type TRY = DefineUnit[_T~:_R~:_Y]
	/** Ukrainian hryvnia */
	type UAH = DefineUnit[_U~:_A~:_H]
	/** US dollar */
	type USD = DefineUnit[_U~:_S~:_D]
	/** Uruguayan peso */
	type UYU = DefineUnit[_U~:_Y~:_U]
	/** Venezuelan bolivar fuerte */
	type VEF = DefineUnit[_V~:_E~:_F]
	/** Vietnamese dong */
	type VND = DefineUnit[_V~:_N~:_D]
	/** Central African CFA franc */
	type XAF = DefineUnit[_X~:_A~:_F]
	/** East Caribbean dollar */
	type XCD = DefineUnit[_X~:_C~:_D]
	/** CFP franc (franc pacifique) */
	type XPF = DefineUnit[_X~:_P~:_F]
	/** South African rand */
	type ZAR = DefineUnit[_Z~:_A~:_R]

	// TODO: more currencies

	/** Short names for some currencies. Only those that have unique abbreviations were used.*/
	object Short {

		/** Short alias for Czech koruna */
		type Kč = CZK
		/** Short alias for Lithuanian lit */
		type Lt = LTL
		/** Short alias for Latvian lat */
		type Lv = LVL
		/** Short alias for Polish zloty */
		type zł = PLN
		/** Short alias for Chinese yuan */
		type 元 = CNY
		
	}

}