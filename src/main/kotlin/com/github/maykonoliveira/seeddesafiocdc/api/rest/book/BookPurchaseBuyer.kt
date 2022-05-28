package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import com.github.maykonoliveira.seeddesafiocdc.application.domain.BookOrder
import com.github.maykonoliveira.seeddesafiocdc.application.domain.BookPurchase
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CountryRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.StateRepository
import com.github.maykonoliveira.seeddesafiocdc.application.validator.CPFOrCNPJ
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * CI - 8
 */
data class BookPurchaseBuyer(
    @field:Email
    @field:NotBlank
    val email: String?,
    @field:NotBlank
    val name: String?,
    @field:NotBlank
    val lastName: String?,
    @field:NotBlank
    @field:CPFOrCNPJ
    val document: String?,
    @field:NotBlank
    val cellphone: String?,
    @field:Valid
    @field:NotNull
    val address: BookPurchaseBuyerAddress?
) {
    fun toDomain(
        bookOrderConstructor: (BookPurchase) -> BookOrder,
        countryRepository: CountryRepository,
        stateRepository: StateRepository
    ): BookPurchase {
        val (_, complement, city, countryId, stateId, cep) = address!!

        val country = countryRepository.findById(countryId!!).orElseThrow { NoSuchElementException() }

        val bookPurchase = BookPurchase(
            email!!,
            name!!,
            lastName!!,
            cellphone!!,
            document!!,
            address.address!!,
            complement!!,
            cep!!,
            city!!,
            country,
            bookOrderConstructor
        )

        stateId?.let {
            bookPurchase.state = stateRepository.findById(it).orElseThrow { NoSuchElementException() }
        }

        return bookPurchase
    }
}
