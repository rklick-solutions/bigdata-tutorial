import sbt._

object Version {
  val scala = "2.11.8"
  val spark = "2.0.2"
  val jacksonV = "2.6.5"
}

object Library {
  val sparkCore = "org.apache.spark" %% "spark-core" % Version.spark
  val sparkSQL = "org.apache.spark" %% "spark-sql" % Version.spark
  val jackson = "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.0"
}

object Dependencies {

  import Library._

  val sparkLib = Seq(sparkCore, sparkSQL).map { v => v exclude("org.slf4j", "*") }
}
