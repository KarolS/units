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

object Vector2AArray {
	/** Creates an array of given elements */
	def apply[A<:AffineSpace](elems: Vector2A[A]*) = {
		val a = new Array[Double](elems.length * 2)
		(0 until elems.length).foreach{ i =>
			a(i*2)   = elems(i).x.value
			a(i*2+1) = elems(i).y.value
		}
		new Vector2AArray[A](a)
	}

	/** Concatenates all arrays into a single array. */
	def concat[A<:AffineSpace](arrays: Vector2AArray[A]*) = 
		new Vector2AArray(
			Array.concat(arrays.map{_.underlying}: _*))

	/** Copy one array to another. */
	def copy[A<:AffineSpace](
		src: Vector2AArray[A], srcPos: Int, 
		dest: Vector2AArray[A], destPos: Int, 
		length: Int) {
		Array.copy(src.underlying, srcPos*2, dest.underlying, destPos*2, length*2)
	}

	/** Returns an array of length 0. */
	def empty[A<:AffineSpace] = new Vector2AArray[A](Array.empty[Double])

	/** Returns an array that contains the results of some element computation a number of times. */
	def fill[A<:AffineSpace](n: Int)(elem: =>Vector2A[A]) = {
		val a = new Array[Double](n * 2)
		(0 until n).foreach{ i =>
			val e = elem
			a(i*2)   = e.x.value
			a(i*2+1) = e.y.value
		}
		new Vector2AArray(a)
	}

	/** Returns an array that contains a constant element a number of times. */
	def fillUniform[A<:AffineSpace](n: Int)(elem: Vector2A[A]) = {
		val x = elem.x.value
		val y = elem.y.value
		val a = new Array[Double](n*2)
		var i = 0
		(0 until n).foreach{ i =>
			a(i*2)     = x
			a(i*2 + 1) = y
		}
		new Vector2AArray(a)
	}
	
	def unapplySeq[A<:AffineSpace](arr: Vector2AArray[A]) = Some(arr)

	def at[A<:AffineSpace](values: (Double, Double)*) = apply(values.map(_.at[A]):_*)

	//TODO: more
}

class Vector2AArrayBuilder[A<:AffineSpace] extends Builder[Vector2A[A], Vector2AArray[A]] {
	val underlying = new ArrayBuilder.ofDouble

	def +=(elem: Vector2A[A]) = {
		underlying += elem.x.value
		underlying += elem.y.value
		this
	}
	def clear() = {
		underlying.clear
	}
	def result() = new Vector2AArray[A](underlying.result())
}

/** Mutable fixed-size array of unboxed `Vector2A`. */
final class Vector2AArray[A<:AffineSpace] private[arrays] (
	private[arrays] val underlying: Array[Double]
	) 
	extends IndexedSeq[Vector2A[A]] 
	with ArrayLike[Vector2A[A], Vector2AArray[A]]{

	def this(length: Int) {
		this(new Array[Double](2*length))
	}

	override val length = underlying.length/2
	override def stringPrefix = "Vector2AArray"
	override def newBuilder = new Vector2AArrayBuilder[A]

	def apply(index: Int) = 
		new Vector2A[A](underlying(index*2).at, underlying(index*2+1).at)

	def update(index: Int, elem: Vector2A[A]) {
		underlying(index*2) = elem.x.value
		underlying(index*2+1) = elem.y.value
	}

	def unzip = (xs, ys)
	
	def xs = {
		val array = new Array[Double](length)
		(0 until length) foreach { i =>
			array(i) = underlying(i*2)
		}
		new DoubleAArray[A](array)
	}
	
	def ys = {
		val array = new Array[Double](length)
		(0 until length) foreach { i =>
			array(i) = underlying(i*2 + 1)
		}
		new DoubleAArray[A](array)
	}

	def x(index: Int) = underlying(2*index).at[A]

	def y(index: Int) = underlying(2*index + 1).at[A]
	
}