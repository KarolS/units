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
package io.github.karols.units.internal.ratios
import io.github.karols.units._

class BaseDoubleRatio[U<:MUnit, V<:MUnit](val ratio: Double) extends AnyVal {

	/**
	Converts a ratio between U and V into ratio between U×Y and V×Y
	*/
	@inline
	def times[Y<:MUnit] =
		new BaseDoubleRatio[U#Mul[Y],V#Mul[Y]](ratio)

	/**
	Converts a ratio between U and V into ratio between U/Y and V/Y
	*/
	@inline
	def dividedBy[Y<:MUnit] =
		new BaseDoubleRatio[U#Mul[Y#Invert],V#Mul[Y#Invert]](ratio)

	/**
	Converts a ratio between U and V into ratio between Y/U and Y/V
	*/
	@inline
	def dividing[Y<:MUnit] =
		new BaseDoubleRatio[Y#Mul[U#Invert],Y#Mul[V#Invert]](1.0/ratio)

	/**
	Converts a ratio between U and V into ratio between 1/U and 1/V
	*/
	@inline
	def invert = new BaseDoubleRatio[V,U](1.0/ratio)

	/**
	Converts a ratio between U and V into ratio between U^2 and V^2
	*/
	@inline
	def pow2 = this * this

	/**
	Converts a ratio between U and V into ratio between U^3 and V^3
	*/
	@inline
	def pow3 = this * this * this

	/**
	Converts a ratio between U and V into ratio between U^4 and V^4
	*/
	@inline
	def pow4 = this * this * this * this

	/**
	Converts a ratio between U and V into ratio between U^5 and V^5
	*/
	@inline
	def pow5 = this * this * this * this * this

	/**
		Converts ratios between U and V and between X and Y into ratio between U×X and V×Y
	*/
	@inline
	def *[X<:MUnit, Y<:MUnit](that: BaseDoubleRatio[X,Y]) =
		new BaseDoubleRatio[U#Mul[X],V#Mul[Y]](ratio*that.ratio)

	/**
		Converts ratios between U and V and between X and Y into ratio between U×X and V×Y
	*/
	@inline
	def *[X<:MUnit, Y<:MUnit](that: BaseIntRatio[X,Y]) =
		new BaseDoubleRatio[U#Mul[X],V#Mul[Y]](ratio*that.ratio)

	/**
		Converts ratios between U and V and between X and Y into ratio between U×X and V×Y
	*/
	@inline
	def /[X<:MUnit, Y<:MUnit](that: BaseIntRatio[X,Y]) =
		new BaseDoubleRatio[U#Mul[X#Invert],V#Mul[Y#Invert]](ratio/that.ratio)

	/**
		Converts ratios between U and V and between X and Y into ratio between U×X and V×Y
	*/
	@inline
	def /[X<:MUnit, Y<:MUnit](that: BaseDoubleRatio[X,Y]) =
		new BaseDoubleRatio[U#Mul[X#Invert],V#Mul[Y#Invert]](ratio/that.ratio)

	/**
		Converts ratios between U and V and between Y and V into ratio between U and Y
	*/
	@inline
	def ><[Y<:MUnit](that: BaseDoubleRatio[Y,V]) = new BaseDoubleRatio[U,Y](ratio/that.ratio)

	/**
		Converts ratios between U and V and between Y and V into ratio between U and Y
	*/
	@inline
	def ><[Y<:MUnit](that: BaseIntRatio[Y,V]) = new BaseDoubleRatio[U,Y](ratio/that.ratio)

	/**
		Converts ratios between U and V and between Y and V into ratio between U and Y
	*/
	@inline
	def <>[Y<:MUnit](that: BaseDoubleRatio[U,Y]) = new BaseDoubleRatio[V,Y](that.ratio/ratio)

	/**
		Converts ratios between U and V and between Y and V into ratio between U and Y
	*/
	@inline
	def <>[Y<:MUnit](that: BaseIntRatio[U,Y]) = new BaseDoubleRatio[V,Y](that.ratio/ratio)

	/**
		Converts ratios between U and V and between V and Y into ratio between U and Y
	*/
	@inline
	def >>[Y<:MUnit](that: BaseDoubleRatio[V,Y]) = new BaseDoubleRatio[U,Y](ratio*that.ratio)

	/**
		Converts ratios between U and V and between V and Y into ratio between U and Y
	*/
	@inline
	def >>[Y<:MUnit](that: BaseIntRatio[V,Y]) = new BaseDoubleRatio[U,Y](ratio*that.ratio)
}
