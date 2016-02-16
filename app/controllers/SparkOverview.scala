package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by anand on 2/16/16.
  */
class SparkOverview extends Controller {

  def overview = Action {
    Ok(views.html.spark_overview("Your new application is ready."))
  }

}
