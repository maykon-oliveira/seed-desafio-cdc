package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import com.github.maykonoliveira.seeddesafiocdc.application.domain.BookPurchase
import com.github.maykonoliveira.seeddesafiocdc.application.repository.BookRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CountryRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.StateRepository
import com.github.maykonoliveira.seeddesafiocdc.application.validator.CouponValidator
import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 * CI - 8
 */
data class BookPurchaseRequest(
    @field:NotNull @field:Valid val buyer: BookPurchaseBuyer?,
    @field:NotNull @field:Valid val shoppingCart: BookShoppingCart?,
    val couponCode: String?
) {
    fun toDomain(
        bookRepository: BookRepository,
        countryRepository: CountryRepository,
        stateRepository: StateRepository,
        couponValidator: CouponValidator
    ): BookPurchase {
        val bookOrderConstructor = shoppingCart!!.toDomain(bookRepository)
        val bookPurchase = buyer!!.toDomain(bookOrderConstructor, countryRepository, stateRepository)

        couponCode?.let {
            val coupon = couponValidator.validateAndReturns(it)
            bookPurchase.applyCoupon(coupon)
        }

        return bookPurchase
    }
}