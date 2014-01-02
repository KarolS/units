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

package io.github.karols.units

import org.scalacheck._
import language.implicitConversions

package object scalacheckSupport {
	implicit def implicit__intU[U<:MUnit] = new Choose[IntU[U]] {
	    def choose(low: IntU[U], high: IntU[U]) =
	    	Choose.chooseLong.choose(low.value, high.value).map(_.of[U])
  	}
	implicit def implicit__intA[A<:AffineSpace] = new Choose[IntA[A]] {
	    def choose(low: IntA[A], high: IntA[A]) =
	    	Choose.chooseLong.choose(low.value, high.value).map(_.at[A])
  	}
	implicit def implicit__doubleU[U<:MUnit] = new Choose[DoubleU[U]] {
	    def choose(low: DoubleU[U], high: DoubleU[U]) =
	    	Choose.chooseDouble.choose(low.value, high.value).map(_.of[U])
  	}
	implicit def implicit__doubleA[A<:AffineSpace] = new Choose[DoubleA[A]] {
	    def choose(low: DoubleA[A], high: DoubleA[A]) =
	    	Choose.chooseDouble.choose(low.value, high.value).map(_.at[A])
  	}
}
