package helpers

import java.util
import com.typesafe.config.ConfigFactory

/**
  * Created by supriya on 29/6/16.
  */
class Config(conf: String) {

  lazy val typesafeConfig = ConfigFactory.load(conf)

  /**
    * getString : It returns value to corresponding key as a String.
    *
    * @param key
    * @return
    */
  def getString(key: String): String = typesafeConfig.getString(key)

  /**
    * getInt : It returns value to corresponding key as a Int.
    *
    * @param key
    * @return
    */
  def getInt(key: String): Int = typesafeConfig.getInt(key)

  /**
    * getStringList : It returns list of values to corresponding to key.
    *
    * @param key
    * @return
    */
  def getStringList(key: String): util.List[String] = typesafeConfig.getStringList(key)

}
