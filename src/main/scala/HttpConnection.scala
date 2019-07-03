import java.io.{DataOutputStream, IOException}
import java.net.URL

import com.typesafe.config.ConfigFactory
import javax.net.ssl.HttpsURLConnection

import scala.io.Source

object HttpConnection {
  def apply(uri: String, requestMethod: String = "GET"): HttpConnection = new HttpConnection(uri, requestMethod)
}

class HttpConnection(uri: String, requestMethod: String) {
  private val conf = ConfigFactory.load
  private val api_domain = conf.getString("api.domain")
  private val api_key = conf.getString("api.api_key")
  private val authorizeToken = conf.getString("api.authorization_token")

  private val buildConnection: Option[HttpsURLConnection] = {
    val urls = new URL(s"$api_domain$uri")
    try {
      val connection = urls.openConnection().asInstanceOf[HttpsURLConnection]

      connection.setRequestMethod(requestMethod)
      connection.setRequestProperty("x-api-key", api_key)
      connection.setRequestProperty("Authorization", s"Bearer $authorizeToken")
      connection.setDoOutput("GET" != requestMethod)
      connection.setDoInput(true)
      connection.setUseCaches(false)
      Some(connection)
    }
    catch {
      case ex : IOException =>
        println("Exception while connection..")
        ex.printStackTrace()
        None
    }
  }

  def call(): String ={
    buildConnection match {
      case Some(httpsURLConnection) =>
        val inputStream = httpsURLConnection.getInputStream
        val content = Source.fromInputStream(inputStream).mkString
        inputStream.close()
        content
      case _ => ""
    }
  }

  def call(input: String): String ={
    buildConnection match {
      case Some(httpsURLConnection) =>
        val outputStream = new DataOutputStream(httpsURLConnection.getOutputStream)
        outputStream.writeBytes(input)
        outputStream.flush()
        outputStream.close()
        val inputStream = httpsURLConnection.getInputStream
        val content = Source.fromInputStream(inputStream).mkString
        inputStream.close()
        content
      case _ => ""
    }
  }


}
