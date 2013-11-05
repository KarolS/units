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
package stasiak.units.typelevel

import stasiak.units.internal.Bools._

// This trait has only to compile
sealed trait BooleanProofs{

	implicitly[True  =:= (True  || True )]
	implicitly[True  =:= (False || True )]
	implicitly[True  =:= (True  || False)]
	implicitly[False =:= (False || False)]
	
	implicitly[True  =:= (True  && True )]
	implicitly[False =:= (False && True )]
	implicitly[False =:= (True  && False)]
	implicitly[False =:= (False && False)]

	implicitly[True  =:= False#Not]
	implicitly[False =:= True#Not]

	implicitly[True  =:= If[True,  True,  True,  TBool]]
	implicitly[True  =:= If[True,  True,  False, TBool]]
	implicitly[False =:= If[True,  False, True,  TBool]]
	implicitly[False =:= If[True,  False, False, TBool]]
	implicitly[True  =:= If[False, True,  True,  TBool]]
	implicitly[False =:= If[False, True,  False, TBool]]
	implicitly[True  =:= If[False, False, True,  TBool]]
	implicitly[False =:= If[False, False, False, TBool]]
	
}
