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
package io.github.karols.units.typelevel

import io.github.karols.units._
import io.github.karols.units.defining._

// This trait has only to compile
sealed trait BasicUnitArithmeticProofs {

  type a = DefineUnit[_a]
  type b = DefineUnit[_b]
  type c = DefineUnit[_c]

  implicitly[inverse[inverse[a]] =:= a]
  implicitly[power4[a] =:= square[square[a]]]
  implicitly[power5[a] =:= (a × square[square[a]])]

  implicitly[inverseSquare[a] =:= square[inverse[a]]]
  implicitly[inverseSquare[a] =:= inverse[square[a]]]
  implicitly[inverseCube[a] =:= cube[inverse[a]]]
  implicitly[inverseCube[a] =:= inverse[cube[a]]]
  implicitly[inversePower4[a] =:= power4[inverse[a]]]
  implicitly[inversePower4[a] =:= inverse[power4[a]]]
  implicitly[inversePower5[a] =:= power5[inverse[a]]]
  implicitly[inversePower5[a] =:= inverse[power5[a]]]

  implicitly[(inversePower4[a] × power5[a]) =:= a]
  implicitly[(inverseCube[a] × power4[a]) =:= a]
  implicitly[(inverseSquare[a] × cube[a]) =:= a]
  implicitly[(inverse[a] × square[a]) =:= a]
}