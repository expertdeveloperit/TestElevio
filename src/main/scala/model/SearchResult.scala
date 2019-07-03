package model

case class SearchResult(queryTerm: String, totalResults: Int , totalPages: Int, currentPage: Int, count: Int, results: Seq[Result])
