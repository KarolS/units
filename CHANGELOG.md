units - CHANGELOG
=================

version 0.0.6
-------------

* General: Added 2D and 3D vectors in affine spaces (`Vector2A`, `Vector3A`, `Vector2AArray` and `Vector3AArray`).

* General: Moved Scala 2.11 build to a separate subproject, `units-211`.

* General: More Scaladoc.

* Testing: More tests.

* Testing: Moved most of the tests to another package.

* FIXED: The `concat` method of array companion object.

* FIXED: The `fillUniform` method of vector array companion object.

version 0.0.5
-------------

* Units: Added 34 new currencies.

* FIXED: Errors in Scaladoc for vectors.

* FIXED: `Vector2U.apply`.

version 0.0.4
-------------

* General: Added few more array methods.

* General: Added a kind of support for Scala 2.11.0-M3. Currently, unit tests don't work on Scala 2.11, but benchmarks do.

* General: Reorganised internal classes.

* Constants: Added 5 new physical constants.

* Algebird integration: Added various typeclass instances for DoubleU, IntU, Vector2U and Vector3U.

* Testing: Added more type arithmetic tests.

version 0.0.3
-------------

* General: Added 2D and 3D vectors and vector arrays.

* General: Allowed to compare Double(U/A) for equality.

* Units: Added conversions between binary prefixes for bytes.

* Dependencies: Loosened dependencies.

* ScalaZ integration: Added various typeclass instances for vectors.

* Spire integration: Added various typeclass instances for vectors.

* Testing: Added more type arithmetic tests.

* FIXED: Some minor problems with unit arithmetics.

version 0.0.2
-------------

* General: Optimized type-level character implementation.

* General: Added utility methods for arrays.

* General: Flattened the package hierarchy.

* General: Added explicit polymorphism support.

* General: Added more documentation.

* Units: Added all remaining conversions between information units with decimal prefixes.

* Scalaz integration: Added various typeclass instances for (Double/Int)(U/A).

* Spire integration: Added VectorSpace instances for Double(U/A) and Module instances for Int(U/A).

* Scalacheck integration: Added Choose instances for (Double/Int)(U/A).

* Joda Time integration: Added implicit conversions for Duration.

* Testing: Added 2 simple benchmarks.

* FIXED: Compilation and code completion no longer hang during LeftIntRatio/RightIntRatio implicit search, which makes the library usable in Eclipse.

version 0.0.1
-------------

* Initial release.