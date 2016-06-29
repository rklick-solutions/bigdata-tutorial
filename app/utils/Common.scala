package utils

import helpers.Config

/**
  * Created by supriya on 29/6/16.
  */
object Common extends Config("application") {

  val BASE_FILE_PATH = getString("upload.file.base.path")
  val ERROR = "error"

  /**
    *
    * @param filename
    * @return
    */
  def getPath(filename: String): String = {
    s"$BASE_FILE_PATH$filename"
  }

}
