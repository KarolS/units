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

package io.github.karols.units.benchmarks

import com.google.caliper.SimpleBenchmark
import io.github.karols.units._
import io.github.karols.units.SI._
import io.github.karols.units.arrays._

class IntUArrayApplyBenchmark extends SimpleBenchmark {

	val array = new Array[Long](1000)
	val arrayW = new IntUArray[metre](1000);

	override def setUp (){}
	override def tearDown(){}

	def timeRaw(reps: Int) = {
		var result = 0L
		for(x<-0 until reps){
			var i = 0
			while (i < 1000) {
				array(i) = i*i
				i += 1
			}
			i = 0
			while (i < 1000) {
				result += array(i)
				i += 1
			}
			i = 0
			while (i < 1000) {
				array(i) = i*i
				i += 1
			}
			i = 0
			while (i < 1000) {
				result += array(i)
				i += 1
			}
		}
		result
	}
	
	def timeWithUnits(reps: Int) = {
		var result = 0L.of[metre]
		for(x<-0 until reps){
			var i = 0
			while (i < 1000) {
				arrayW(i) = (i*i).of[metre]
				i += 1
			}
			i = 0
			while (i < 1000) {
				result += arrayW(i)
				i += 1
			}
			i = 0
			while (i < 1000) {
				arrayW(i) = (i*i).of[metre]
				i += 1
			}
			i = 0
			while (i < 1000) {
				result += arrayW(i)
				i += 1
			}
		}
		result.value
	}

}