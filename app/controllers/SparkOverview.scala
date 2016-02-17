package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by anand on 2/16/16.
  */
class SparkOverview extends Controller {

  def overview = Action {
    Ok(views.html.tutorials.bigdata.spark_overview("Spark Overview"))
  }

}
