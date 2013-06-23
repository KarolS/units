TODO:
=====

For 0.1:

* **move everything from `stasiak.karol.units` package to `units`**

* add 2D and 3D affine spaces

* add more units of measure

* add more [Scalaz](https://github.com/scalaz/scalaz), [Scalacheck](https://github.com/rickynils/scalacheck), [Spire](https://github.com/non/spire), [Joda Time](http://joda-time.sourceforge.net/), [Algebird](https://github.com/twitter/algebird) integration

* clean up `Module` implementations for `IntU`

* make `units-all` project generate no artefacts

* provide full Scala 2.11 support

* rearrange `TChar`s, so that lexical sorting of unit names yields natural-looking compound units

* write more tests

* write more benchmarks

* write more documentation

---

For 0.2 and beyond:

* definitely provide Scala 2.11 support

* improve explicit polymorphism

* optimize compilation times

* test Proguard compatibility

* optionally: add [Breeze](https://github.com/dlwh/breeze), [Saddle](https://github.com/saddle/saddle), [Shapeless](https://github.com/milessabin/shapeless), [Slick](https://github.com/slick/slick) and [Squeryl](https://github.com/max-l/Squeryl) integration

* optionally: add runtime dynamic units

* optionally: make the library more IDE-friendly

* and finally: add more new features
