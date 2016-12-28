import sbt._
import Keys._
import sbt.Defaults._

//noinspection ScalaUnnecessaryParentheses,ScalaUnnecessaryParentheses,ScalaFileName
object UnitsBuild extends Build {

  val VERSION = "0.2.2"
  val SCALA_VERSION = "2.12.1"
  val CROSS_SCALA_VERSIONS = Seq("2.10.6", "2.11.8", "2.12.1")

  // don't compile the root project, compile `units` and other ones separately
  version := "dont.compile.this"
  scalaVersion := "dont.compile.this"

  type Sett = Def.Setting[_]

  // settings common for all projects

  //noinspection ScalaDeprecation
  lazy val baseSettings: Seq[Sett] =
    Defaults.defaultSettings ++ xerial.sbt.Sonatype.sonatypeSettings ++ Seq[Sett](
      organization := "io.github.karols",
      version := VERSION,
      scalaVersion := SCALA_VERSION,
      crossScalaVersions := CROSS_SCALA_VERSIONS,
      publishMavenStyle := true,
      publishTo := {
        val nexus = "https://oss.sonatype.org/"
        if (isSnapshot.value)
          Some("snapshots" at nexus + "content/repositories/snapshots")
        else
          Some("releases" at nexus + "service/local/staging/deploy/maven2")
      },
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
        IO.relativize(base, _).get.replace(java.io.File.separator, ".").replace(".scala", "")
      }.filter(_.endsWith("Benchmark"))
    },
    benchmark := benchmarkTaskInitTask.value(benchmarks.value),
    benchmarkOnly := benchmarkTaskInitTask.value(Def.spaceDelimited("<arg>").parsed)
  )

  // dependencies

  lazy val SCALATEST_TEST = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

  lazy val CALIPER_TEST = "com.google.caliper" % "caliper" % "0.5-rc1" % "test"

  lazy val SLF4J_TEST = "org.slf4j" % "slf4j-nop" % "1.6.4"

  // project definitions

  lazy val __units: Project = Project(
    id = "units",
    base = file("units"),
    settings = benchmarkSettings ++ Seq[Sett](
      name := "units"
    )
  ).aggregate(
    javatimeIntegration
  )

  lazy val javatimeIntegration: Project = Project(
    id = "units-javatime",
    base = file("units-javatime"),
    settings = baseSettings ++ Seq[Sett](
      name := "units-javatime",
      libraryDependencies ++= Seq(SCALATEST_TEST)
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

  //noinspection UnitInMap
  private def benchmarkTaskInitTask: Def.Initialize[Task[Seq[String] => Unit]] = Def.task {
    val cpa = (fullClasspath in Test).value
    val forkOpts = forkOptions.value
    val out = streams.value
    val fr = new ForkRun(forkOpts)
    // val opts = (caliperOptions in cappi).value
    ({ benchmarks: Seq[String] =>
      if (benchmarks.isEmpty) println("No benchmarks specified - nothing to run")
      else benchmarks.map(b =>
        sbt.toError(fr.run("com.google.caliper.Runner",
          Attributed.data(cpa), Seq(b), out.log)))
    })
  }

}
