Compiling
=========

To compile the code, run `sbt` and execute:

	compile

To package into JARs:

	package

To run the benchmarks:

	benchmark

To run the unit tests:

	test

To benchmark and package for Scala 2.11.0-M3:

	+ benchmark
	+ package

Unit tests do not work on Scala 2.11.0-M3 yet. The reason is mispackaging of Scalatest in repositories. It will be fixed soon after a stable version of Scala 2.11 is released.
	
To test and build all the integration packages:

	project units-all
	test
	package

None of the integration packages works with Scala 2.11 yet.