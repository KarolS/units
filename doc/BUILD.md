Compiling
=========

To build `units` 0.1.x, you need sbt 0.12.x.

To compile the code, run `sbt` and execute:

	compile

To package into JARs:

	package

To run the benchmarks:

	benchmark

To run the unit tests:

	test

To benchmark and package for Scala 2.11.0-M3:

	project units-211
	benchmark
	package

Unit tests do not work on Scala 2.11.0-M3 yet. The reason is mispackaging of Scalatest in repositories. It will be fixed soon after a stable version of Scala 2.11 is released.

None of the integration packages works with Scala 2.11 yet.