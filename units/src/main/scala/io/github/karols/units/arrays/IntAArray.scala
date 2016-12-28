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
package io.github.karols.units.arrays

import io.github.karols.units._
import scala.collection.mutable._

object IntAArray {
	/** Creates an array of given elements */
	def apply[A<:AffineSpace](elems: IntA[A]*) = new IntAArray[A](elems.map{_.value}.toArray)

	def at[A<:AffineSpace](elems: Long*) = new IntAArray[A](Array[Long](elems:_*))

	/** Concatenates all arrays into a single array. */
	def concat[A<:AffineSpace](arrays: IntAArray[A]*) =
		new IntAArray[A](Array.concat(arrays.map{_.underlying}: _*))

	/** Copy one array to another. */
	def copy[A<:AffineSpace](
		src: IntAArray[A], srcPos: Int,
		dest: IntAArray[A], destPos: Int,
		length: Int) {
		Array.copy(src.underlying, srcPos, dest.underlying, destPos, length)
	}

	/** Returns an array of length 0. */
	def empty[A<:AffineSpace] = new IntAArray[A](Array.empty[Long])

	/** Returns an array that contains the results of some element computation a number of times. */
	def fill[A<:AffineSpace](n: Int)(elem: =>IntA[A]) = {
		new IntAArray(Array.fill(n)(elem.value))
	}
	
	/** Returns an array that contains a constant element a number of times. */
	def fillUniform[A<:AffineSpace](n: Int)(elem: IntA[A]) = {
		val elemValue = elem.value
		new IntAArray(Array.fill(n)(elemValue))
	}

	def unapplySeq[A<:AffineSpace](arr: IntAArray[A]) = Some(arr)

	//TODO: more
}
class IntAArrayBuilder[A<:AffineSpace] extends Builder[IntA[A], IntAArray[A]] {
	val underlying = new ArrayBuilder.ofLong

	def +=(elem: IntA[A]) = {
		underlying += elem.value
		this
	}
	def clear() = underlying.clear
	def result() = new IntAArray[A](underlying.result())
}
/** Mutable fixed-size array of unboxed [[io.github.karols.units.IntA]]. */
final class IntAArray[A<:AffineSpace] private[arrays] (private[arrays] val underlying: Array[Long])
	extends IndexedSeq[IntA[A]]
	with ArrayLike[IntA[A], IntAArray[A]]{

	def this(length: Int) {
		this(new Array[Long](length))
	}

	override val length = underlying.length
	override def stringPrefix = "IntAArray"
	override def newBuilder = new IntAArrayBuilder[A]

	def apply(index: Int) = underlying(index).at[A]

	def update(index: Int, elem: IntA[A]) {
		underlying(index) = elem.value
	}
	
	/** The average of all values in the array */
	def avg = DoubleA[A](underlying.sum.toDouble / length)

}