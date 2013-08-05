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

object IntUArray {
	/** Creates an array of given elements */
	def apply[U<:MUnit](elems: IntU[U]*) = new IntUArray[U](elems.map{_.value}.toArray)

	/** Concatenates all arrays into a single array. */
	def concat[U<:MUnit](arrays: IntUArray[U]*) = 
		new IntUArray[U](Array.concat(arrays.map{_.underlying}: _*))

	/** Copy one array to another. */
	def copy[U<:MUnit](
		src: IntUArray[U], srcPos: Int, 
		dest: IntUArray[U], destPos: Int, 
		length: Int) {
		Array.copy(src.underlying, srcPos, dest.underlying, destPos, length)
	}

	/** Returns an array of length 0. */
	def empty[U<:MUnit] = new IntUArray[U](Array.empty[Long])

	/** Returns an array that contains the results of some element computation a number of times. */
	def fill[U<:MUnit](n: Int)(elem: =>IntU[U]) = {
		new IntUArray(Array.fill(n)(elem.value))
	}

	/** Returns an array that contains a constant element a number of times. */
	def fillUniform[U<:MUnit](n: Int)(elem: IntU[U]) = {
		val elemValue = elem.value
		new IntUArray(Array.fill(n)(elemValue))
	}
	
	def unapplySeq[U<:MUnit](arr: IntUArray[U]) = Some(arr)
	
	//TODO: more
}
class IntUArrayBuilder[U<:MUnit] extends Builder[IntU[U], IntUArray[U]] {
	val underlying = new ArrayBuilder.ofLong

	def +=(elem: IntU[U]) = {
		underlying += elem.value
		this
	}
	def clear() = underlying.clear
	def result() = new IntUArray[U](underlying.result())
}
/** Mutable fixed-size array of unboxed `IntU`. */
final class IntUArray[U<:MUnit] private[arrays] (private[arrays] val underlying: Array[Long]) 
	extends IndexedSeq[IntU[U]] 
	with ArrayLike[IntU[U], IntUArray[U]]{

	def this(length: Int) {
		this(new Array[Long](length))
	}

	override val length = underlying.length
	override def stringPrefix = "IntUArray"
	override def newBuilder = new IntUArrayBuilder[U]

	def apply(index: Int) = underlying(index).of[U]

	def update(index: Int, elem: IntU[U]) {
		underlying(index) = elem.value
	}
	
}