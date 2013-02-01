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

object ValuesWithUnits {
	import language.higherKinds
	import language.implicitConversions
	import language.existentials
	import Bools._
	import Integers._
	import Strings._
	import SingleUnits._
	import UnitImpl._
	import Conversions._
	import scala.math

	class IntU[U<:MUnit](val value:Long) extends AnyVal {
		@inline
		def mkString(implicit name: UnitName[U]) = value.toString + name.toString
		@inline
		override def toString = value.toString
		@inline
		def toDouble = new DoubleU[U](value)
		
		@inline
		def +(i: IntU[U]) = new IntU[U](value+i.value)
		@inline
		def -(i: IntU[U]) = new IntU[U](value-i.value)
		@inline
		def +(i: DoubleU[U]) = new DoubleU[U](value+i.value)
		@inline
		def -(i: DoubleU[U]) = new DoubleU[U](value-i.value)
		
		@inline
		def *[V<:MUnit](i: IntU[V]) = new IntU[U#Mul[V]](value*i.value)
		@inline
		def *[V<:MUnit](i: DoubleU[V]) = new DoubleU[U#Mul[V]](value*i.value)
		
		@inline
		def /[V<:MUnit](i: IntU[V]) = new DoubleU[U#Mul[V#Invert]](value.toDouble/i.value)
		@inline
		def /[V<:MUnit](i: DoubleU[V]) = new DoubleU[U#Mul[V#Invert]](value/i.value)
		
		@inline
		def convertToInt[V<:MUnit](implicit ev:IntRatio[U,V]) = 
			new IntU[V](value * ev.ratio)
		
		@inline
		def convert[V<:MUnit](implicit ev:DoubleRatio[U,V]) = 
			new DoubleU[V](value * ev.ratio)
		
		@inline
		def represent[V<:MUnit,W<:MUnit](implicit ev:DoubleRatio[V,W]) = 
			new DoubleU[U#Mul[V#Invert]#Mul[W]](value * ev.ratio)
		 
		@inline
		def representAll[V<:TUnitPowerPair, W<:MUnit](
			implicit ev: PowerDoubleRatio[V#UnitName,V#Power,W,U#Get[V#UnitName]]
			) = new DoubleU[U#Mul[(V#UnitName^(U#Get[V#UnitName]))#Invert]#Mul[W#ToPower[U#Get[V#UnitName]]]](value * ev.ratio)

		@inline
		def <(i: IntU[U]) = value < i.value
		@inline
		def <=(i: IntU[U]) = value <= i.value
		@inline
		def >(i: IntU[U]) = value > i.value
		@inline
		def >=(i: IntU[U]) = value >= i.value
		@inline
		def <(i: DoubleU[U]) = value < i.value
		@inline
		def <=(i: DoubleU[U]) = value <= i.value
		@inline
		def >(i: DoubleU[U]) = value > i.value
		@inline
		def >=(i: DoubleU[U]) = value >= i.value

		@inline
		def <~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio < i.value
		@inline
		def <=~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio <= i.value
		@inline
		def >~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio > i.value
		@inline
		def >=~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio >= i.value
		@inline
		def <~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio < i.value
		@inline
		def <=~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio <= i.value
		@inline
		def >~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio > i.value
		@inline
		def >=~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio >= i.value

		@inline
		def ==(i: IntU[U]) = value == i.value
		@inline
		def ==~[V<:MUnit, W<:MUnit](i: IntU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
			value*l.ratio == i.value*r.ratio
		@inline
		def !=(i: IntU[U]) = value != i.value
		@inline
		def !=~[V<:MUnit, W<:MUnit](i: IntU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
			value*l.ratio != i.value*r.ratio

		@inline
		def +[V<:MUnit, W<:MUnit](i: IntU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
			new IntU[W](value*l.ratio + i.value*r.ratio)
		@inline
		def -[V<:MUnit, W<:MUnit](i: IntU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
			new IntU[W](value*l.ratio - i.value*r.ratio)
		@inline
		def +[V<:MUnit, W<:MUnit](i: DoubleU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
			new DoubleU[W](value*l.ratio.toDouble + i.value*r.ratio.toDouble)
		@inline
		def -[V<:MUnit, W<:MUnit](i: DoubleU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
			new DoubleU[W](value*l.ratio.toDouble - i.value*r.ratio.toDouble)

		@inline
		def pow2 = this*this
		@inline
		def pow3 = this*this*this
		@inline
		def sqrt = new DoubleU[U#Sqrt](math.sqrt(value.toDouble))
		@inline
		def cbrt = new DoubleU[U#Cbrt](math.cbrt(value.toDouble))
	}
	class DoubleU[U<:MUnit](val value:Double) extends AnyVal {
		@inline
		def mkString(implicit name: UnitName[U]) = value.toString + name.toString
		@inline
		override def toString = value.toString
		
		@inline
		def +(i: IntU[U]) = new DoubleU[U](value+i.value)
		@inline
		def -(i: IntU[U]) = new DoubleU[U](value-i.value)
		@inline
		def +(i: DoubleU[U]) = new DoubleU[U](value+i.value)
		@inline
		def -(i: DoubleU[U]) = new DoubleU[U](value-i.value)

		@inline
		def *[V<:MUnit](i: IntU[V]) = new DoubleU[U#Mul[V]](value*i.value)
		@inline
		def *[V<:MUnit](i: DoubleU[V]) = new DoubleU[U#Mul[V]](value*i.value)
		
		@inline
		def /[V<:MUnit](i: IntU[V]) = new DoubleU[U#Mul[V#Invert]](value.toDouble/i.value)
		@inline
		def /[V<:MUnit](i: DoubleU[V]) = new DoubleU[U#Mul[V#Invert]](value/i.value)
		
		@inline
		def convert[V<:MUnit](implicit ev:DoubleRatio[U,V]) = new DoubleU[V](value * ev.ratio)
		
		@inline
		def represent[V<:MUnit,W<:MUnit](implicit ev:DoubleRatio[V,W]) = 
			new DoubleU[U#Mul[V#Invert]#Mul[W]](value * ev.ratio)
		 
		@inline
		def representAll[V<:TUnitPowerPair, W<:MUnit](
			implicit ev: PowerDoubleRatio[V#UnitName,V#Power,W,U#Get[V#UnitName]]
			) = new DoubleU[U#Mul[(V#UnitName^(U#Get[V#UnitName]))#Invert]#Mul[W#ToPower[U#Get[V#UnitName]]]](value * ev.ratio)

		@inline
		def <(i: IntU[U]) = value < i.value
		@inline
		def <=(i: IntU[U]) = value <= i.value
		@inline
		def >(i: IntU[U]) = value > i.value
		@inline
		def >=(i: IntU[U]) = value >= i.value
		@inline
		def <(i: DoubleU[U]) = value < i.value
		@inline
		def <=(i: DoubleU[U]) = value <= i.value
		@inline
		def >(i: DoubleU[U]) = value > i.value
		@inline
		def >=(i: DoubleU[U]) = value >= i.value

		@inline
		def <~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio < i.value
		@inline
		def <=~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio <= i.value
		@inline
		def >~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio > i.value
		@inline
		def >=~[V<:MUnit](i: IntU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio >= i.value
		@inline
		def <~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio < i.value
		@inline
		def <=~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio <= i.value
		@inline
		def >~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio > i.value
		@inline
		def >=~[V<:MUnit](i: DoubleU[V])(implicit ev:DoubleRatio[U,V]) = value*ev.ratio >= i.value

		@inline
		def +[V<:MUnit, W<:MUnit](i: IntU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
			new DoubleU[W](value*l.ratio.toDouble + i.value*r.ratio.toDouble)
		@inline
		def -[V<:MUnit, W<:MUnit](i: IntU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
			new DoubleU[W](value*l.ratio.toDouble - i.value*r.ratio.toDouble)
		@inline
		def +[V<:MUnit, W<:MUnit](i: DoubleU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
			new DoubleU[W](value*l.ratio.toDouble + i.value*r.ratio.toDouble)
		@inline
		def -[V<:MUnit, W<:MUnit](i: DoubleU[V])(implicit l: LeftIntRatio[U,V,W], r: RightIntRatio[U,V,W]) = 
			new DoubleU[W](value*l.ratio.toDouble - i.value*r.ratio.toDouble)

		@inline
		def pow2 = this*this
		@inline
		def pow3 = this*this*this
		@inline
		def sqrt = new DoubleU[U#Sqrt](math.sqrt(value))
		@inline
		def cbrt = new DoubleU[U#Cbrt](math.cbrt(value))
	}
	

}