package model

case class Translation(updated_at: String,
                       title: String,
                       summary: Option[String],
                       machine_summary: Option[String],
                       language_id: String,
                       id:String,
                       featured_image_url: Option[String],
                       created_at: Option[String],
                       body: Option[String]
                      )
