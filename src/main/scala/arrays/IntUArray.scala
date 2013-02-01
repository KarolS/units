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

import stasiak.karol.units.Units._
import scala.collection.mutable._

object IntUArray {
	def apply[U<:MUnit](elems: IntU[U]*) = new IntUArray[U](elems.map{_.value}.toArray)
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
final class IntUArray[U<:MUnit] private[arrays] (underlying: Array[Long]) 
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