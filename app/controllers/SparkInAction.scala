package controllers

import org.apache.spark.sql.DataFrame
import play.api.mvc.{Action, Controller}
import utils.SparkCommons

/**
  * Created by anand on 2/16/16.
  */
class SparkInAction extends Controller {

  val dataFile = "resources/flights.json"
  lazy val df: DataFrame = SparkCommons.sqlContext.read.json(dataFile).withColumnRenamed("offer_valid_from", "FROM")
    .withColumnRenamed("offer_valid_upto", "UPTO")
    .select("COMPANY", "BANK_CODE", "CARD_TYPE", "DEAL_TYPE", "DIS_AMT", "MIN_PUR_AMT", "FROM", "UPTO")
  lazy val columns = df.columns

  def inAction = Action {
    val rows = df.take(10)
    val dataMap = rows.map { row => columns.map { col => (col -> row.getAs[Any](col)) }.toMap }
    Ok(views.html.tutorials.bigdata.spark_in_action("Spark In Action", df.count, df.count, rows.size, columns, dataMap))
  }

  def applyFilter = Action {
    val rows = df.filter(df("FROM").notEqual("0")).take(10)
    val dataMap = rows.map { row => columns.map { col => (col -> row.getAs[Any](col)) }.toMap }
    Ok(views.html.tutorials.bigdata.spark_in_action("Spark In Action", df.count, df.count, rows.size, columns, dataMap))
  }

  def applyDrop = Action {
    val rows = df.na.drop().take(10)
    val dataMap = rows.map { row => columns.map { col => (col -> row.getAs[Any](col)) }.toMap }
    Ok(views.html.tutorials.bigdata.spark_in_action("Spark In Action", df.count, df.count, rows.size, columns, dataMap))
  }

}
