package model

case class Response (total_pages: Int, total_entries: Int, page_size: Int, page_number:Int, articles: Seq[Article])
