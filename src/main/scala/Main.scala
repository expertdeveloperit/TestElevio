import model._

object Main {
  def main(args: Array[String]): Unit = {
    do {
      println("Enter 1 for view article list, 2 for article and 3 for search article and 4 for exit")
      scala.io.StdIn.readInt() match {
        case 1 =>
          println("Enter Page Number")
          val page = scala.io.StdIn.readInt()
          showArticleList(page).articles.foreach(a => {
            println(s"Author Name ${a.author.name}")
          })
        case 2 =>
          println("Enter Article ID")
          val articleId = scala.io.StdIn.readInt()
          val article = showArticle(articleId)
          println(s"Article ${article.article.created_at}")
        case 3 =>
          println("Enter Search Term")
          val search = scala.io.StdIn.readLine()
          searchArticle(search)
        case 4 =>
          return
      }
    } while (true)
  }

  def showArticleList(page_number: Int): Response = {
    val articleUri = s"articles?page_number=$page_number"
    val response = HttpConnection(articleUri).call()
    Json[Response](response)
  }

  def showArticle(id: Int): ArticleResponse = {
    val articleUri = s"articles/$id"
    val response = HttpConnection(articleUri).call()
    Json[ArticleResponse](response)
  }

  def searchArticle(searchTerm: String): SearchResult ={
    val search = s"search/en?query=$searchTerm"
    val response = HttpConnection(search).call()
    Json[SearchResult](response)
  }
}
