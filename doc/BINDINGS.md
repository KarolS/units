External library support
========================

Scalaz
------

[Scalaz project page.](https://github.com/scalaz/scalaz)

Currently, only ScalaZ 7.0.0-M9 is supported.

Artefact `units-scalaz` provides implementation of following typeclasses:

* for IntU: Monoid, Equal, Order, Show

* for DoubleU: Monoid, Order, Show

Usage: `import stasiak.karol.units.scalazSupport._`

Spire
-----

[Spire project page.](https://github.com/non/spire)

Currently, only Spire 0.3.0 is supported.

Artefact `units-spire` provides implementation of following typeclasses:

* for IntU: Module[IntU[U], Int], Module[IntU[U], Long]

* for DoubleU: VectorSpace[DoubleU[U], Double]

Usage: `import stasiak.karol.units.spireSupport._`

Scalacheck
----------

[Scalacheck project page.](https://github.com/rickynils/scalacheck)

Currently, only Scalacheck 1.10.1 is supported.

Artefact `units-scalacheck` provides implementations of Choose[IntU[U]], Choose[DoubleU[U]], Choose[IntA[A]] and Choose[DoubleA[A]].

Usage: `import stasiak.karol.units.scalacheckSupport._`

Joda Time
---------

[Joda Time project page.](http://joda-time.sourceforge.net/)

Currently, only Joda Time 2.2 is supported.

Artefact `units-joda` provides implicit conversions from and to `Duration`, `Seconds`, `Minutes`, and `Hours` classes.

Usage: `import stasiak.karol.units.jodaSupport._`

Saddle
------

[Saddle project page.](https://github.com/saddle/saddle)

Support is planned in the future.

Breeze
------

[Breeze project page.](https://github.com/dlwh/breeze)

Support is planned in the future.