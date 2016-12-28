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
package io.github.karols.units.typelevel

import io.github.karols.units.internal.Strings._
import io.github.karols.units.internal.Bools._
import io.github.karols.units.internal.Integers._
import io.github.karols.units.internal.UnitImpl._
import io.github.karols.units.internal.SingleUnits._
import io.github.karols.units._
import io.github.karols.units.defining._
import io.github.karols.units.SI._
import io.github.karols.units.USCustomary._

// This trait has only to compile
sealed trait StringProofs{
	// implicitly[True  =:= _f#Equals[_f]]
	// implicitly[False =:= _e#Equals[_f]]
	// implicitly[False =:= _g#Equals[_f]]
	// implicitly[False =:= _h#Equals[_f]]
	// implicitly[False =:= _j#Equals[_f]]
	// implicitly[False =:= _A#Equals[_f]]
	// implicitly[False =:= _n#Equals[_f]]

	// implicitly[True  =:= _n#MatchEmptyNonempty[False, ({type L[H<:TChar,T<:TString]=True})#L, TBool]]

	// implicitly[True  =:= TZ5_0#EqualZ5[TZ5_0]]
	// implicitly[True  =:= TZ5_1#EqualZ5[TZ5_1]]
	// implicitly[True  =:= TZ5_2#EqualZ5[TZ5_2]]
	// implicitly[False =:= TZ5_0#EqualZ5[TZ5_4]]

	// implicitly[True  =:= TZ5_1#GreaterThanZ5[TZ5_0]]
	// implicitly[True  =:= TZ5_2#GreaterThanZ5[TZ5_1]]
	// implicitly[True  =:= TZ5_3#GreaterThanZ5[TZ5_2]]
	// implicitly[True  =:= TZ5_4#GreaterThanZ5[TZ5_3]]
	// implicitly[False =:= TZ5_1#GreaterThanZ5[TZ5_2]]
	// implicitly[False =:= TZ5_1#GreaterThanZ5[TZ5_3]]

	// implicitly[True  =:= _e#LessOrEqualChar[_f]]
	// implicitly[True  =:= _f#LessOrEqualChar[_f]]
	// implicitly[False =:= _g#LessOrEqualChar[_f]]

	// implicitly[True  =:= _e#EqualChar[_e]];

	// implicitly[True  =:= _e#LessOrEqual[_f]]
	// implicitly[True  =:= _f#LessOrEqual[_f]]
	// implicitly[False =:= _g#LessOrEqual[_f]]

}