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

// This file is generated automatically, don't bother modifying.
// Modify generateSystem.scala.py instead.

package io.github.karols.units

import io.github.karols.units._
import io.github.karols.units.internal.Integers._
import io.github.karols.units.internal.Strings._
import io.github.karols.units.internal.UnitImpl._
import io.github.karols.units.internal.SingleUnits._


object System1 {
	sealed trait Sys1
	/**
	Creates a system of units of measurements consisting of 1 unit. `U1` must be a simple unit type.
	*/
	@inline def apply[U1<:TUnitPowerPair, V1<:MUnit](implicit ev1: U1#Power =:= P1) =
		new System1[U1#UnitName,V1](null)
}

/**
Represents a system of units of measurements consisting of 1 unit.
*/

class System1[U1<:TSingleUnit, V1<:MUnit] private[units](val alwaysNull: System1.Sys1) extends AnyVal {
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: DoubleU[U]) = new DoubleU[U#Substitute[U1,V1]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: DoubleU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: DoubleU[U#Substitute[U1,V1]]) = new DoubleU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: IntU[U]) = new IntU[U#Substitute[U1,V1]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: IntU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: IntU[U#Substitute[U1,V1]]) = new IntU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[N,U<:MUnit](x: WithU[N,U]) = new WithU[N,U#Substitute[U1,V1]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[N,U<:MUnit](x: WithU[N,U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[N,U<:MUnit](x: WithU[N,U#Substitute[U1,V1]]) = new WithU[N,U](x.value)

	/** Merges two unit systems. */
	@inline def &[U2<:TSingleUnit, V2<:MUnit](s: System1[U2,V2]) = new System2[U1,V1, U2,V2](null)
	/** Merges two unit systems. */
	@inline def &[U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit](s: System2[U2,V2, U3,V3]) = new System3[U1,V1, U2,V2, U3,V3](null)
	/** Merges two unit systems. */
	@inline def &[U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit](s: System3[U2,V2, U3,V3, U4,V4]) = new System4[U1,V1, U2,V2, U3,V3, U4,V4](null)
	/** Merges two unit systems. */
	@inline def &[U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit](s: System4[U2,V2, U3,V3, U4,V4, U5,V5]) = new System5[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5](null)
	/** Merges two unit systems. */
	@inline def &[U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit](s: System5[U2,V2, U3,V3, U4,V4, U5,V5, U6,V6]) = new System6[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6](null)
	/** Merges two unit systems. */
	@inline def &[U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit](s: System6[U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7]) = new System7[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7](null)
	/** Merges two unit systems. */
	@inline def &[U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit, U8<:TSingleUnit, V8<:MUnit](s: System7[U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7, U8,V8]) = new System8[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7, U8,V8](null)
}


object System2 {
	sealed trait Sys2
	/**
	Creates a system of units of measurements consisting of 2 units. `U1`, `U2` must be simple units.
	*/
	@inline def apply[U1<:TUnitPowerPair, V1<:MUnit, U2<:TUnitPowerPair, V2<:MUnit](implicit ev1: U1#Power =:= P1, ev2: U2#Power =:= P1) = new System2[U1#UnitName,V1, U2#UnitName,V2](null)
}

/**
Represents a system of units of measurements consisting of 2 units.
*/

class System2[U1<:TSingleUnit, V1<:MUnit, U2<:TSingleUnit, V2<:MUnit] private[units](val alwaysNull: System2.Sys2) extends AnyVal {
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: DoubleU[U]) = new DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: DoubleU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]]) = new DoubleU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: IntU[U]) = new IntU[U#Substitute[U1,V1]#Substitute[U2,V2]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: IntU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: IntU[U#Substitute[U1,V1]#Substitute[U2,V2]]) = new IntU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[N,U<:MUnit](x: WithU[N,U]) = new WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[N,U<:MUnit](x: WithU[N,U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[N,U<:MUnit](x: WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]]) = new WithU[N,U](x.value)

	/** Merges two unit systems. */
	@inline def &[U3<:TSingleUnit, V3<:MUnit](s: System1[U3,V3]) = new System3[U1,V1, U2,V2, U3,V3](null)
	/** Merges two unit systems. */
	@inline def &[U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit](s: System2[U3,V3, U4,V4]) = new System4[U1,V1, U2,V2, U3,V3, U4,V4](null)
	/** Merges two unit systems. */
	@inline def &[U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit](s: System3[U3,V3, U4,V4, U5,V5]) = new System5[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5](null)
	/** Merges two unit systems. */
	@inline def &[U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit](s: System4[U3,V3, U4,V4, U5,V5, U6,V6]) = new System6[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6](null)
	/** Merges two unit systems. */
	@inline def &[U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit](s: System5[U3,V3, U4,V4, U5,V5, U6,V6, U7,V7]) = new System7[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7](null)
	/** Merges two unit systems. */
	@inline def &[U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit, U8<:TSingleUnit, V8<:MUnit](s: System6[U3,V3, U4,V4, U5,V5, U6,V6, U7,V7, U8,V8]) = new System8[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7, U8,V8](null)
}


object System3 {
	sealed trait Sys3
	/**
	Creates a system of units of measurements consisting of 3 units. `U1`, `U2`, `U3` must be simple units.
	*/
	@inline def apply[U1<:TUnitPowerPair, V1<:MUnit, U2<:TUnitPowerPair, V2<:MUnit, U3<:TUnitPowerPair, V3<:MUnit](implicit ev1: U1#Power =:= P1, ev2: U2#Power =:= P1, ev3: U3#Power =:= P1) = new System3[U1#UnitName,V1, U2#UnitName,V2, U3#UnitName,V3](null)
}

/**
Represents a system of units of measurements consisting of 3 units.
*/

class System3[U1<:TSingleUnit, V1<:MUnit, U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit] private[units](val alwaysNull: System3.Sys3) extends AnyVal {
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: DoubleU[U]) = new DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: DoubleU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]]) = new DoubleU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: IntU[U]) = new IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: IntU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]]) = new IntU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[N,U<:MUnit](x: WithU[N,U]) = new WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[N,U<:MUnit](x: WithU[N,U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[N,U<:MUnit](x: WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]]) = new WithU[N,U](x.value)

	/** Merges two unit systems. */
	@inline def &[U4<:TSingleUnit, V4<:MUnit](s: System1[U4,V4]) = new System4[U1,V1, U2,V2, U3,V3, U4,V4](null)
	/** Merges two unit systems. */
	@inline def &[U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit](s: System2[U4,V4, U5,V5]) = new System5[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5](null)
	/** Merges two unit systems. */
	@inline def &[U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit](s: System3[U4,V4, U5,V5, U6,V6]) = new System6[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6](null)
	/** Merges two unit systems. */
	@inline def &[U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit](s: System4[U4,V4, U5,V5, U6,V6, U7,V7]) = new System7[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7](null)
	/** Merges two unit systems. */
	@inline def &[U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit, U8<:TSingleUnit, V8<:MUnit](s: System5[U4,V4, U5,V5, U6,V6, U7,V7, U8,V8]) = new System8[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7, U8,V8](null)
}


object System4 {
	sealed trait Sys4
	/**
	Creates a system of units of measurements consisting of 4 units. `U1`, `U2`, `U3`, `U4` must be simple units.
	*/
	@inline def apply[U1<:TUnitPowerPair, V1<:MUnit, U2<:TUnitPowerPair, V2<:MUnit, U3<:TUnitPowerPair, V3<:MUnit, U4<:TUnitPowerPair, V4<:MUnit](implicit ev1: U1#Power =:= P1, ev2: U2#Power =:= P1, ev3: U3#Power =:= P1, ev4: U4#Power =:= P1) = new System4[U1#UnitName,V1, U2#UnitName,V2, U3#UnitName,V3, U4#UnitName,V4](null)
}

/**
Represents a system of units of measurements consisting of 4 units.
*/

class System4[U1<:TSingleUnit, V1<:MUnit, U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit] private[units](val alwaysNull: System4.Sys4) extends AnyVal {
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: DoubleU[U]) = new DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: DoubleU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]]) = new DoubleU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: IntU[U]) = new IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: IntU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]]) = new IntU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[N,U<:MUnit](x: WithU[N,U]) = new WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[N,U<:MUnit](x: WithU[N,U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[N,U<:MUnit](x: WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]]) = new WithU[N,U](x.value)

	/** Merges two unit systems. */
	@inline def &[U5<:TSingleUnit, V5<:MUnit](s: System1[U5,V5]) = new System5[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5](null)
	/** Merges two unit systems. */
	@inline def &[U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit](s: System2[U5,V5, U6,V6]) = new System6[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6](null)
	/** Merges two unit systems. */
	@inline def &[U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit](s: System3[U5,V5, U6,V6, U7,V7]) = new System7[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7](null)
	/** Merges two unit systems. */
	@inline def &[U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit, U8<:TSingleUnit, V8<:MUnit](s: System4[U5,V5, U6,V6, U7,V7, U8,V8]) = new System8[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7, U8,V8](null)
}


object System5 {
	sealed trait Sys5
	/**
	Creates a system of units of measurements consisting of 5 units. `U1`, `U2`, `U3`, `U4`, `U5` must be simple units.
	*/
	@inline def apply[U1<:TUnitPowerPair, V1<:MUnit, U2<:TUnitPowerPair, V2<:MUnit, U3<:TUnitPowerPair, V3<:MUnit, U4<:TUnitPowerPair, V4<:MUnit, U5<:TUnitPowerPair, V5<:MUnit](implicit ev1: U1#Power =:= P1, ev2: U2#Power =:= P1, ev3: U3#Power =:= P1, ev4: U4#Power =:= P1, ev5: U5#Power =:= P1) = new System5[U1#UnitName,V1, U2#UnitName,V2, U3#UnitName,V3, U4#UnitName,V4, U5#UnitName,V5](null)
}

/**
Represents a system of units of measurements consisting of 5 units.
*/

class System5[U1<:TSingleUnit, V1<:MUnit, U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit] private[units](val alwaysNull: System5.Sys5) extends AnyVal {
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: DoubleU[U]) = new DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: DoubleU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]]) = new DoubleU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: IntU[U]) = new IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: IntU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]]) = new IntU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[N,U<:MUnit](x: WithU[N,U]) = new WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[N,U<:MUnit](x: WithU[N,U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[N,U<:MUnit](x: WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]]) = new WithU[N,U](x.value)

	/** Merges two unit systems. */
	@inline def &[U6<:TSingleUnit, V6<:MUnit](s: System1[U6,V6]) = new System6[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6](null)
	/** Merges two unit systems. */
	@inline def &[U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit](s: System2[U6,V6, U7,V7]) = new System7[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7](null)
	/** Merges two unit systems. */
	@inline def &[U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit, U8<:TSingleUnit, V8<:MUnit](s: System3[U6,V6, U7,V7, U8,V8]) = new System8[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7, U8,V8](null)
}


object System6 {
	sealed trait Sys6
	/**
	Creates a system of units of measurements consisting of 6 units. `U1`, `U2`, `U3`, `U4`, `U5`, `U6` must be simple units.
	*/
	@inline def apply[U1<:TUnitPowerPair, V1<:MUnit, U2<:TUnitPowerPair, V2<:MUnit, U3<:TUnitPowerPair, V3<:MUnit, U4<:TUnitPowerPair, V4<:MUnit, U5<:TUnitPowerPair, V5<:MUnit, U6<:TUnitPowerPair, V6<:MUnit](implicit ev1: U1#Power =:= P1, ev2: U2#Power =:= P1, ev3: U3#Power =:= P1, ev4: U4#Power =:= P1, ev5: U5#Power =:= P1, ev6: U6#Power =:= P1) = new System6[U1#UnitName,V1, U2#UnitName,V2, U3#UnitName,V3, U4#UnitName,V4, U5#UnitName,V5, U6#UnitName,V6](null)
}

/**
Represents a system of units of measurements consisting of 6 units.
*/

class System6[U1<:TSingleUnit, V1<:MUnit, U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit] private[units](val alwaysNull: System6.Sys6) extends AnyVal {
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: DoubleU[U]) = new DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: DoubleU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]]) = new DoubleU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: IntU[U]) = new IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: IntU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]]) = new IntU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[N,U<:MUnit](x: WithU[N,U]) = new WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[N,U<:MUnit](x: WithU[N,U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[N,U<:MUnit](x: WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]]) = new WithU[N,U](x.value)

	/** Merges two unit systems. */
	@inline def &[U7<:TSingleUnit, V7<:MUnit](s: System1[U7,V7]) = new System7[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7](null)
	/** Merges two unit systems. */
	@inline def &[U7<:TSingleUnit, V7<:MUnit, U8<:TSingleUnit, V8<:MUnit](s: System2[U7,V7, U8,V8]) = new System8[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7, U8,V8](null)
}


object System7 {
	sealed trait Sys7
	/**
	Creates a system of units of measurements consisting of 7 units. `U1`, `U2`, `U3`, `U4`, `U5`, `U6`, `U7` must be simple units.
	*/
	@inline def apply[U1<:TUnitPowerPair, V1<:MUnit, U2<:TUnitPowerPair, V2<:MUnit, U3<:TUnitPowerPair, V3<:MUnit, U4<:TUnitPowerPair, V4<:MUnit, U5<:TUnitPowerPair, V5<:MUnit, U6<:TUnitPowerPair, V6<:MUnit, U7<:TUnitPowerPair, V7<:MUnit](implicit ev1: U1#Power =:= P1, ev2: U2#Power =:= P1, ev3: U3#Power =:= P1, ev4: U4#Power =:= P1, ev5: U5#Power =:= P1, ev6: U6#Power =:= P1, ev7: U7#Power =:= P1) = new System7[U1#UnitName,V1, U2#UnitName,V2, U3#UnitName,V3, U4#UnitName,V4, U5#UnitName,V5, U6#UnitName,V6, U7#UnitName,V7](null)
}

/**
Represents a system of units of measurements consisting of 7 units.
*/

class System7[U1<:TSingleUnit, V1<:MUnit, U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit] private[units](val alwaysNull: System7.Sys7) extends AnyVal {
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: DoubleU[U]) = new DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: DoubleU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]]) = new DoubleU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: IntU[U]) = new IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: IntU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]]) = new IntU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[N,U<:MUnit](x: WithU[N,U]) = new WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[N,U<:MUnit](x: WithU[N,U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[N,U<:MUnit](x: WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]]) = new WithU[N,U](x.value)

	/** Merges two unit systems. */
	@inline def &[U8<:TSingleUnit, V8<:MUnit](s: System1[U8,V8]) = new System8[U1,V1, U2,V2, U3,V3, U4,V4, U5,V5, U6,V6, U7,V7, U8,V8](null)
}


object System8 {
	sealed trait Sys8
	/**
	Creates a system of units of measurements consisting of 8 units. `U1`, `U2`, `U3`, `U4`, `U5`, `U6`, `U7`, `U8` must be simple units.
	*/
	@inline def apply[U1<:TUnitPowerPair, V1<:MUnit, U2<:TUnitPowerPair, V2<:MUnit, U3<:TUnitPowerPair, V3<:MUnit, U4<:TUnitPowerPair, V4<:MUnit, U5<:TUnitPowerPair, V5<:MUnit, U6<:TUnitPowerPair, V6<:MUnit, U7<:TUnitPowerPair, V7<:MUnit, U8<:TUnitPowerPair, V8<:MUnit](implicit ev1: U1#Power =:= P1, ev2: U2#Power =:= P1, ev3: U3#Power =:= P1, ev4: U4#Power =:= P1, ev5: U5#Power =:= P1, ev6: U6#Power =:= P1, ev7: U7#Power =:= P1, ev8: U8#Power =:= P1) = new System8[U1#UnitName,V1, U2#UnitName,V2, U3#UnitName,V3, U4#UnitName,V4, U5#UnitName,V5, U6#UnitName,V6, U7#UnitName,V7, U8#UnitName,V8](null)
}

/**
Represents a system of units of measurements consisting of 8 units.
*/

class System8[U1<:TSingleUnit, V1<:MUnit, U2<:TSingleUnit, V2<:MUnit, U3<:TSingleUnit, V3<:MUnit, U4<:TSingleUnit, V4<:MUnit, U5<:TSingleUnit, V5<:MUnit, U6<:TSingleUnit, V6<:MUnit, U7<:TSingleUnit, V7<:MUnit, U8<:TSingleUnit, V8<:MUnit] private[units](val alwaysNull: System8.Sys8) extends AnyVal {
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: DoubleU[U]) = new DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]#Substitute[U8,V8]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: DoubleU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: DoubleU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]#Substitute[U8,V8]]) = new DoubleU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: IntU[U]) = new IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]#Substitute[U8,V8]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: IntU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: IntU[U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]#Substitute[U8,V8]]) = new IntU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[N,U<:MUnit](x: WithU[N,U]) = new WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]#Substitute[U8,V8]](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[N,U<:MUnit](x: WithU[N,U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[N,U<:MUnit](x: WithU[N,U#Substitute[U1,V1]#Substitute[U2,V2]#Substitute[U3,V3]#Substitute[U4,V4]#Substitute[U5,V5]#Substitute[U6,V6]#Substitute[U7,V7]#Substitute[U8,V8]]) = new WithU[N,U](x.value)

}


/**/