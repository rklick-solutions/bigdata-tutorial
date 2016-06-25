package controllers

import java.util.UUID

import com.google.inject.Inject
import play.api.mvc._
import service.UploadService

class Application @Inject()(uploadService: UploadService) extends Controller {

  def index = Action { implicit request =>
    Redirect(routes.SparkOverview.overview)
  }

  /**
    *
    * @return
    */
  def uploadForm = Action { implicit request =>
    Ok(views.html.tutorials.bigdata.upload("Big Data Tutorial"))
  }

  /**
    *
    * @return
    */


  def upload = Action(parse.multipartFormData) { implicit request =>
    val result = uploadService.uploadFile(request)
    Ok(result)
  }

  /*def get (id: UUID)*/
}
