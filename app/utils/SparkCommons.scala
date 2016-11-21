package utils


import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{SQLContext, SparkSession}

//import org.apache.spark.{SparkConf, SparkContext}
//import org.apache.spark.sql.{SQLContext, SparkSession}
//import org.apache.spark.sql.SparkSession
//import spark.implicits._

/**
  * Handles configuration, context and so
  *
  * @author Anand Singh
  */
object SparkCommons {
  //build the SparkConf  object at once
  lazy val conf1 = {
    SparkSession
      .builder
      .master("local").config("spark.logConf", true)
      .appName("BigData Tutorial")
      .getOrCreate()
    //.getOrCreate()
  }

  lazy val sqlContext = conf1.sqlContext

  /*lazy val sc = new SparkSession(conf)
  lazy val sparkSQLContext = SQLContext(sc)
  lazy val  sqlContext = conf.sqlContext*/


  //build the SparkConf  object at once
  /*lazy val conf = {
    new SparkConf(false)
      .setMaster("local[*]")
      .setAppName("BigData Tutorial")
      .set("spark.logConf", "true")
  }

  //lazy val sc = SparkContext.getOrCreate(conf)
  //lazy val sqlContext = new SQLContext(sc)

  def main(args: Array[String]) {
    val logFile = "README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
  }
*/
}