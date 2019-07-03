package model

case class Article(updated_at: String,
                   translations: Seq[Translation],
                   title: String,
                   status: String,
                   source: String,
                   smart_groups: Seq[SmartGroup],
                   revision: Revision,
                   order: Int,
                   notes: Option[String],
                   last_publisher: Contributor,
                   last_published_at: String,
                   keywords: Seq[Keyword],
                   id: Int,
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