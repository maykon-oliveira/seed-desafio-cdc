package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import com.github.maykonoliveira.seeddesafiocdc.application.domain.BookPurchase
import com.github.maykonoliveira.seeddesafiocdc.application.repository.BookRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CountryRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.StateRepository
import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 * CI - 6
 */
data class BookPurchaseRequest(
    @field:NotNull @field:Valid val buyer: BookPurchaseBuyer?,
    @field:NotNull @field:Valid val shoppingCart: BookShoppingCart?
) {
    fun toDomain(
        bookRepository: BookRepository,
        countryRepository: CountryRepository,
        stateRepository: StateRepository
    ): BookPurchase {
        val bookOrderConstructor = shoppingCart!!.toDomain(bookRepository)
        return buyer!!.toDomain(bookOrderConstructor, countryRepository, stateRepository)
    }
}