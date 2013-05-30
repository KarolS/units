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

/** Units of information. */
object Information {
	import stasiak.karol.units._
	import stasiak.karol.units.defining._

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

	implicit val implicit__B_to_b = one[byte].contains(8)[bit]
	implicit val implicit__kB_to_kb = one[kilobyte].contains(8)[kilobit]
	implicit val implicit__MB_to_Mb = one[megabyte].contains(8)[megabit]
	implicit val implicit__GB_to_Gb = one[gigabyte].contains(8)[gigabit]
	implicit val implicit__TB_to_Tb = one[terabyte].contains(8)[terabit]
	implicit val implicit__PB_to_Pb = one[petabyte].contains(8)[petabit]

	implicit val implicit__kB_to_B  = one[kilobyte].contains(1000)[byte]
	implicit val implicit__MB_to_kB = one[megabyte].contains(1000)[kilobyte]
	implicit val implicit__GB_to_MB = one[gigabyte].contains(1000)[megabyte]
	implicit val implicit__TB_to_GB = one[terabyte].contains(1000)[gigabyte]
	implicit val implicit__PB_to_TB = one[petabyte].contains(1000)[terabyte]
	implicit val implicit__MB_to_B  = one[megabyte].contains(1000000)[byte]
	implicit val implicit__GB_to_kB = one[gigabyte].contains(1000000)[kilobyte]
	implicit val implicit__TB_to_MB = one[terabyte].contains(1000000)[megabyte]
	implicit val implicit__PB_to_GB = one[petabyte].contains(1000000)[gigabyte]
	implicit val implicit__GB_to_B  = one[gigabyte].contains(1000000000)[byte]
	implicit val implicit__TB_to_kB = one[terabyte].contains(1000000000)[kilobyte]
	implicit val implicit__PB_to_MB = one[petabyte].contains(1000000000)[megabyte]
	implicit val implicit__TB_to_B  = one[terabyte].contains(1000000000000L)[byte]
	implicit val implicit__PB_to_kB = one[petabyte].contains(1000000000000L)[kilobyte]
	implicit val implicit__PB_to_B =  one[petabyte].contains(1000000000000000L)[byte]


	implicit val implicit__kb_to_b  = one[kilobit].contains(1000)[bit]
	implicit val implicit__Mb_to_kb = one[megabit].contains(1000)[kilobit]
	implicit val implicit__Gb_to_Mb = one[gigabit].contains(1000)[megabit]
	implicit val implicit__Tb_to_Gb = one[terabit].contains(1000)[gigabit]
	implicit val implicit__Pb_to_Tb = one[petabit].contains(1000)[terabit]
	implicit val implicit__Mb_to_b  = one[megabit].contains(1000000)[bit]
	implicit val implicit__Gb_to_kb = one[gigabit].contains(1000000)[kilobit]
	implicit val implicit__Tb_to_Mb = one[terabit].contains(1000000)[megabit]
	implicit val implicit__Pb_to_Gb = one[petabit].contains(1000000)[gigabit]
	implicit val implicit__Gb_to_b  = one[gigabit].contains(1000000000)[bit]
	implicit val implicit__Tb_to_kb = one[terabit].contains(1000000000)[kilobit]
	implicit val implicit__Pb_to_Mb = one[petabit].contains(1000000000)[megabit]
	implicit val implicit__Tb_to_b  = one[terabit].contains(1000000000000L)[bit]
	implicit val implicit__Pb_to_kb = one[petabit].contains(1000000000000L)[kilobit]
	implicit val implicit__Pb_to_b =  one[petabit].contains(1000000000000000L)[bit]

	implicit val implicit__kB_to_b  = one[kilobyte].contains(8000)[bit]
	implicit val implicit__MB_to_kb = one[megabyte].contains(8000)[kilobit]
	implicit val implicit__GB_to_Mb = one[gigabyte].contains(8000)[megabit]
	implicit val implicit__TB_to_Gb = one[terabyte].contains(8000)[gigabit]
	implicit val implicit__PB_to_Tb = one[petabyte].contains(8000)[terabit]
	implicit val implicit__MB_to_b  = one[megabyte].contains(8000000)[bit]
	implicit val implicit__GB_to_kb = one[gigabyte].contains(8000000)[kilobit]
	implicit val implicit__TB_to_Mb = one[terabyte].contains(8000000)[megabit]
	implicit val implicit__PB_to_Gb = one[petabyte].contains(8000000)[gigabit]
	implicit val implicit__GB_to_b  = one[gigabyte].contains(8000000000L)[bit]
	implicit val implicit__TB_to_kb = one[terabyte].contains(8000000000L)[kilobit]
	implicit val implicit__PB_to_Mb = one[petabyte].contains(8000000000L)[megabit]
	implicit val implicit__TB_to_b  = one[terabyte].contains(8000000000000L)[bit]
	implicit val implicit__PB_to_kb = one[petabyte].contains(8000000000000L)[kilobit]
	implicit val implicit__PB_to_b =  one[petabyte].contains(8000000000000000L)[bit]

	implicit val implicit__KiB_to_B   = one[kibibyte].contains(0x400)[byte] 
	implicit val implicit__MiB_to_KiB = one[mebibyte].contains(0x400)[kibibyte] 
	implicit val implicit__GiB_to_MiB = one[gibibyte].contains(0x400)[mebibyte] 
	implicit val implicit__TiB_to_GiB = one[tebibyte].contains(0x400)[gibibyte] 
	implicit val implicit__PiB_to_TiB = one[pebibyte].contains(0x400)[tebibyte] 
	implicit val implicit__MiB_to_B   = one[mebibyte].contains(0x100000)[byte] 
	implicit val implicit__GiB_to_KiB = one[gibibyte].contains(0x100000)[kibibyte] 
	implicit val implicit__TiB_to_MiB = one[tebibyte].contains(0x100000)[mebibyte] 
	implicit val implicit__PiB_to_GiB = one[pebibyte].contains(0x100000)[gibibyte] 
	implicit val implicit__GiB_to_B   = one[gibibyte].contains(0x40000000)[byte] 
	implicit val implicit__TiB_to_KiB = one[tebibyte].contains(0x40000000)[kibibyte] 
	implicit val implicit__PiB_to_MiB = one[pebibyte].contains(0x40000000)[mebibyte]
	implicit val implicit__TiB_to_B   = one[tebibyte].contains(0x10000000000L)[byte] 
	implicit val implicit__PiB_to_KiB = one[pebibyte].contains(0x10000000000L)[kibibyte] 
	implicit val implicit__PiB_to_B   = one[pebibyte].contains(0x4000000000000L)[byte] 

	//TODO: conversions between binary prefixes for bits
	//TODO: conversions between binary and decimal prefixes

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