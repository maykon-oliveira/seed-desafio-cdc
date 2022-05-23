package com.github.maykonoliveira.seeddesafiocdc.application.domain

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
class Book(
    val title: String,
    val resume: String,
    val summary: String,
    val price: BigDecimal,
    val numberOfPages: Int,
    val isbn: String,
    val publicationDate: LocalDate,
    @ManyToOne
    private val category: Category,
    @ManyToOne
    private val author: Author
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
}
