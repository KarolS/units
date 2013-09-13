package stasiak.karol.units

import sbt._
import Keys._
import sbt.Defaults._

object UnitsBuild extends Build {
	

	val VERSION = "0.0.7-SNAPSHOT"
	

	type Sett = Project.Setting[_]

	// settings common for all projects

	lazy val baseSettings: Seq[Sett] = Defaults.defaultSettings ++ Seq[Sett](
	    organization := "stasiak.karol",
	    version := VERSION,
	    scalaVersion := "2.10.0",
	    crossScalaVersions := Seq("2.10.0"),
		pomIncludeRepository := {
	      x => false
	    },
	    pomExtra := (
	        <licenses>
	          <license>
	            <name>MIT License</name>
	            <url>http://opensource.org/licenses/MIT</url>
	          </license>
	        </licenses>
	        <developers>
	          <developer>
	            <id>KarolS</id>
	            <name>Karol Stasiak</name>
	            <url>http://github.com/KarolS</url>
	          </developer>
	        </developers>
		)
    )

	// dependencies

	lazy val SCALACHECK = "org.scalacheck" %% "scalacheck" % "[1.10.0,1.11)"

	lazy val SCALAZ = "org.scalaz" %% "scalaz-core" % "[7.0.0,7.1)" 

	lazy val SPIRE = "org.spire-math" %% "spire" % "[0.3.0,0.4)" 
	
	lazy val ALGEBIRD = "com.twitter" %% "algebird-core" % "0.1.13"

	lazy val SLICK = "com.typesafe.slick" %% "slick" % "[1.0.0,1.1)"

	lazy val JODA_TIME = "joda-time" % "joda-time" % "[2.1,3)"

	lazy val JODA_CONVERT = "org.joda" % "joda-convert" % "[1.2,2)" % "provided"

	lazy val SCALATEST_TEST = "org.scalatest" % "scalatest_2.10" % "[2.0.M5b,2.1)" % "test"

	lazy val CALIPER_TEST = "com.google.caliper" % "caliper" % "0.5-rc1" % "test" 

	lazy val H2_TEST = "com.h2database" % "h2" % "1.3.173" % "test" 

	lazy val SLF4J_TEST = "org.slf4j" % "slf4j-nop" % "1.6.4"

    // project definitions

	lazy val __units: Project = Project(
		id  = "units",
		base = file("units"),
		settings = baseSettings ++ Seq[Sett](
			name := "units",
			libraryDependencies ++= Seq(SCALATEST_TEST, CALIPER_TEST),
			// Benchmarking code based on work by Алексей Носков (https://github.com/alno/sbt-caliper)
			benchmark <<= benchmarkTaskInit.zip(sources in Test) {
				case (runTask, srcsTask) =>
					(runTask :^: srcsTask :^: KNil) map {
						case run :+: srcs :+: HNil =>
							run { srcs map { _.base } filter { _.endsWith("Benchmark") } }
				}
			},
			benchmarkOnly <<= sbt.inputTask { (argTask: TaskKey[Seq[String]]) =>
				benchmarkTaskInit.zip(argTask) {
				case (runTask, argTask) =>
					(runTask :^: argTask :^: KNil) map {
						case run :+: args :+: HNil =>
							run { args }
					}
				}
			}
		)
	) aggregate(
		scalazIntegration,
		scalacheckIntegration,
		spireIntegration,
		jodaTimeIntegration,
		algebirdIntegration,
		slick1Integration
	)

	lazy val __units11: Project = Project(
		id  = "units-211",
		base = file("units"),
		settings = baseSettings ++ Seq[Sett](
			name := "units-211",
			libraryDependencies ++= Seq(SCALATEST_TEST, CALIPER_TEST),
			crossScalaVersions := Seq("2.11.0-M3"),
			// Benchmarking code based on work by Алексей Носков (https://github.com/alno/sbt-caliper)
			benchmark <<= benchmarkTaskInit.zip(sources in Test) {
				case (runTask, srcsTask) =>
					(runTask :^: srcsTask :^: KNil) map {
						case run :+: srcs :+: HNil =>
							run { srcs map { _.base } filter { _.endsWith("Benchmark") } }
				}
			},
			benchmarkOnly <<= sbt.inputTask { (argTask: TaskKey[Seq[String]]) =>
				benchmarkTaskInit.zip(argTask) {
				case (runTask, argTask) =>
					(runTask :^: argTask :^: KNil) map {
						case run :+: args :+: HNil =>
							run { args }
					}
				}
			}
		)
	)

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

	protected def benchmarkTaskInit: Project.Initialize[Task[Seq[String] => Unit]] = (
		fullClasspath in Test, scalaInstance, javaHome, javaOptions, baseDirectory, outputStrategy, streams
	) map {
		(cpa, si, jhome, jopts, dir, strategy, s) =>
		// cpa.files foreach (println(_))
		val cp = "-classpath" :: Path.makeString(cpa.files) :: Nil
		val fr = new ForkRun(
			ForkOptions(scalaJars = si.jars,
				javaHome = jhome,
				runJVMOptions = jopts ++ cp,
				outputStrategy = strategy,
				workingDirectory = Some(dir) ))
		
		{ args: Seq[String] =>
			if (args.isEmpty)
				println("No benchmarks specified - nothing to run")
			else{
				val lo = args.map(a=> fr.run("com.google.caliper.Runner", Build.data(cpa), Seq(a), s.log))
				val result = if (lo.exists(_ isEmpty)) None else Some(lo.map(_.get).foldLeft("")(_+"\n"+_))
				sbt.toError(result)
			}
		}
	}
}