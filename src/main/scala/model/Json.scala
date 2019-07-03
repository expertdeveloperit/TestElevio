package model

import net.liftweb.json._

object Json {

  private implicit val formats = DefaultFormats

  def apply[T](json: String)(implicit mf: scala.reflect.Manifest[T]): T  = parse(json).extract[T]

}
