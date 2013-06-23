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
package stasiak.karol.units.typelevel

import stasiak.karol.units.internal.Strings._
import stasiak.karol.units.internal.Bools._
import stasiak.karol.units.internal.Integers._
import stasiak.karol.units.internal.UnitImpl._
import stasiak.karol.units.internal.SingleUnits._
import stasiak.karol.units._
import stasiak.karol.units.defining._
import stasiak.karol.units.SI._
import stasiak.karol.units.USCustomary._

// This trait has only to compile
sealed trait TypelevelProofs{


	implicitly[P4 =:= N2#Mul[N2]]

	implicitly[True  =:= _0#DivisibleByTwo]
	implicitly[False =:= P1#DivisibleByTwo]
	implicitly[True  =:= P2#DivisibleByTwo]
	implicitly[False =:= P3#DivisibleByTwo]
	implicitly[True  =:= P4#DivisibleByTwo]
	implicitly[False =:= P5#DivisibleByTwo]
	implicitly[True  =:= P6#DivisibleByTwo]
	implicitly[False =:= N1#DivisibleByTwo]
	implicitly[True  =:= N2#DivisibleByTwo]
	implicitly[False =:= N3#DivisibleByTwo]
	implicitly[True  =:= N4#DivisibleByTwo]

	implicitly[True  =:= _0#DivisibleByThree]
	implicitly[False =:= P1#DivisibleByThree]
	implicitly[False =:= P2#DivisibleByThree]
	implicitly[True  =:= P3#DivisibleByThree]
	implicitly[False =:= P4#DivisibleByThree]
	implicitly[False =:= P5#DivisibleByThree]
	implicitly[True  =:= P6#DivisibleByThree]
	implicitly[False =:= P7#DivisibleByThree]
	implicitly[False =:= P8#DivisibleByThree]
	implicitly[True  =:= P9#DivisibleByThree]
	implicitly[False =:= N1#DivisibleByThree]
	implicitly[False =:= N2#DivisibleByThree]
	implicitly[True  =:= N3#DivisibleByThree]
	implicitly[False =:= N4#DivisibleByThree]
	implicitly[False =:= N5#DivisibleByThree]
	implicitly[True  =:= N6#DivisibleByThree]
	implicitly[False =:= N7#DivisibleByThree]
	implicitly[False =:= N7#DivisibleByThree]
	implicitly[False =:= N8#DivisibleByThree]
	implicitly[True  =:= N9#DivisibleByThree]


	implicitly[_0 =:= _0#Half]
	implicitly[P1 =:= P2#Half]
	implicitly[P2 =:= P4#Half]
	implicitly[P3 =:= P6#Half]
	implicitly[P4 =:= P8#Half]
	implicitly[Nothing =:= P1#Half]
	implicitly[Nothing =:= P3#Half]
	implicitly[Nothing =:= P5#Half]
	implicitly[Nothing =:= P7#Half]
	implicitly[Nothing =:= P9#Half]
	implicitly[N1 =:= N2#Half]
	implicitly[N2 =:= N4#Half]
	implicitly[N3 =:= N6#Half]
	implicitly[N4 =:= N8#Half]
	implicitly[Nothing =:= N1#Half]
	implicitly[Nothing =:= N3#Half]
	implicitly[Nothing =:= N5#Half]
	implicitly[Nothing =:= N7#Half]
	implicitly[Nothing =:= N9#Half]

	implicitly[_0 =:= _0#Third]
	implicitly[P1 =:= P3#Third]
	implicitly[P2 =:= P6#Third]
	implicitly[P3 =:= P9#Third]
	implicitly[Nothing =:= P1#Third]
	implicitly[Nothing =:= P2#Third]
	implicitly[Nothing =:= P4#Third]
	implicitly[Nothing =:= P5#Third]
	implicitly[Nothing =:= P2#Third]
	implicitly[Nothing =:= P7#Third]
	implicitly[Nothing =:= P8#Third]
	implicitly[_0 =:= _0#Third]
	implicitly[N1 =:= N3#Third]
	implicitly[N2 =:= N6#Third]
	implicitly[N3 =:= N9#Third]
	implicitly[Nothing =:= N1#Third]
	implicitly[Nothing =:= N2#Third]
	implicitly[Nothing =:= N4#Third]
	implicitly[Nothing =:= N5#Third]
	implicitly[Nothing =:= N2#Third]
	implicitly[Nothing =:= N7#Third]
	implicitly[Nothing =:= N8#Third]

}