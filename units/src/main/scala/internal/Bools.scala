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
package stasiak.units.internal

object Bools {
	import language.higherKinds
	sealed trait TBool {
		type DoIf[IfTrue<:ResultType, IfFalse<:ResultType, ResultType] <: ResultType
		type DoIf2[IfTrue<:ResultType, IfFalse<:ResultType, ResultType] <: ResultType
		type And[X<:TBool]<:TBool
		type Or[X<:TBool]<:TBool
		type Not<:TBool
	}
	sealed trait True extends TBool {
		type DoIf[IfTrue<:ResultType, IfFalse<:ResultType, ResultType] = IfTrue
		type DoIf2[IfTrue<:ResultType, IfFalse<:ResultType, ResultType] = IfTrue
		type And[X<:TBool] = X
		type Or[X<:TBool] = True
		type Not = False
	}
	sealed trait False extends TBool{
		type DoIf[IfTrue<:ResultType, IfFalse<:ResultType, ResultType] = IfFalse
		type DoIf2[IfTrue<:ResultType, IfFalse<:ResultType, ResultType] = IfFalse
		type And[X<:TBool] = False
		type Or[X<:TBool] = X
		type Not = True
	}
	type If[B<:TBool,T<:R,F<:R,R] = B#DoIf[T,F,R]
	type &&[A<:TBool,B<:TBool] = A#And[B]
	type ||[A<:TBool,B<:TBool] = A#Or[B]
	class BoolName[B<:TBool](w:String){
		override def toString = w
	}
	implicit val trueName = new BoolName[True]("true")
	implicit val falseName = new BoolName[False]("false")
}