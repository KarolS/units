package io.github.karols.units

import sbt._
import Keys._
import sbt.Defaults._

object UnitsBuild extends Build {


	val VERSION = "0.2-SNAPSHOT"


	type Sett = Project.Setting[_]

	// settings common for all projects

	lazy val baseSettings: Seq[Sett] =
		Defaults.defaultSettings ++ /*ScoverageSbtPlugin.instrumentSettings ++ */Seq[Sett](
	    organization := "io.github.karols",
	    version := VERSION,
	    scalaVersion := "2.10.3",
	    crossScalaVersions := Seq("2.10.3"),
	    publishMavenStyle := true,
	    pomIncludeRepository := {
	      x => false
	    },
	    licenses := Seq("MIT License" -> url("http://opensource.org/licenses/MIT")),
	    homepage := Some(url("http://www.github.com/KarolS/units")),
	    pomExtra := (
	        <scm>
	          <url>git@github.com:KarolS/units.git</url>
	          <connection>scm:git:git@github.com:KarolS/units.git</connection>
	        </scm>
	        <developers>
	          <developer>
	            <id>KarolS</id>
	            <name>Karol Stasiak</name>
	            <email>karol.m.stasiak+units@gmail.com</email>
	            <url>http://karols.github.io</url>
	          </developer>
	        </developers>
	    )
    )

	lazy val benchmarkSettings = baseSettings ++ Seq[Sett](
			libraryDependencies ++= Seq(SCALATEST_TEST, CALIPER_TEST),
			benchmarks := {
				val base = (scalaSource in Test).value
				(sources in Test).value.map {
					IO.relativize(base, _).get.replace(java.io.File.separator,".").replace(".scala", "")
				}.filter(_.endsWith("Benchmark"))
			},
			benchmark := benchmarkTaskInitTask.value(benchmarks.value),
			benchmarkOnly := benchmarkTaskInitTask.value( Def.spaceDelimited("<arg>").parsed )
		)

	// dependencies

	lazy val SCALACHECK = "org.scalacheck" %% "scalacheck" % "[1.10.0,1.11)"

	lazy val SCALAZ = "org.scalaz" %% "scalaz-core" % "[7.0.0,7.1)"

	lazy val SPIRE = "org.spire-math" %% "spire" % "[0.6,0.7)"

	lazy val ALGEBIRD = "com.twitter" %% "algebird-core" % "[0.3.0,0.4)"

	lazy val SLICK = "com.typesafe.slick" %% "slick" % "[1.0.0,1.1)"

	lazy val JODA_TIME = "joda-time" % "joda-time" % "[2.1,3)"

	lazy val JODA_CONVERT = "org.joda" % "joda-convert" % "1.2" % "provided"

	lazy val SCALATEST_TEST = "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

	lazy val CALIPER_TEST = "com.google.caliper" % "caliper" % "0.5-rc1" % "test"

	lazy val H2_TEST = "com.h2database" % "h2" % "1.3.173" % "test"

	lazy val SLF4J_TEST = "org.slf4j" % "slf4j-nop" % "1.6.4"

    // project definitions

	lazy val __units: Project = Project(
		id  = "units",
		base = file("units"),
		settings = benchmarkSettings ++ Seq[Sett](
			name := "units"
		)
	) aggregate(
		scalazIntegration,
		scalacheckIntegration,
		spireIntegration,
		jodaTimeIntegration,
		algebirdIntegration,
		slick1Integration
	)

	// lazy val __units11: Project = Project(
	// 	id  = "units-211",
	// 	base = file("units"),
	// 	settings = benchmarkSettings ++ Seq[Sett](
	// 		name := "units-211"
	// 	)
	// )

	lazy val scalazIntegration: Project = Project(
		id = "units-scalaz",
		base = file("units-scalaz"),
		settings = baseSettings ++ Seq[Sett](
			name := "units-scalaz",
			libraryDependencies ++= Seq(SCALAZ, SCALATEST_TEST)
		),
		dependencies = Seq(__units)
	)

	lazy val spireIntegration: Project = Project(
		id = "units-spire",
		base = file("units-spire"),
		settings = baseSettings ++ Seq[Sett](
			name := "units-spire",
			libraryDependencies ++= Seq(SPIRE, SCALATEST_TEST)
		),
		dependencies = Seq(__units)
	)

	lazy val scalacheckIntegration: Project = Project(
		id = "units-scalacheck",
		base = file("units-scalacheck"),
		settings = baseSettings ++ Seq[Sett](
			name := "units-scalacheck",
			libraryDependencies ++= Seq(SCALACHECK, SCALATEST_TEST)
		),
		dependencies = Seq(__units)
	)

	lazy val jodaTimeIntegration: Project = Project(
		id = "units-joda",
		base = file("units-joda"),
		settings = baseSettings ++ Seq[Sett](
			name := "units-joda",
			libraryDependencies ++= Seq(JODA_TIME, JODA_CONVERT, SCALATEST_TEST)
		),
		dependencies = Seq(__units)
	)

	lazy val algebirdIntegration: Project = Project(
		id = "units-algebird",
		base = file("units-algebird"),
		settings = baseSettings ++ Seq[Sett](
			name := "units-algebird",
			libraryDependencies ++= Seq(ALGEBIRD, SCALATEST_TEST)
		),
		dependencies = Seq(__units)
	)

	lazy val slick1Integration: Project = Project(
		id = "units-slick",
		base = file("units-slick"),
		settings = baseSettings ++ Seq[Sett](
			name := "units-slick",
			libraryDependencies ++= Seq(SLICK, SCALATEST_TEST, H2_TEST, SLF4J_TEST)
		),
		dependencies = Seq(__units)
	)

	val benchmark = TaskKey[Unit]("benchmark", "Executes all benchmarks.")
	val benchmarkOnly = InputKey[Unit]("benchmark-only", "Executes specified benchmarks.")
	val benchmarks = TaskKey[Seq[String]]("benchmarks",
		"Seq of class names to benchmark. By default all class names are based on items in the Test classpath with names that end with 'Benchmark'")

	private[this] def forkOptions: Def.Initialize[Task[ForkOptions]] =
		(fullClasspath in Test, baseDirectory, javaOptions, outputStrategy, envVars, javaHome, connectInput) map {
			(tcp, base, options, strategy, env, javaHomeDir, connectIn) =>
				// bootJars is empty by default because only jars on the user's classpath should be on the boot classpath
				val cp = "-classpath" :: Path.makeString(tcp.files) :: Nil
				ForkOptions(
					bootJars = Nil,
					javaHome = javaHomeDir,
					connectInput = connectIn,
					outputStrategy = strategy,
					runJVMOptions = options ++ cp,
					workingDirectory = Some(base),
					envVars = env)
		}

	private def benchmarkTaskInitTask: Def.Initialize[Task[Seq[String] => Unit]] = Def.task {
		val cpa = (fullClasspath in Test).value
		val forkOpts = forkOptions.value
		val out = streams.value
		val fr = new ForkRun(forkOpts)
		// val opts = (caliperOptions in cappi).value
		({ benchmarks: Seq[String] =>
			if (benchmarks.isEmpty) println("No benchmarks specified - nothing to run")
			else benchmarks.map( b =>
				sbt.toError(fr.run("com.google.caliper.Runner",
					Attributed.data(cpa), Seq(b), out.log)))
		})
	}

	// val benchmark = TaskKey[Unit]("benchmark", "Executes all benchmarks.")
	// val benchmarkOnly = InputKey[Unit]("benchmark-only", "Executes specified benchmarks.")

	// protected def benchmarkTaskInit: Project.Initialize[Task[Seq[String] => Unit]] = (
	// 	fullClasspath in Test, scalaInstance, javaHome, javaOptions, baseDirectory, outputStrategy, streams
	// ) map {
	// 	(cpa, si, jhome, jopts, dir, strategy, s) =>
	// 	// cpa.files foreach (println(_))
	// 	val cp = "-classpath" :: Path.makeString(cpa.files) :: Nil
	// 	val fr = new ForkRun(
	// 		ForkOptions(bootJars = si.jars,
	// 			javaHome = jhome,
	// 			runJVMOptions = jopts ++ cp,
	// 			outputStrategy = strategy,
	// 			workingDirectory = Some(dir) ))

	// 	{ args: Seq[String] =>
	// 		if (args.isEmpty)
	// 			println("No benchmarks specified - nothing to run")
	// 		else{
	// 			val lo = args.map(a=> fr.run("com.google.caliper.Runner", Build.data(cpa), Seq(a), s.log))
	// 			val result = if (lo.exists(_ isEmpty)) None else Some(lo.map(_.get).foldLeft("")(_+"\n"+_))
	// 			sbt.toError(result)
	// 		}
	// 	}
	// }
}