package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by anand on 2/16/16.
  */
class SparkInAction extends Controller {

  def inAction = Action {
    Ok(views.html.spark_in_action("Your new application is ready."))
  }

}
