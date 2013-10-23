units - CHANGELOG
=================

version 0.0.9
-------------

* General: Increased maximum unit system size from 7 to 8.

* General: Added support for `WithU` in systems.

* General: Changed semantics of `BaseIntRatio.<>` and `BaseDoubleRatio.<>`.

* Units: Added 13 new US Customary and Imperial units.

* Testing: More unit tests.

* Spire: removed `Module[IntU[U],Int]` implementation (`Module[IntU[U],Long]` is still available)

version 0.0.8
-------------

* General: Added support for arbitrary underlying numeric types with `WithU` and `WithA`.

* Units: Added 8 new units and multiple new conversions.

* Units: Added 33 new currencies.

* Slick integration: Added column converters for `(Double/Int)(U/A)`.

* FIXED: Parameters for `Vector2A.at`

* FIXED: Few minor documentation fixes.

version 0.0.7
-------------

* General: Two-way affine space conversions.

* General: More methods for scalar array companion objects: `of`, `at`.

* General: More methods for arrays: `avg`, `sum`, `x`, `y`, `z`.

* General: Added more Scaladoc; fixed some errors in documentation.

* Units: Conversions between bits and bytes with binary prefixes.

* Units: Added 2 more units.

* Testing: More unit tests.

* Testing: More benchmarks.

* Scalaz integration: Added typeclass instances for `Vector2A` and `Vector3A`

* FIXED: Equality comparisons between IntA and DoubleA.

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

* Algebird integration: Added various typeclass instances for `DoubleU`, `IntU`, `Vector2U` and `Vector3U`.

* Testing: Added more type arithmetic tests.

version 0.0.3
-------------

* General: Added 2D and 3D vectors and vector arrays.

* General: Allowed to compare `Double(U/A)` for equality.

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

* Scalaz integration: Added various typeclass instances for `(Double/Int)(U/A)`.

* Spire integration: Added `VectorSpace` instances for `Double(U/A)` and `Module` instances for `Int(U/A)`.

* Scalacheck integration: Added `Choose` instances for `(Double/Int)(U/A)`.

* Joda Time integration: Added implicit conversions for `Duration`.

* Testing: Added 2 simple benchmarks.

* FIXED: Compilation and code completion no longer hang during `LeftIntRatio`/`RightIntRatio` implicit search, which makes the library usable in Eclipse.

version 0.0.1
-------------

* Initial release.