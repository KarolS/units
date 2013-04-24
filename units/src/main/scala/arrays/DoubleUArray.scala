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
package stasiak.karol.units.arrays

import stasiak.karol.units._
import scala.collection.mutable._

object DoubleUArray {
	def apply[U<:MUnit](elems: DoubleU[U]*) = new DoubleUArray[U](elems.map{_.value}.toArray)

	def concat[U<:MUnit](arrays: DoubleUArray[U]*) = 
		new DoubleUArray(Array.concat(arrays.map{_.underlying}: _*))

	def copy[U<:MUnit](
		src: DoubleUArray[U], srcPos: Int, 
		dest: DoubleUArray[U], destPos: Int, 
		length: Int) {
		Array.copy(src.underlying, srcPos, dest.underlying, destPos, length)
	}

	def empty[U<:MUnit] = new DoubleUArray[U](Array.empty[Double])

	def fill[U<:MUnit](n: Int)(elem: =>DoubleU[U]) = {
		new DoubleUArray(Array.fill(n)(elem.value))
	}
	
	def unapplySeq[U<:MUnit](arr: DoubleUArray[U]) = Some(arr)

	//TODO: more
}
class DoubleUArrayBuilder[U<:MUnit] extends Builder[DoubleU[U], DoubleUArray[U]] {
	val underlying = new ArrayBuilder.ofDouble

	def +=(elem: DoubleU[U]) = {
		underlying += elem.value
		this
	}
	def clear() = underlying.clear
	def result() = new DoubleUArray[U](underlying.result())
}
/** Mutable fixed-size array of unboxed `DoubleU`. */
final class DoubleUArray[U<:MUnit] private[arrays] (private[arrays] val underlying: Array[Double]) 
	extends IndexedSeq[DoubleU[U]] 
	with ArrayLike[DoubleU[U], DoubleUArray[U]]{

	def this(length: Int) {
		this(new Array[Double](length))
	}

	override val length = underlying.length
	override def stringPrefix = "DoubleUArray"
	override def newBuilder = new DoubleUArrayBuilder[U]

	def apply(index: Int) = underlying(index).of[U]

	def update(index: Int, elem: DoubleU[U]) {
		underlying(index) = elem.value
	}
	
}