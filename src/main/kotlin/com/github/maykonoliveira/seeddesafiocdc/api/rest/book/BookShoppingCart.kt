package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import com.github.maykonoliveira.seeddesafiocdc.application.domain.BookOrder
import com.github.maykonoliveira.seeddesafiocdc.application.domain.BookOrderItem
import com.github.maykonoliveira.seeddesafiocdc.application.domain.BookPurchase
import com.github.maykonoliveira.seeddesafiocdc.application.repository.BookRepository
import com.github.maykonoliveira.seeddesafiocdc.application.validator.ExistsByID
import org.springframework.util.Assert
import java.math.BigDecimal
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

/**
 * CI - 5
 */
data class BookShoppingCart(
    @field:NotNull @field:Positive val total: BigDecimal?,
    @field:NotNull @field:NotEmpty @field:Valid val items: List<BookShoppingCartItem>?
) {
    fun toDomain(bookRepository: BookRepository): (BookPurchase) -> BookOrder {
        val bookPurchaseItems = items!!.map { it.toDomain(bookRepository) }.toSet()

        return fun(bookPurchase: BookPurchase): BookOrder {
            val bookOrder = BookOrder(bookPurchase, bookPurchaseItems)

            Assert.isTrue(bookOrder.total() == total, "shoppingcart.total.wrong")

            return bookOrder
        }
    }
}

/**
 * CI - 4
 */
data class BookShoppingCartItem(
    @field:NotNull @field:ExistsByID(repository = BookRepository::class) val bookId: Long?,
    @field:NotNull @field:Positive val quantity: Int?
) {
    fun toDomain(bookRepository: BookRepository): BookOrderItem =
        BookOrderItem(bookRepository.findById(bookId!!).orElseThrow { NoSuchElementException() }, quantity!!)
}
