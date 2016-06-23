package controllers

import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, Row}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import utils.{PieChart, SparkCommons}
import org.apache.spark.sql.functions._

/**
  * Created by anand on 2/16/16.
  */
class SparkInAction extends Controller {

  implicit val pieChartFormat = Json.format[PieChart]

  val COLOR = Map("Asia" -> "#f56954", "Europe" -> "#00a65a", "North America" -> "#f39c12", "Africa" -> "#00c0ef",
    "Oceania" -> "#3c8dbc", "Antarctica" -> "#d2d6de", "South America" -> "#DC143C", "HSBC" -> "#FF1493", "KOT" -> "#FF4500",
    "INDUSIND" -> "#BDB76B")

  def upload = Action(parse.multipartFormData) { request =>
    request.body.file("picture").map { picture =>
      import java.io.File
      val filename = picture.filename
      //val contentType = picture.contentType
      picture.ref.moveTo(new File(s"/tmp/picture/$filename"))
      Ok("File uploaded")
    }.getOrElse {
      Redirect(routes.Application.index).flashing(
        "error" -> "Missing file")
    }
  }
 val filePath="tmp/picture/$filename"
  def loadDF(filePath: String): DataFrame = {
    SparkCommons.sqlContext.read.json(filePath)
  }

  val dataFile = "resources/countries-info.json"
  lazy val df: DataFrame = SparkCommons.sqlContext.read.json(dataFile)
    .select("countryCode", "countryName", "currencyCode", "population", "capital", "continentName", "languages")
  lazy val columns = df.columns

  def inAction = Action {
    val dfData = loadDF(dataFile)
    val rows = dfData.take(20)
    val dataMap = rows.map { row => dfData.columns.map { col => (col -> row.getAs[Any](col)) }.toMap }
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
    val filteredDF = df.filter(df("population").>(100000000))
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
    val dataFrame = df.sort("countryName")
    val (company, bank) = getPieChartData(dataFrame)
    val fCols = dataFrame.columns
    val rows = dataFrame.take(20)
    val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
    val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
    val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
      "table" -> table, "company" -> company, "bank" -> bank)
    Ok(data)
  }

  def applyLimit(limit: Int) = Action {
    val dataFrame = df.limit(limit)
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
    val company = dataFrame.groupBy("continentName").count().collect().map { case Row(name: String, count: Long) =>
      PieChart(count, color(name), color(name), name)
    }//.sortBy(-_.value).take(10)
    val bank = dataFrame.groupBy("countryCode").count().collect().map { case Row(name: String, count: Long) =>
      PieChart(count, color(name), color(name), name)
    }
    (company, bank)
  }


}
