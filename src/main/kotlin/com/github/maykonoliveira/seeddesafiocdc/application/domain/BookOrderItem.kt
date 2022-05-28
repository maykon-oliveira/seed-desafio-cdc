package com.github.maykonoliveira.seeddesafiocdc.application.domain

import java.math.BigDecimal
import javax.persistence.Embeddable
import javax.persistence.ManyToOne

@Embeddable
data class BookOrderItem(@ManyToOne val book: Book, val quantity: Int) {
    private val price: BigDecimal = book.price

    fun total(): BigDecimal = price * BigDecimal(quantity)

}
