package za.co.stemgon.prt_02.classes


class Book(val title: String, var pages: Int = 298, val  author: String = "Carrington Muleya", val yearPublished: Int =  2024) {
    init {
        println("$title was written by $author and has $pages pages, was published in $yearPublished")
    }

    fun printBook(){
        println("I printed 567 copies $title")
    }
}


fun main(){
    val book = Book("New Generation Mathematics", );
    book.printBook()
    println(book.author)
    println(book.title)
    book.pages = 4657
    println(book.pages)
    println(book.yearPublished)
}

/*
    Order of parameters matters when passing
 */