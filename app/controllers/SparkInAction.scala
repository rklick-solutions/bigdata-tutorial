package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by anand on 2/16/16.
  */
class SparkInAction extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}
