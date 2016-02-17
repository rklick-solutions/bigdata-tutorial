package controllers

import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, Row}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import utils.{PieChart, SparkCommons}

/**
  * Created by anand on 2/16/16.
  */
class SparkInAction extends Controller {

  implicit val pieChartFormat = Json.format[PieChart]

  val COLOR = Map("Yatra" -> "#f56954", "MakeMyTrip" -> "#00a65a", "GOIBIBO" -> "#f39c12", "AXIS" -> "#00c0ef",
    "HDFC" -> "#3c8dbc", "SBI" -> "#d2d6de", "DEUT" -> "#DC143C", "HSBC" -> "#FF1493", "KOT" -> "#FF4500",
    "INDUSIND" -> "#BDB76B")

  val dataFile = "resources/flights.json"
  lazy val df: DataFrame = SparkCommons.sqlContext.read.json(dataFile).withColumnRenamed("offer_valid_from", "FROM")
    .withColumnRenamed("offer_valid_upto", "UPTO")
    .select("COMPANY", "BANK_CODE", "CARD_TYPE", "DEAL_TYPE", "DIS_AMT", "MIN_PUR_AMT", "FROM", "UPTO")
  lazy val columns = df.columns

  def inAction = Action {
    val rows = df.take(20)
    val dataMap = rows.map { row => columns.map { col => (col -> row.getAs[Any](col)) }.toMap }
    Ok(views.html.tutorials.bigdata.spark_in_action("Spark In Action", df.count, df.count, rows.size, columns, dataMap))
  }

  def chartReport = Action {
    val (company, bank) = getPieChartData(df)
    val data = Json.obj("company" -> company, "bank" -> bank)
    Ok(data)
  }

  def applyCollect = Action {
    val (company, bank) = getPieChartData(df)
    val fCols = df.columns
    val rows = df.take(20)
    val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
    val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
    val data = Json.obj("current" -> df.count, "showing" -> rows.size,
      "table" -> table, "company" -> company, "bank" -> bank)
    Ok(data)
  }

  def applyFilter = Action {
    val filteredDF = df.filter(df("FROM").notEqual("0"))
    val (company, bank) = getPieChartData(filteredDF)
    val fCols = filteredDF.columns
    val rows = filteredDF.take(20)
    val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
    val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
    val data = Json.obj("current" -> filteredDF.count, "showing" -> rows.size,
      "table" -> table, "company" -> company, "bank" -> bank)
    Ok(data)
  }

  def applySort = Action {
    val dataFrame = df.sort("COMPANY", "BANK_CODE", "CARD_TYPE")
    val (company, bank) = getPieChartData(dataFrame)
    val fCols = dataFrame.columns
    val rows = dataFrame.take(20)
    val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
    val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
    val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
      "table" -> table, "company" -> company, "bank" -> bank)
    Ok(data)
  }

  def applyLimit = Action {
    val dataFrame = df.limit(10)
    val (company, bank) = getPieChartData(dataFrame)
    val fCols = dataFrame.columns
    val rows = dataFrame.take(20)
    val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
    val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
    val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
      "table" -> table, "company" -> company, "bank" -> bank)
    Ok(data)
  }

  def applyAdd = Action {
    import org.apache.spark.sql.functions._
    val dataFrame = df.withColumn("PUBLISHED", current_date())
    val (company, bank) = getPieChartData(dataFrame)
    val fCols = dataFrame.columns
    val rows = dataFrame.take(20)
    val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
    val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
    val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
      "table" -> table, "company" -> company, "bank" -> bank)
    Ok(data)
  }

  def applyDrop = Action {
    val dataFrame = df.na.drop()
    val (company, bank) = getPieChartData(dataFrame)
    val fCols = dataFrame.columns
    val rows = dataFrame.take(20)
    val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
    val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
    val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
      "table" -> table, "company" -> company, "bank" -> bank)
    Ok(data)
  }

  def applyReplace = Action {
    import com.google.common.collect.ImmutableMap
    val dataFrame = df.na.replace("*", ImmutableMap.of(0.0, 2222.0)).na.replace("*", ImmutableMap.of("0", "Unknown"))
    val (company, bank) = getPieChartData(dataFrame)
    val fCols = dataFrame.columns
    val rows = dataFrame.take(20)
    val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
    val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
    val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
      "table" -> table, "company" -> company, "bank" -> bank)
    Ok(data)
  }

  def applyDistinct = Action {
    val dataFrame = df.distinct()
    val (company, bank) = getPieChartData(dataFrame)
    val fCols = dataFrame.columns
    val rows = dataFrame.take(20)
    val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
    val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
    val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
      "table" -> table, "company" -> company, "bank" -> bank)
    Ok(data)
  }


  private def color(name: String): String = {
    COLOR.getOrElse(name, "#f56954")
  }

  private def getPieChartData(dataFrame: DataFrame): (Array[PieChart], Array[PieChart]) = {
    val company = dataFrame.groupBy("COMPANY").count().collect().map { case Row(name: String, count: Long) =>
      PieChart(count, color(name), color(name), name)
    }
    val bank = dataFrame.groupBy("BANK_CODE").count().collect().map { case Row(name: String, count: Long) =>
      PieChart(count, color(name), color(name), name)
    }
    (company, bank)
  }


}
