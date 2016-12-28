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
sealed trait UnitImplProofs{

	implicitly[P1 =:= (_m^P1)#Get[_m]]
	implicitly[P2 =:= (_m^P2)#Get[_m]]

	implicitly[metre   =:= square[metre]#Sqrt]
	implicitly[Nothing =:= (metre/second)#Sqrt]

	implicitly[True  =:= cube[metre]#IsCube]
	implicitly[False =:= square[metre]#IsCube]
	implicitly[True  =:= cube[_1]#IsCube]

	implicitly[True =:= ASingleUnit[_e]#LessEqualGreater[ASingleUnit[_f],True,False,False,TBool]]
	implicitly[True =:= ASingleUnit[_f]#LessEqualGreater[ASingleUnit[_f],False,True,False,TBool]]
	implicitly[True =:= ASingleUnit[_g]#LessEqualGreater[ASingleUnit[_f],False,False,True,TBool]]

	implicitly[metre  =:= metre#Substitute[ASingleUnit[_e], second]]
	implicitly[second =:= metre#Substitute[ASingleUnit[_m], second]]
	implicitly[_1     =:= _1#Substitute[ASingleUnit[_m], second]]
	implicitly[_1     =:= (metre/second)#Substitute[ASingleUnit[_s], metre]]
}