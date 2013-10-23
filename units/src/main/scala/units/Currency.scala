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
	/** Afghan afghani */
	type AFN = DefineUnit[_A~:_F~:_N]
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
	/** Bosnian mark */
	type BAM = DefineUnit[_B~:_A~:_M]
	/** Barbadian dinar */
	type BBD = DefineUnit[_B~:_B~:_D]
	/** Bengali taka */
	type BDT = DefineUnit[_B~:_D~:_T]
	/** Bulgarian lev */
	type BGN = DefineUnit[_B~:_G~:_N]
	/** Bahraini dinar */
	type BHD = DefineUnit[_B~:_H~:_D]
	/** Brazilian rial */
	type BRL = DefineUnit[_B~:_R~:_L]
	/** Bahamian dollar */
	type BSD = DefineUnit[_B~:_S~:_D]
	/** Botswana pula */
	type BWP = DefineUnit[_B~:_W~:_P]
	/** Belarusian ruble */
	type BYR = DefineUnit[_B~:_Y~:_R]
	/** Belize dollar */
	type BZD = DefineUnit[_B~:_Z~:_D]
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
	/** Costa Rica colon */
	type CRC = DefineUnit[_C~:_R~:_C]
	/** Cuban convertible peso */
	type CUC = DefineUnit[_C~:_U~:_C]
	/** Cuban peso */
	type CUP = DefineUnit[_C~:_U~:_P]
	/** Czech koruna */
	type CZK = DefineUnit[_C~:_Z~:_K]
	/** Danish krone */
	type DKK = DefineUnit[_D~:_K~:_K]
	/** Dominican peso */
	type DOP = DefineUnit[_D~:_O~:_P]
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
	/** Guinean franc */
	type GNF = DefineUnit[_G~:_N~:_F]
	/** Guatemalan quetzal */
	type GTQ = DefineUnit[_G~:_T~:_Q]
	/** Guyanese dollar */
	type GYD = DefineUnit[_G~:_Y~:_D]
	/** Hong Kong dollar */
	type HKD = DefineUnit[_H~:_K~:_D]
	/** Haitan gourde */
	type HTG = DefineUnit[_H~:_T~:_G]
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
	/** Jamaican dollar */
	type JMD = DefineUnit[_J~:_M~:_D]
	/** Jordanian dinar */
	type JOD = DefineUnit[_J~:_O~:_D]
	/** Japanese yen */
	type JPY = DefineUnit[_J~:_P~:_Y]
	/** Cambodian riel */
	type KHR = DefineUnit[_K~:_H~:_R]
	/** South Korean won */
	type KRW = DefineUnit[_K~:_R~:_W]
	/** Kuwaiti dinar */
	type KWD = DefineUnit[_K~:_W~:_D]
	/** Kazakh tenge */
	type KZT = DefineUnit[_K~:_Z~:_T]
	/** Laos kip */
	type LAK = DefineUnit[_L~:_A~:_K]
	/** Sri Lankan rupee */
	type LKR = DefineUnit[_L~:_K~:_R]
	/** Lithuanian lit */
	type LTL = DefineUnit[_L~:_T~:_L]
	/** Latvian lat */
	type LVL = DefineUnit[_L~:_V~:_L]
	/** Moroccan dirham */
	type MAD = DefineUnit[_M~:_A~:_D]
	/** Moldovan leu */
	type MDL = DefineUnit[_M~:_D~:_L]
	/** Macedonian denar */
	type MKD = DefineUnit[_M~:_K~:_D]
	/** Burmese kyat */
	type MMK = DefineUnit[_M~:_M~:_K]
	/** Mongolian togrog */
	type MNT = DefineUnit[_M~:_N~:_T]
	/** Mexican peso */
	type MXN = DefineUnit[_M~:_X~:_N]
	/** Malaysian ringgit */
	type MYR = DefineUnit[_M~:_Y~:_R]
	/* Nigerian naira */
	type NGN = DefineUnit[_N~:_G~:_N]
	/** Nicaraguan cordoba */
	type NIO = DefineUnit[_N~:_I~:_O]
	/** Norwegian krone */
	type NOK = DefineUnit[_N~:_O~:_K]
	/** New Zealand dollar */
	type NZD = DefineUnit[_N~:_Z~:_D]
	/** Omani rial */
	type OMR = DefineUnit[_O~:_M~:_R]
	/** Qatari riyal */
	type QAR = DefineUnit[_Q~:_A~:_R]
	/** Peruvian nuevo sol */
	type PEN = DefineUnit[_P~:_E~:_N]
	/** Filipino peso */
	type PHP = DefineUnit[_P~:_H~:_P]
	/** Pakistani rupee */
	type PKR = DefineUnit[_P~:_K~:_R]
	/** Polish zloty */
	type PLN = DefineUnit[_P~:_L~:_N]
	/** Paraguayan guarani */
	type PYG = DefineUnit[_P~:_Y~:_G]
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
	/** Surinamese dollar */
	type SRD = DefineUnit[_S~:_R~:_D]
	/** Thai bhat */
	type THB = DefineUnit[_T~:_H~:_B]
	/** Tajikistan somoni */
	type TJS = DefineUnit[_T~:_J~:_S]
	/** Turkmenistan manat */
	type TMT = DefineUnit[_T~:_M~:_T]
	/** Tunisian dinar */
	type TND = DefineUnit[_T~:_N~:_D]
	/** Turkish lira */
	type TRY = DefineUnit[_T~:_R~:_Y]
	/** Trinidad and Tobago dollar */
	type TTD = DefineUnit[_T~:_T~:_D]
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
	/** Vanuatu vatu */
	type VUV = DefineUnit[_V~:_U~:_V]
	/** Samoan tala */
	type WST = DefineUnit[_W~:_S~:_T]
	/** Central African CFA franc */
	type XAF = DefineUnit[_X~:_A~:_F]
	/** Bitcoin */
	type XBT = DefineUnit[_X~:_B~:_T]
	/** East Caribbean dollar */
	type XCD = DefineUnit[_X~:_C~:_D]
	/** West African CFA franc */
	type XOF = DefineUnit[_X~:_O~:_F]
	/** CFP franc (franc pacifique) */
	type XPF = DefineUnit[_X~:_P~:_F]
	/** Yemeni rial */
	type YER = DefineUnit[_Y~:_E~:_R]
	/** South African rand */
	type ZAR = DefineUnit[_Z~:_A~:_R]
	/** Zambian kwacha */
	type ZMW = DefineUnit[_Z~:_M~:_W]

	// TODO: more currencies

	/** Short names for some currencies. Only those that have unique abbreviations were used.*/
	object Short {

		/** Short alias for Czech koruna (CZK) */
		type Kč = CZK
		/** Short alias for Lithuanian lit (LTL) */
		type Lt = LTL
		/** Short alias for Latvian lat (LVL) */
		type Lv = LVL
		/** Short alias for Polish zloty (PLN) */
		type zł = PLN
		/** Short alias for Chinese yuan (CNY) */
		type 元 = CNY
		
	}

}