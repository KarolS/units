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

object Vector2UArray {
	def apply[U<:MUnit](elems: Vector2U[U]*) = {
		val u = new Array[Double](elems.length * 2)
		(0 until elems.length).foreach{ i =>
			u(i*2)   = elems(i).x.value
			u(i*2+1) = elems(i).y.value
		}
		new Vector2UArray[U](u)
	}

	def concat[U<:MUnit](arrays: Vector2UArray[U]*) = 
		new Vector2UArray(
			Array.concat(arrays.map{_.underlying}: _*))

	def copy[U<:MUnit](
		src: Vector2UArray[U], srcPos: Int, 
		dest: Vector2UArray[U], destPos: Int, 
		length: Int) {
		Array.copy(src.underlying, srcPos*2, dest.underlying, destPos*2, length*2)
	}

	def empty[U<:MUnit] = new Vector2UArray[U](Array.empty[Double])

	def fill[U<:MUnit](n: Int)(elem: =>Vector2U[U]) = {
		val u = new Array[Double](n * 2)
		(0 until n).foreach{ i =>
			val e = elem
			u(i*2)   = e.x.value
			u(i*2+1) = e.y.value
		}
		new Vector2UArray(u)
	}
	
	def unapplySeq[U<:MUnit](arr: Vector2UArray[U]) = Some(arr)

	def of[U<:MUnit](values: (Double, Double)*) = apply(values.map(_.of[U]):_*)

	//TODO: more
}
class Vector2UArrayBuilder[U<:MUnit] extends Builder[Vector2U[U], Vector2UArray[U]] {
	val underlying = new ArrayBuilder.ofDouble
	val underlyingY = new ArrayBuilder.ofDouble

	def +=(elem: Vector2U[U]) = {
		underlying += elem.x.value
		underlying += elem.y.value
		this
	}
	def clear() = {
		underlying.clear
	}
	def result() = new Vector2UArray[U](underlying.result())
}
/** Mutable fixed-size array of unboxed `Vector2U`. */
final class Vector2UArray[U<:MUnit] private[arrays] (
	private[arrays] val underlying: Array[Double]
	) 
	extends IndexedSeq[Vector2U[U]] 
	with ArrayLike[Vector2U[U], Vector2UArray[U]]{

	def this(length: Int) {
		this(new Array[Double](2*length))
	}

	override val length = underlying.length/2
	override def stringPrefix = "Vector2UArray"
	override def newBuilder = new Vector2UArrayBuilder[U]

	def apply(index: Int) = 
		new Vector2U[U](underlying(index*2).of, underlying(index*2+1).of)

	def update(index: Int, elem: Vector2U[U]) {
		underlying(index*2) = elem.x.value
		underlying(index*2+1) = elem.y.value
	}
	
}