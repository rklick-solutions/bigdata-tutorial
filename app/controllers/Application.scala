package controllers

import com.google.inject.Inject
import play.api.mvc._
import service.UploadService

class Application @Inject()(uploadService: UploadService) extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.index("Playing MultipartFormData"))
  }

  /**
    *
    * @return
    */
  def uploadForm = Action { implicit request =>
    Ok(views.html.upload("Playing MultipartFormData"))
  }

  /**
    *
    * @return
    */
  def upload = Action(parse.multipartFormData) { implicit request =>
    println(s"Calling Upload:::::::::")
    val result = uploadService.uploadFile(request)
    println(s"result Upload:::::::::${result}")
    Ok(result)
  }

  /**
    *
    * @return
    */
  def graph = Action { implicit request =>
    Ok(views.html.networkGraph("Playing MultipartFormData"))
  }

}
