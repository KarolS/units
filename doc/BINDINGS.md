External library support
========================

Scalaz
------

[Scalaz project page.](https://github.com/scalaz/scalaz)

Currently, only Scalaz 7.0.x is supported.

Artefact `units-scalaz` provides implementations of following typeclasses:

* for `IntU`: `Monoid`, `Equal`, `Order`, `Show`

* for `DoubleU`: `Monoid`, `Equal`, `Order`, `Show`

* for `IntA`: `Order`, `Equal`, `Show`

* for `DoubleA`: `Order`, `Equal`, `Show`

* for `Vector2U`: `Monoid`, `Equal`, `Show`

* for `Vector3U`: `Monoid`, `Equal`, `Show`

* for `Vector2A`: `Equal`, `Show`

* for `Vector3A`: `Equal`, `Show`

Usage: `import stasiak.karol.units.scalazSupport._`

Spire
-----

[Spire project page.](https://github.com/non/spire)

Currently, only Spire 0.3.x is supported.

Artefact `units-spire` provides implementations of following typeclasses:

* for `IntU`: `Module[IntU[U], Int]`, `Module[IntU[U], Long]`

* for `DoubleU`: `VectorSpace[DoubleU[U], Double]`

* for `Vector2U`: `VectorSpace[Vector2U[U], Double]`

* for `Vector3U`: `VectorSpace[Vector3U[U], Double]`

Usage: `import stasiak.karol.units.spireSupport._`

Scalacheck
----------

[Scalacheck project page.](https://github.com/rickynils/scalacheck)

Currently, only Scalacheck 1.10.x is supported.

Artefact `units-scalacheck` provides implementations of `Choose[IntU[U]]`, `Choose[DoubleU[U]]`, `Choose[IntA[A]]` and `Choose[DoubleA[A]]`.

Usage: `import stasiak.karol.units.scalacheckSupport._`

Joda Time
---------

[Joda Time project page.](http://joda-time.sourceforge.net/)

Currently, only Joda Time 2.1 and above is supported.

Artefact `units-joda` provides implicit conversions from and to `Duration`, `Seconds`, `Minutes`, and `Hours` classes.

Usage: `import stasiak.karol.units.jodaSupport._`

Algebird
--------

[Algebird project page.](https://github.com/twitter/algebird)

Currently, only Algebird 0.1.13 is supported.

Artefact `units-algebird` provides implementations of `Monoid`, `Group` and `VectorSpace` for `IntU`, `DoubleU`, `Vector2U` and `Vector3U` (except for `VectorSpace` for `IntU`).

Usage: `import stasiak.karol.units.algebirdSupport._`

Slick
-----

[Slick project page.](http://slick.typesafe.com)

Currently, only Slick 1.0.x is supported. Support for Slick 2.0 will follow after its stable release.

Artefact `units-slick` provides implementations of column mappings for `IntU`, `IntA`, `DoubleU` and `DoubleA`.

Usage: `import stasiak.karol.units.slick1Support`

Saddle
------

[Saddle project page.](https://github.com/saddle/saddle)

Support is planned in the future.

Breeze
------

[Breeze project page.](https://github.com/dlwh/breeze)

Support is planned in the future.