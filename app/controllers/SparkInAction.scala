package controllers

import com.google.inject.Inject

import scala.concurrent.ExecutionContext.Implicits.global
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, Row}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import utils.{Common, PieChart, SparkCommons}

import scala.concurrent.Future

/**
  * Created by anand on 2/16/16.
  */
class SparkInAction extends Controller {

  implicit val pieChartFormat = Json.format[PieChart]
  implicit val dataComponentFormat = Json.format[DataComponent]

  val COLOR = Map("Asia" -> "#f56954", "Europe" -> "#00a65a", "North America" -> "#f39c12", "Africa" -> "#00c0ef",
    "Oceania" -> "#3c8dbc", "Antarctica" -> "#d2d6de", "South America" -> "#DC143C", "HSBC" -> "#FF1493", "KOT" -> "#FF4500",
    "INDUSIND" -> "#BDB76B")

  /**
    *
    * @param columns
    * @return
    */
  def findColumns(columns: String) = Action.async {
    Future(Ok("success"))
  }

  /**
    *
    * @return
    */
  def populateModal = Action.async { implicit request =>
    val columns = request.body.asJson match {
      case Some(data) =>
        data.asOpt[String].map { value =>
          value.split(",").toList
        }.getOrElse(Nil)
      case None => Nil
    }
    Future(Ok(views.html.tutorials.bigdata.modal_function("Spark In Action", columns)))
  }

  val dataFile = "resources/countries-info.json"
  lazy val df: DataFrame = SparkCommons.sqlContext.read.json(dataFile)
    .select("countryCode", "countryName", "currencyCode", "population", "capital", "continentName", "languages")
  lazy val columns = df.columns

  /**
    *
    * @param df
    * @return
    */
  def getColumns(df: DataFrame): Array[String] = {
    df.columns
  }

  def inAction(filename: String) = Action {
    val dataFile = Common.getPath(filename)
    val dfData = loadDF(dataFile)
    val rows = dfData.take(20)
    val columns = getColumns(dfData)
    val dataMap = rows.map { row => dfData.columns.map { col => (col -> row.getAs[Any](col)) }.toMap }
    Ok(views.html.tutorials.bigdata.spark_in_action("Spark In Action", dfData.count,
      dfData.count, rows.size, columns, dataMap, columns))
  }

  def chartReport = Action {
    val (company, bank) = getPieChartData(df)
    val data = Json.obj("company" -> company, "bank" -> bank)
    Ok(data)
  }

  /**
    *
    * @return
    */
  def applyCollect = Action.async { implicit request =>
    Future {
      request.body.asJson.map { data =>
        data.asOpt[DataComponent].map { dComponent =>
          val df = loadDF(Common.getPath(dComponent.filename))
          val (company, bank) = getPieChartData(df)
          val fCols = df.columns
          val rows = df.take(20)
          //val dataCollect=df.collect()
          val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
          val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
          val data = Json.obj("current" -> df.count, "showing" -> rows.size,
            "table" -> table, "company" -> company, "bank" -> bank)
          Ok(data)
        }.getOrElse(Ok(Common.ERROR))
      }.getOrElse(Ok(Common.ERROR))
    }
  }


  def applyFilter = Action.async { implicit request =>

    Future {
      request.body.asJson.map { data =>
        data.asOpt[DataComponent].map { dComponent =>
          val filteredDF = loadDF(Common.getPath(dComponent.filename))
          val (company, bank) = getPieChartData(filteredDF)
          val fCols = filteredDF.columns
          val rows = filteredDF.take(20)
          val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
          val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
          val data = Json.obj("current" -> filteredDF.count, "showing" -> rows.size,
            "table" -> table, "company" -> company, "bank" -> bank)
          Ok(data)
        }.getOrElse(Ok(Common.ERROR))
      }.getOrElse(Ok(Common.ERROR))
    }
  }

  def applySort = Action.async { implicit request =>

    Future {
      request.body.asJson.map { data =>
        data.asOpt[DataComponent].map { dComponent =>
          val df = loadDF(Common.getPath(dComponent.filename))
          val dataFrame = df.sort()
          val (company, bank) = getPieChartData(dataFrame)
          val fCols = dataFrame.columns
          val rows = dataFrame.take(20)
          val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
          val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
          val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
            "table" -> table, "company" -> company, "bank" -> bank)
          Ok(data)
        }.getOrElse(Ok(Common.ERROR))
      }.getOrElse(Ok(Common.ERROR))
    }
  }

  def applyLimit(limit: Int) = Action.async { implicit request =>

    Future {
      request.body.asJson.map { data =>
        data.asOpt[DataComponent].map { dComponent =>
          val df = loadDF(Common.getPath(dComponent.filename))
          val dataFrame = df.limit(limit)
          val (company, bank) = getPieChartData(dataFrame)
          val fCols = dataFrame.columns
          val rows = dataFrame.take(20)
          val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
          val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
          val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
            "table" -> table, "company" -> company, "bank" -> bank)
          Ok(data)
        }.getOrElse(Ok(Common.ERROR))
      }.getOrElse(Ok(Common.ERROR))
    }
  }

  def applyAdd = Action.async { implicit request =>

    Future {
      request.body.asJson.map { data =>
        data.asOpt[DataComponent].map { dComponent =>
          val df = loadDF(Common.getPath(dComponent.filename))
          val dataFrame = df.withColumn("PUBLISHED", current_date())
          val (company, bank) = getPieChartData(dataFrame)
          val fCols = dataFrame.columns
          val rows = dataFrame.take(20)
          val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
          val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
          val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
            "table" -> table, "company" -> company, "bank" -> bank)
          Ok(data)
        }.getOrElse(Ok(Common.ERROR))
      }.getOrElse(Ok(Common.ERROR))
    }
  }

  def applyDrop = Action.async { implicit request =>

    Future {
      request.body.asJson.map { data =>
        data.asOpt[DataComponent].map { dComponent =>
          val df = loadDF(Common.getPath(dComponent.filename))
          val dataFrame = df.na.drop()
          val (company, bank) = getPieChartData(dataFrame)
          val fCols = dataFrame.columns
          val rows = dataFrame.take(20)
          val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
          val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
          val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
            "table" -> table, "company" -> company, "bank" -> bank)
          Ok(data)
        }.getOrElse(Ok(Common.ERROR))
      }.getOrElse(Ok(Common.ERROR))
    }
  }

        def applyReplace = Action.async { implicit request =>

          Future {
            request.body.asJson.map { data =>
              data.asOpt[DataComponent].map { dComponent =>
                import com.google.common.collect.ImmutableMap
                val df = loadDF(Common.getPath(dComponent.filename))
                val dataFrame = df.na.replace("*", ImmutableMap.of(0.0, 2222.0)).na.replace("*", ImmutableMap.of("0", "Unknown"))
                val (company, bank) = getPieChartData(dataFrame)
                val fCols = dataFrame.columns
                val rows = dataFrame.take(20)
                val dataMap = rows.map { row => fCols.map { col => (col -> row.getAs[Any](col)) }.toMap }
                val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
                val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
                  "table" -> table, "company" -> company, "bank" -> bank)
                Ok(data)
              }.getOrElse(Ok(Common.ERROR))
            }.getOrElse(Ok(Common.ERROR))
          }
        }

        def applyDistinct = Action.async { implicit request =>

          Future {
            request.body.asJson.map { data =>
              data.asOpt[DataComponent].map { dComponent =>
                val df = loadDF(Common.getPath(dComponent.filename))
                val dataFrame = df.distinct()
                val (company, bank) = getPieChartData(dataFrame)
                val fCols = dataFrame.columns
                val rows = dataFrame.take(20)
                val dataMap = rows.map {
                  row => fCols.map {
                    col => (col -> row.getAs[Any](col))
                  }.toMap
                }
                val table = views.html.tutorials.bigdata.data_table(fCols, dataMap).toString
                val data = Json.obj("current" -> dataFrame.count, "showing" -> rows.size,
                  "table" -> table, "company" -> company, "bank" -> bank)
                Ok(data)
              }.getOrElse(Ok(Common.ERROR))
            }.getOrElse(Ok(Common.ERROR))
          }
        }

        private def color(name: String): String =
        {
          COLOR.getOrElse(name, "#f56954")
        }

        private def getPieChartData(dataFrame: DataFrame): (Array[PieChart], Array[PieChart]) =
        {
          val company = dataFrame.groupBy("continentName").count().collect().map {
            case Row(name: String, count: Long) =>
              PieChart(count, color(name), color(name), name)
          } //.sortBy(-_.value).take(10)
        val bank = dataFrame.groupBy("countryCode").count().collect().map {
            case Row(name: String, count: Long) =>
              PieChart(count, color(name), color(name), name)
          }
          (company, bank)
        }

        private def loadDF(path: String): DataFrame =
        {
          SparkCommons.sqlContext.read.json(path)
        }

      }

      case class DataComponent(filename: String, column: String)
