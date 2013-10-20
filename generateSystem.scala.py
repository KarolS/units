#!/usr/bin/env python

F = None

def output(line):
	global F
	F.write(line)
	F.write("\n")
	print line

MAX_SYSTEM_SIZE = 8
# any size bigger than 8 hangs the compiler

def without_commas(size, pattern):
	return "".join([pattern.replace('$', str(i+1)) for i in range(size)])
def with_commas(size, pattern):
	return ", ".join([pattern.replace('$', str(i+1)) for i in range(size)])
def with_commas_partial(f,to,pattern):
	return ", ".join([pattern.replace('$', str(i)) for i in range(f, to+1)])

def generate_system(size):
	sz = str(size)
	if size==1:
		output('''object System1 {
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
''')
	else:
		output('object System'+sz+' {')
		output('	sealed trait Sys'+sz)
		output('''	/**
	Creates a system of units of measurements consisting of '''+
		str(size)+''' units. '''+with_commas(size,'`U$`')+''' must be simple units.
	*/
	@inline def apply['''+
		with_commas(size,'U$<:TUnitPowerPair, V$<:MUnit')+'](implicit ' +
		with_commas(size, 'ev$: U$#Power =:= P1')+ ') = new System'+sz+'['+
		with_commas(size,'U$#UnitName,V$')+'''](null)
}

/**
Represents a system of units of measurements consisting of '''+sz+''' units.
*/
''')
	#endif
	output('class System'+sz+'['+with_commas(size,'U$<:TSingleUnit, V$<:MUnit')+
		'] private[units](val alwaysNull: System'+sz+'.Sys'+sz+''') extends AnyVal {
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: DoubleU[U]) = new DoubleU[U'''+
	without_commas(size,'#Substitute[U$,V$]')+'''](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: DoubleU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: DoubleU[U'''+
	without_commas(size,'#Substitute[U$,V$]')+''']) = new DoubleU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[U<:MUnit](x: IntU[U]) = new IntU[U'''+
	without_commas(size,'#Substitute[U$,V$]')+'''](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[U<:MUnit](x: IntU[U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[U<:MUnit](x: IntU[U'''+
	without_commas(size,'#Substitute[U$,V$]')+''']) = new IntU[U](x.value)

	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def map[N,U<:MUnit](x: WithU[N,U]) = new WithU[N,U'''+
	without_commas(size,'#Substitute[U$,V$]')+'''](x.value)
	/** Converts a polymorphic value to a value in this system of measurements. */
	@inline def unapply[N,U<:MUnit](x: WithU[N,U]) = Some(map(x))
	/** Converts a value in this system of measurements to a polymorphic value. Has to be called with a type parameter. */
	@inline def apply[N,U<:MUnit](x: WithU[N,U'''+
	without_commas(size,'#Substitute[U$,V$]')+''']) = new WithU[N,U](x.value)
''')
	for sum in range(size+1, MAX_SYSTEM_SIZE+1):
		diff = sum - size
		sm = str(sum)
		df = str(diff)
		output('''	/** Merges two unit systems. */
	@inline def &['''+with_commas_partial(size+1, sum, 'U$<:TSingleUnit, V$<:MUnit')+
	'](s: System'+df+'['+with_commas_partial(size+1, sum, 'U$,V$')+
	']) = new System'+sm+'['+with_commas(sum, 'U$,V$')+'](null)')
	output('}\n\n')



if(__name__=='__main__'):
	F = open("units/src/main/scala/System.scala", "w")
	output('''/*
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

// This file is generated automatically, don't bother modifying.
// Modify generateSystem.scala.py instead.

package stasiak.karol.units

import stasiak.karol.units._
import stasiak.karol.units.internal.Integers._
import stasiak.karol.units.internal.Strings._
import stasiak.karol.units.internal.UnitImpl._
import stasiak.karol.units.internal.SingleUnits._

''')

	for size in range(MAX_SYSTEM_SIZE):
		generate_system(size+1)
	F.write("/**/")
	F.close()