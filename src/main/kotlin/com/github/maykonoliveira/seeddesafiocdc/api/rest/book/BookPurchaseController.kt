package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import com.github.maykonoliveira.seeddesafiocdc.application.repository.*
import com.github.maykonoliveira.seeddesafiocdc.application.validator.CouponValidator
import com.github.maykonoliveira.seeddesafiocdc.application.validator.ShoppingCartTotalValidator
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * CI - 7
 */
@RestController
@RequestMapping("/books/buy")
class BookPurchaseController(
    private val shoppingCartTotalValidator: ShoppingCartTotalValidator,
    private val countryRepository: CountryRepository,
    private val stateRepository: StateRepository,
    private val bookPurchaseRepository: BookPurchaseRepository,
    private val bookRepository: BookRepository,
    private val couponValidator: CouponValidator
) {

    @InitBinder
    fun binder(binder: WebDataBinder) {
        binder.addValidators(shoppingCartTotalValidator)
    }

    @PostMapping
    @Transactional
    fun buyBook(@Valid @RequestBody bookPurchaseRequest: BookPurchaseRequest): ResponseEntity<*> {
        val bookPurchase = bookPurchaseRequest.toDomain(bookRepository, countryRepository, stateRepository)

        bookPurchaseRequest.couponCode?.let {
            val coupon = couponValidator.validate(it)
            bookPurchase.applyCoupon(coupon)
        }

        bookPurchaseRepository.save(bookPurchase)
        return ResponseEntity.ok(bookPurchase)
    }

}