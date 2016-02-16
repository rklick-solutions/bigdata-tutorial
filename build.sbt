import play.sbt.PlayImport._
import play.sbt.routes.RoutesKeys._

name := """bigdata-tutorial"""

version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaSource in Compile <<= baseDirectory / "src/scala"

scalaVersion := Version.scala

libraryDependencies ++= Seq(jdbc, cache, ws, specs2 % Test)

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.4.0-1",
  "org.webjars.bower" % "adminlte" % "2.3.2"
)

libraryDependencies ++= Dependencies.sparkLib

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalariformSettings

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
