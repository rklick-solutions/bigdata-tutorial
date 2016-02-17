package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by anand on 2/16/16.
  */
class ArchitectureOverview extends Controller {

  def overview = Action {
    Ok(views.html.tutorials.architecture.arch_overview("Architecture Design"))
  }

}
