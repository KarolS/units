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

package stasiak.units

import org.scalatest._
import stasiak.units.slick1Support._
import SI._
import USCustomary._
import scala.slick.driver.H2Driver.simple._
import Database.threadLocalSession

class Slick1SupportSuite extends FunSuite with BeforeAndAfterAll {

	var db = Database.forURL("jdbc:h2:mem:test1", driver = "org.h2.Driver")

	override def beforeAll(){
		//Database.forURL("jdbc:h2:mem:test1", driver = "org.h2.Driver")
	}
	override def afterAll(){
		//db.close()
	}

	case class Thing(name: String, length: DoubleU[metre])
	object Things extends Table[Thing]("THINGS") {
		def name = column[String]("COF_NAME", O.PrimaryKey)
		def length = column[DoubleU[metre]]("LENGTH")
		def * = name ~ length <> (Thing, Thing.unapply _)
	}

	test("Creating table should work") {
		db withSession {
			Things.ddl.create
		}
	}

	test("Inserting should work") {
		db withSession {
			Things.ddl.create
			Things.insert(Thing("1-metre pole", 1.0.of[metre]))
		}
	}

	test("Retrieving should work") {
		db withSession {
			Things.ddl.create
			Things.insert(Thing("Marathon", 42000.0.of[metre]))
			Things.insert(Thing("Not a marathon", 0.0.of[metre]))
			val l: List[DoubleU[metre]] = (
				for(t<-Things if t.name === "Marathon") yield t.length
			).list
			assert(l.length === 1)
			assert(l === List(42.0.kilo[metre]))
		}
	}
}