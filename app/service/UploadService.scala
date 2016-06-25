package service


import play.api.Logger
import play.api.libs.Files.TemporaryFile
import play.api.mvc.{MultipartFormData, Request}
import java.util.UUID

import com.google.common.io.Files
import play.api.mvc.MultipartFormData.FilePart



/**
  * Created by supriya on 15/2/16.
  */
class UploadService {

  private val log: Logger = Logger(this.getClass)

  /**
    * Get file from the request and move it in your location
    *
    * @param request
    * @return
    */

    def uploadFile(request: Request[MultipartFormData[TemporaryFile]]): String = {
    println("Called uploadFile function" + request)
    request.body.file("picture").map { picture =>
      import java.io.File
      val filename = picture.filename
      val extension =Files.getFileExtension(filename)
      val contentType = picture.contentType
      log.error(s"File name : $filename, content type : $contentType")
      val newFileName = s"${UUID.randomUUID}.$extension"
      picture.ref.moveTo(new File(s"/tmp/picture/$newFileName"))
      "File uploaded"
    }.getOrElse {
      "Missing file"
    }
  }

  def getExtension(dataFile: FilePart[TemporaryFile]): String = {
    dataFile.filename.substring(dataFile.filename.lastIndexOf(".") + 1)
  }

  /**
    * Get File Extension Based On Temporary File
    *
    * @param filename
    * @return
    */
  def getExtension(filename: String): String = {
    filename.substring(filename.lastIndexOf(".") + 1)
  }

}
