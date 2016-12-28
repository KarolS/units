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

object Vector3UArray {
	/** Creates an array of given elements */
	def apply[U<:MUnit](elems: Vector3U[U]*) = {
		val u = new Array[Double](elems.length * 3)
		(0 until elems.length).foreach{ i =>
			u(i*3)   = elems(i).x.value
			u(i*3+1) = elems(i).y.value
			u(i*3+2) = elems(i).z.value
		}
		new Vector3UArray[U](u)
	}

	/** Concatenates all arrays into a single array. */
	def concat[U<:MUnit](arrays: Vector3UArray[U]*) =
		new Vector3UArray(Array.concat(arrays.map{_.underlying}: _*))

	/** Copy one array to another. */
	def copy[U<:MUnit](
		src: Vector3UArray[U], srcPos: Int,
		dest: Vector3UArray[U], destPos: Int,
		length: Int) {
		Array.copy(src.underlying, srcPos*3, dest.underlying, destPos*3, length*3)
	}

	/** Returns an array of length 0. */
	def empty[U<:MUnit] = new Vector3UArray[U](Array.empty[Double])

	/** Returns an array that contains the results of some element computation a number of times. */
	def fill[U<:MUnit](n: Int)(elem: =>Vector3U[U]) = {
		val u = new Array[Double](n * 3)
		(0 until n).foreach{ i =>
			val e = elem
			u(i*3)   = e.x.value
			u(i*3+1) = e.y.value
			u(i*3+2) = e.z.value
		}
		new Vector3UArray(u)
	}

	/** Returns an array that contains a constant element a number of times. */
	def fillUniform[U<:MUnit](n: Int)(elem: Vector3U[U]) = {
		val x = elem.x.value
		val y = elem.y.value
		val z = elem.z.value
		val u = new Array[Double](n*3)
		var i = 0
		(0 until n).foreach{ i =>
			u(i*3)     = x
			u(i*3 + 1) = y
			u(i*3 + 2) = z
		}
		new Vector3UArray(u)
	}
	
	def unapplySeq[U<:MUnit](arr: Vector3UArray[U]) = Some(arr)

	def of[U<:MUnit](values: (Double, Double, Double)*) = apply(values.map(_.of[U]):_*)

	//TODO: more
}
class Vector3UArrayBuilder[U<:MUnit] extends Builder[Vector3U[U], Vector3UArray[U]] {
	val underlying = new ArrayBuilder.ofDouble

	def +=(elem: Vector3U[U]) = {
		underlying += elem.x.value
		underlying += elem.y.value
		underlying += elem.z.value
		this
	}
	def clear() = {
		underlying.clear
	}
	def result() = new Vector3UArray[U](underlying.result())
}
/** Mutable fixed-size array of unboxed [[io.github.karols.units.Vector3U]]. */
final class Vector3UArray[U<:MUnit] private[arrays] (
	private[arrays] val underlying: Array[Double]
	)
	extends IndexedSeq[Vector3U[U]]
	with ArrayLike[Vector3U[U], Vector3UArray[U]]{

	def this(length: Int) {
		this(new Array[Double](length*3))
	}

	override val length = underlying.length/3
	override def stringPrefix = "Vector3UArray"
	override def newBuilder = new Vector3UArrayBuilder[U]

	def apply(index: Int) =
		new Vector3U[U](
			underlying(index*3  ).of,
			underlying(index*3+1).of,
			underlying(index*3+2).of)

	def update(index: Int, elem: Vector3U[U]) {
		underlying(index*3)   = elem.x.value
		underlying(index*3+1) = elem.y.value
		underlying(index*3+2) = elem.z.value
	}
	
	/** Returns separate arrays for each coordinate. */
	def unzip = (xs, ys, zs)
	
	/** Returns an array of values of the X coordinate. */
	def xs = {
		val array = new Array[Double](length)
		(0 until length) foreach { i =>
			array(i) = underlying(i*3)
		}
		new DoubleUArray[U](array)
	}
	
	/** Returns an array of values of the Y coordinate. */
	def ys = {
		val array = new Array[Double](length)
		(0 until length) foreach { i =>
			array(i) = underlying(i*3 + 1)
		}
		new DoubleUArray[U](array)
	}
	
	/** Returns an array of values of the Z coordinate. */
	def zs = {
		val array = new Array[Double](length)
		(0 until length) foreach { i =>
			array(i) = underlying(i*3 + 2)
		}
		new DoubleUArray[U](array)
	}

	/** Returns the value of the X coordinate of given element. */
	def x(index: Int) = underlying(3*index).of[U]

	/** Returns the value of the Y coordinate of given element. */
	def y(index: Int) = underlying(3*index + 1).of[U]

	/** Returns the value of the Z coordinate of given element. */
	def z(index: Int) = underlying(3*index + 2).of[U]

	/** The sum of all values in the array */
	def sum = {
		var sx = 0.0
		var sy = 0.0
		var sz = 0.0
		var i = 0
		var l = length
		while(i < l){
			sx += underlying(3*i)
			sy += underlying(3*i + 1)
			sz += underlying(3*i + 2)
			i += 1
		}
		Vector3U[U](sx.of, sy.of, sz.of)
	}

}