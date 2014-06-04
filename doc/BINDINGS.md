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

Usage: `import io.github.karols.units.scalazSupport._`

Spire
-----

[Spire project page.](https://github.com/non/spire)

Currently, only Spire 0.7.x is supported. For 0.6.x support, see Units 0.1.1.

Artefact `units-spire` provides implementations of following typeclasses:

* for `IntU`: `Module[IntU[U], Long]`

* for `DoubleU`: `VectorSpace[DoubleU[U], Double]`

* for `Vector2U`: `VectorSpace[Vector2U[U], Double]`

* for `Vector3U`: `VectorSpace[Vector3U[U], Double]`

Usage: `import io.github.karols.units.spireSupport._`

Scalacheck
----------

[Scalacheck project page.](https://github.com/rickynils/scalacheck)

Currently, only Scalacheck 1.10.x is supported.

Artefact `units-scalacheck` provides implementations of `Choose[IntU[U]]`, `Choose[DoubleU[U]]`, `Choose[IntA[A]]` and `Choose[DoubleA[A]]`.

Usage: `import io.github.karols.units.scalacheckSupport._`

Joda Time
---------

[Joda Time project page.](http://joda-time.sourceforge.net/)

Currently, only Joda Time 2.1 and above is supported.

Artefact `units-joda` provides implicit conversions from and to `Duration`, `Seconds`, `Minutes`, and `Hours` classes.

Usage: `import io.github.karols.units.jodaSupport._`

Dropped external library support
================================

Algebird
--------

[Algebird project page.](https://github.com/twitter/algebird)

Algebird is not supported in 0.2.x. Units 0.1.1 supports Algebird 0.3.x. If Algebird gets a release for Scala 2.11, the support will be resumed.

Slick
-----

[Slick project page.](http://slick.typesafe.com)

Slick is not supported in 0.2.x. Units 0.1.1 supports Slick 1.0.x. See also: [How to use Slick 2 with Units](SLICK.md).