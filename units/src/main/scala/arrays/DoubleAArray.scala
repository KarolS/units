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

object DoubleAArray {
	/** Creates an array of given elements */
	def apply[A<:AffineSpace](elems: DoubleA[A]*) = new DoubleAArray[A](elems.map{_.value}.toArray)

	/** Concatenates all arrays into a single array. */
	def concat[A<:AffineSpace](arrays: DoubleAArray[A]*) = 
		new DoubleAArray(Array.concat(arrays.map{_.underlying}: _*))

	/** Copy one array to another. */
	def copy[A<:AffineSpace](
		src: DoubleAArray[A], srcPos: Int, 
		dest: DoubleAArray[A], destPos: Int, 
		length: Int) {
		Array.copy(src.underlying, srcPos, dest.underlying, destPos, length)
	}

	/** Returns an array of length 0. */
	def empty[A<:AffineSpace] = new DoubleAArray[A](Array.empty[Double])

	/** Returns an array that contains the results of some element computation a number of times. */
	def fill[A<:AffineSpace](n: Int)(elem: =>DoubleA[A]) = {
		new DoubleAArray(Array.fill(n)(elem.value))
	}

	/** Returns an array that contains a constant element a number of times. */
	def fillUniform[A<:AffineSpace](n: Int)(elem: DoubleA[A]) = {
		val elemValue = elem.value
		new DoubleAArray(Array.fill(n)(elemValue))
	}
	
	def unapplySeq[A<:AffineSpace](arr: DoubleAArray[A]) = Some(arr)
	
	//TODO: more
}
class DoubleAArrayBuilder[A<:AffineSpace] extends Builder[DoubleA[A], DoubleAArray[A]] {
	val underlying = new ArrayBuilder.ofDouble

	def +=(elem: DoubleA[A]) = {
		underlying += elem.value
		this
	}
	def clear() = underlying.clear
	def result() = new DoubleAArray[A](underlying.result())
}
/** Mutable fixed-size array of unboxed `DoubleA`. */
final class DoubleAArray[A<:AffineSpace] private[arrays] (private[arrays] val underlying: Array[Double]) 
	extends IndexedSeq[DoubleA[A]] 
	with ArrayLike[DoubleA[A], DoubleAArray[A]]{

	def this(length: Int) {
		this(new Array[Double](length))
	}

	override val length = underlying.length
	override def stringPrefix = "DoubleAArray"
	override def newBuilder = new DoubleAArrayBuilder[A]

	def apply(index: Int) = underlying(index).at[A]

	def update(index: Int, elem: DoubleA[A]) {
		underlying(index) = elem.value
	}
	
}