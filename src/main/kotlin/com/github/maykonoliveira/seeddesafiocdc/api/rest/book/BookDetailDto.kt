package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Author
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Book
import java.math.BigDecimal
import java.time.LocalDate

/**
 * CI - 3
 */
data class BookDetailDto(private val book: Book) {
    val title: String = book.title
    val isbn: String = book.title
    val resume: String = book.resume
    val summary: String = book.summary
    val numberOfPages: Int = book.numberOfPages
    val price: BigDecimal = book.price
    var publicationDate: LocalDate = book.publicationDate
    val author: BookDetailAuthor = BookDetailAuthor(book.author)
}

class BookDetailAuthor(author: Author) {
    val name: String = author.name
    val description: String = author.description
}
