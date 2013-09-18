Rationale
=========

This library is a result of my experiments with Scala's type system.

The goal I was aiming for when working on this library was to provide units of measurement with following properties:

* values with units are unboxed (possible thanks to Scala 2.10's custom value classes)

* units can be defined by user (as opposed to implementations limiting users to seven base SI units)

* all unit checking should be done on compile time (as opposed to runtime)

* not a compiler plugin or a macro (although I may add some macro-powered syntactic sugar in the future)

* proper support for affine spaces

* easy conversion between units

Why not any other implementation?
---------------------------------

All of the following implementations were either inefficient or inflexible:

* [units (compiler plugin)](https://lampsvn.epfl.ch/trac/scala/browser/compiler-plugins/units/trunk)

    * Both outdated and a compiler plugin.

* [Metascala Units](http://trac.assembla.com/metascala/browser/src/metascala/Units.scala)

* [scalax-units](https://github.com/soc/scalax-units)

* [ScalaQuantity](https://github.com/zzorn/ScalaQuantity)

    * All three above are limited to 7 SI units only, and since they were made before 2.10, values are boxed. They were the direct inspiration for this library.

* [axle.quanta](https://github.com/adampingel/axle/tree/master/core/src/main/scala/axle/quanta)

    * Allows for adding new units, but all unit checking is performed at runtime, causing a significant runtime overhead.

* [scalau](https://github.com/adrianfr/scalau)

    * A source code preprocessor. Converts all units to SI. Does not support arbitrary unit expressions, for example metre to the fourth power would be an invalid unit.
