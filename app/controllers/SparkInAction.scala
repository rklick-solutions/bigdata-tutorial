package controllers

import org.apache.spark.sql.DataFrame
import play.api.mvc.{Action, Controller}
import utils.SparkCommons

/**
  * Created by anand on 2/16/16.
  */
class SparkInAction extends Controller {

  val dataFile = "resources/data.json"
  lazy val df: DataFrame = SparkCommons.sqlContext.read.json(dataFile).drop("loc")
  lazy val columns = df.columns

  def inAction = Action {
    val rows = df.collect().take(10)
    val dataMap = rows.map { row => columns.map { col => (col -> row.getAs[Any](col)) }.toMap }
    Ok(views.html.spark_in_action("home", columns, dataMap))
  }

}
