Using arrays
============

Sadly, Scala 2.10's arrays of value classes are boxed. As an alternative, `stasiak.karol.units.arrays` package provides classes `DoubleUArray[U]`, `DoubleAArray[A]`, `IntUArray[U]`, and `IntAArray[A]`.

All of them implement `IndexedSeq` and can be used like standard collection classes:

	val arr = DoubleUArray[metre](1.of, 2.of, 5.5.of)
	val DoubleUArray(a,b,c) = arr
	// a = 1 m, b = 2 m, c = 5.5 m
	arr.head          // 1 m
	arr(1)            // 2 m
	arr(2) = 9.of     // arr(2) is no longer 5.5 m, now it's 9 m

You can create a new array in several ways:

* directly, with `new` operator: `new DoubleUArray[metre](256)`

* using `fill` method: `DoubleUArray.fill(256)(1.78.of[metre])`

* using `apply` method: `DoubleUArray[metre](1.78.of, 1.80.of, 1.82.of)`

Other methods are not yet supported.