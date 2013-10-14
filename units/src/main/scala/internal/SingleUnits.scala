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
package stasiak.karol.units.internal

object SingleUnits {
	import language.higherKinds
	import language.implicitConversions
	import Bools._
	import Integers._
	import Strings._
	import UnitImpl._

	/** Represents a defined unit raised to some non-zero power. */
	trait TSingleUnit {
		type Name <: TString
		// type Get[V<:TSingleUnit] = If[V#Name === Name,
		// 	P1,
		// 	_0,
		// Nat]
		type Equals[That<:TSingleUnit] <: TBool
		type LessEqualGreater[That<:TSingleUnit, Less<:Result, Equal<:Result, Greater<:Result, Result] <: Result
 	}
 	trait ASingleUnit[N<:TString] extends TSingleUnit {
		type Name = N
		type Equals[That<:TSingleUnit] = N === That#Name
		type LessEqualGreater[That<:TSingleUnit, Less<:Result, Equal<:Result, Greater<:Result, Result] =
			(N===That#Name)#DoIf[
				Equal,
				(N#LessOrEqual[That#Name])#DoIf2[
					Less,
					Greater,
				Result],
			Result]
 	}
 	type ====[X<:TSingleUnit,Y<:TSingleUnit] = X#Equals[Y]
 	
}