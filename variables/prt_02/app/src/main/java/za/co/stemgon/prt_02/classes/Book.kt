package za.co.stemgon.prt_02.classes


class Book(val title: String, val pages: Int = 298,  val  author: String = "Carrington Muleya") {
    init {
        println("$title was written by $author and has $pages pages")
    }

    fun printBook(){
        println("I printed 567 copies $title")
    }
}


fun main(){
    var book = Book("New Generation Mathematics", );
    book.printBook()
    println(book.author)
    println(book.title)
    println(book.pages)
}