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

import com.google.caliper.SimpleBenchmark
import stasiak.karol.units._
import stasiak.karol.units.SI._
import stasiak.karol.units.arrays._

class DoubleAArrayForeachBenchmark extends SimpleBenchmark {

	val array = new Array[Double](1000)
	val arrayW = new DoubleAArray[CelsiusScale](1000);

	override def setUp (){
		var i = 0
		while (i<1000) {
			array(i) = i*i
			arrayW(i) = (i*i).at[CelsiusScale]
			i += 1
		}
	}

	override def tearDown(){}

	def timeRaw(reps: Int) = {
		var result = 0.0
		val zero = 0.0
		for(x<-0 until 2*reps){
			array.foreach {
				result += _ - zero
			}
		}
		result
	}
	
	def timeWithUnits(reps: Int) = {
		var result = 0.0.at[CelsiusScale]
		val zero = 0.0.at[CelsiusScale]
		for(x<-0 until 2*reps){
			arrayW.foreach {
				result += _ -- zero
			}
		}
		result.value
	}

}