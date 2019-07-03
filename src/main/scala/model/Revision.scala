package model

case class Revision (
                      updated_at: Option[String],
                      translations: Seq[Translation],
                      status: Option[String],
                      source: Option[String],
                      smart_groups: Seq[SmartGroup],
                      order: Option[Int],
                      notes: Option[String],
                      last_publisher: Option[Contributor],
                      last_published_at: Option[String],
                      keywords: Seq[Keyword],
                      id: String,
                      external_id: Option[String],
                      editor_version: String,
                      created_at: String,
                      contributors: Seq[Contributor],
                      category_id: Int,
                      author: Contributor,
                      access_groups: Seq[AccessGroup],
                      access_emails: Seq[AccessEmail],
                      access_domains: Seq[AccessDomain],
                      access: String

                    )
