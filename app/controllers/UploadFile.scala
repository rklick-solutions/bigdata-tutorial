package controllers

import com.google.inject.Inject
import play.api.mvc.BodyParsers.parse
import play.api.mvc.{Action, Controller}
import service.UploadService

/**
  * Created by ved on 25/6/16.
  */
class UploadFile@Inject()(uploadService: UploadService) extends Controller {
  def file = Action {
    Ok(views.html.tutorials.upload.upload("file upload"))
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
    Ok(views.html.tutorials.upload.uploadResult("Upload Result", result._2, result._1))
  }
}
