package com.github.maykonoliveira.seeddesafiocdc.application.validator

import com.github.maykonoliveira.seeddesafiocdc.api.rest.book.BookPurchaseRequest
import com.github.maykonoliveira.seeddesafiocdc.application.repository.BookRepository
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import java.math.BigDecimal

/**
 * CI - 5
 */
@Component
class ShoppingCartTotalValidator(private val bookRepository: BookRepository) : Validator {

    override fun supports(clazz: Class<*>): Boolean = clazz == BookPurchaseRequest::class.java

    override fun validate(target: Any, errors: Errors) {
        val shoppingCart = (target as BookPurchaseRequest).shoppingCart!!

        val realTotalSum = bookRepository
            .findAllById(shoppingCart.items!!.map { it.bookId })
            .zip(shoppingCart.items)
            .sumOf { it.first.price.multiply(BigDecimal(it.second.quantity!!)) }

        if (shoppingCart.total != realTotalSum) {
            errors.reject("shoppingcart.total.wrong")
        }
    }

}