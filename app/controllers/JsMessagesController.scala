package controllers

import com.google.inject.Inject
import jsmessages.JsMessagesFactory
import play.api.mvc.{Action, Controller}

/**
  * Created by supriya on 16/2/16.
  */
class JsMessagesController @Inject()(jsMessagesFactory: JsMessagesFactory) extends Controller {

  val messages = jsMessagesFactory.all
  /**
    *
    */
  val jsMessages = Action { implicit request =>
    Ok(messages.all(Some("window.Messages")))
  }

}
