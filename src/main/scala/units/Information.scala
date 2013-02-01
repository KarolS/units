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

object Information {
	import stasiak.karol.units.Units._
	import stasiak.karol.units.DefiningUnits._

	type bit = DefineUnit[_b]
	type byte= DefineUnit[_B]

	type kilobit = DefineUnit[_k~:_b]
	type kilobyte= DefineUnit[_k~:_B]
	type kibibit = DefineUnit[_K~:_i~:_b]
	type kibibyte= DefineUnit[_K~:_i~:_B]

	type megabit = DefineUnit[_M~:_b]
	type megabyte= DefineUnit[_M~:_B]
	type mebibit = DefineUnit[_M~:_i~:_b]
	type mebibyte= DefineUnit[_M~:_i~:_B]

	type gigabit = DefineUnit[_G~:_b]
	type gigabyte= DefineUnit[_G~:_B]
	type gibibit = DefineUnit[_G~:_i~:_b]
	type gibibyte= DefineUnit[_G~:_i~:_B]

	type terabit = DefineUnit[_T~:_b]
	type terabyte= DefineUnit[_T~:_B]
	type tebibit = DefineUnit[_T~:_i~:_b]
	type tebibyte= DefineUnit[_T~:_i~:_B]

	type petabit = DefineUnit[_P~:_b]
	type petabyte= DefineUnit[_P~:_B]
	type pebibit = DefineUnit[_P~:_i~:_b]
	type pebibyte= DefineUnit[_P~:_i~:_B]

	implicit val B_to_b = one[byte].contains(8)[bit]

	implicit val kB_to_B  = one[kilobyte].contains(1000)[byte]
	implicit val MB_to_kB = one[megabyte].contains(1000)[kilobyte]
	implicit val GB_to_MB = one[gigabyte].contains(1000)[megabyte]
	implicit val TB_to_GB = one[terabyte].contains(1000)[gigabyte]
	implicit val PB_to_TB = one[petabyte].contains(1000)[terabyte]
	implicit val MB_to_B  = one[megabyte].contains(1000000)[byte]
	implicit val GB_to_kB = one[gigabyte].contains(1000000)[kilobyte]
	implicit val TB_to_MB = one[terabyte].contains(1000000)[megabyte]
	implicit val PB_to_GB = one[petabyte].contains(1000000)[gigabyte]
	implicit val GB_to_B  = one[gigabyte].contains(1000000000)[byte]
	implicit val TB_to_kB = one[terabyte].contains(1000000000)[kilobyte]
	implicit val PB_to_MB = one[petabyte].contains(1000000000)[megabyte]
	implicit val TB_to_B  = one[terabyte].contains(1000000000000L)[byte]
	implicit val PB_to_kB = one[petabyte].contains(1000000000000L)[kilobyte]
	implicit val PB_to_B =  one[petabyte].contains(1000000000000000L)[byte]


	implicit val kb_to_b  = one[kilobit].contains(1000)[bit]
	implicit val Mb_to_kb = one[megabit].contains(1000)[kilobit]
	implicit val Gb_to_Mb = one[gigabit].contains(1000)[megabit]
	implicit val Tb_to_Gb = one[terabit].contains(1000)[gigabit]
	implicit val Pb_to_Tb = one[petabit].contains(1000)[terabit]
	implicit val Mb_to_b  = one[megabit].contains(1000000)[bit]
	implicit val Gb_to_kb = one[gigabit].contains(1000000)[kilobit]
	implicit val Tb_to_Mb = one[terabit].contains(1000000)[megabit]
	implicit val Pb_to_Gb = one[petabit].contains(1000000)[gigabit]
	implicit val Gb_to_b  = one[gigabit].contains(1000000000)[bit]
	implicit val Tb_to_kb = one[terabit].contains(1000000000)[kilobit]
	implicit val Pb_to_Mb = one[petabit].contains(1000000000)[megabit]
	implicit val Tb_to_b  = one[terabit].contains(1000000000000L)[bit]
	implicit val Pb_to_kb = one[petabit].contains(1000000000000L)[kilobit]
	implicit val Pb_to_b =  one[petabit].contains(1000000000000000L)[bit]

	//TODO: conversions between binary prefixes and between bits and bytes

	object Short {
		type B = byte
		type kB = kilobyte
		type MB = megabyte
		type GB = gigabyte
		type TB = terabyte
		type PB = petabyte
		type KiB = kibibyte
		type MiB = mebibyte
		type GiB = gibibyte
		type TiB = tebibyte
		type PiB = pebibyte

		type b = bit
		type kb = kilobit
		type Mb = megabit
		type Gb = gigabit
		type Tb = terabit
		type Pb = petabit
		type Kib = kibibit
		type Mib = mebibit
		type Gib = gibibit
		type Tib = tebibit
		type Pib = pebibit
	}
}