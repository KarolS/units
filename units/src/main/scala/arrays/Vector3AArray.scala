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

object Vector3AArray {
	/** Creates an array of given elements */
	def apply[A<:AffineSpace](elems: Vector3A[A]*) = {
		val u = new Array[Double](elems.length * 3)
		(0 until elems.length).foreach{ i =>
			u(i*3)   = elems(i).x.value
			u(i*3+1) = elems(i).y.value
			u(i*3+2) = elems(i).z.value
		}
		new Vector3AArray[A](u)
	}

	/** Concatenates all arrays into a single array. */
	def concat[A<:AffineSpace](arrays: Vector3AArray[A]*) = 
		new Vector3AArray(Array.concat(arrays.map{_.underlying}: _*))

	/** Copy one array to another. */
	def copy[A<:AffineSpace](
		src: Vector3AArray[A], srcPos: Int, 
		dest: Vector3AArray[A], destPos: Int, 
		length: Int) {
		Array.copy(src.underlying, srcPos*3, dest.underlying, destPos*3, length*3)
	}

	/** Returns an array of length 0. */
	def empty[A<:AffineSpace] = new Vector3AArray[A](Array.empty[Double])

	/** Returns an array that contains the results of some element computation a number of times. */
	def fill[A<:AffineSpace](n: Int)(elem: =>Vector3A[A]) = {
		val u = new Array[Double](n * 3)
		(0 until n).foreach{ i =>
			val e = elem
			u(i*3)   = e.x.value
			u(i*3+1) = e.y.value
			u(i*3+2) = e.z.value
		}
		new Vector3AArray(u)
	}

	/** Returns an array that contains a constant element a number of times. */
	def fillUniform[A<:AffineSpace](n: Int)(elem: Vector3A[A]) = {
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
		new Vector3AArray(u)
	}
	
	def unapplySeq[A<:AffineSpace](arr: Vector3AArray[A]) = Some(arr)

	def at[A<:AffineSpace](values: (Double, Double, Double)*) = apply(values.map(_.at[A]):_*)

	//TODO: more
}

class Vector3AArrayBuilder[A<:AffineSpace] extends Builder[Vector3A[A], Vector3AArray[A]] {
	val underlying = new ArrayBuilder.ofDouble

	def +=(elem: Vector3A[A]) = {
		underlying += elem.x.value
		underlying += elem.y.value
		underlying += elem.z.value
		this
	}
	def clear() = {
		underlying.clear
	}
	def result() = new Vector3AArray[A](underlying.result())
}

/** Mutable fixed-size array of unboxed `Vector3A`. */
final class Vector3AArray[A<:AffineSpace] private[arrays] (
	private[arrays] val underlying: Array[Double]
	) 
	extends IndexedSeq[Vector3A[A]] 
	with ArrayLike[Vector3A[A], Vector3AArray[A]]{

	def this(length: Int) {
		this(new Array[Double](length*3))
	}

	override val length = underlying.length/3
	override def stringPrefix = "Vector3AArray"
	override def newBuilder = new Vector3AArrayBuilder[A]

	def apply(index: Int) = 
		new Vector3A[A](
			underlying(index*3  ).at, 
			underlying(index*3+1).at, 
			underlying(index*3+2).at)

	def update(index: Int, elem: Vector3A[A]) {
		underlying(index*3)   = elem.x.value
		underlying(index*3+1) = elem.y.value
		underlying(index*3+2) = elem.z.value
	}
	
	def unzip = (xs, ys, zs)
	
	def xs = {
		val array = new Array[Double](length)
		(0 until length) foreach { i =>
			array(i) = underlying(i*3)
		}
		new DoubleAArray[A](array)
	}
	
	def ys = {
		val array = new Array[Double](length)
		(0 until length) foreach { i =>
			array(i) = underlying(i*3 + 1)
		}
		new DoubleAArray[A](array)
	}
	
	def zs = {
		val array = new Array[Double](length)
		(0 until length) foreach { i =>
			array(i) = underlying(i*3 + 2)
		}
		new DoubleAArray[A](array)
	}

	def x(index: Int) = underlying(3*index).at[A]

	def y(index: Int) = underlying(3*index + 1).at[A]
	
	def z(index: Int) = underlying(3*index + 2).at[A]

}