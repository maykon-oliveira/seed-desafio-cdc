package com.github.maykonoliveira.seeddesafiocdc.application.validator

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Coupon
import com.github.maykonoliveira.seeddesafiocdc.application.repository.BookPurchaseRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CouponRepository
import org.springframework.stereotype.Service

/**
 * CI - 6
 */
@Service
class CouponValidator(
    private val repository: CouponRepository,
    private val bookPurchaseRepository: BookPurchaseRepository
) {
    fun validateAndReturns(code: String): Coupon {
        val coupon = repository.findByCode(code).orElseThrow { NoSuchElementException() }

        if (!coupon.isValid()) {
            throw Error("Coupom inválido")
        }

        if (bookPurchaseRepository.existsByCoupon(coupon)) {
            throw Error("Cupom já associado a uma compra")
        }

        return coupon
    }
}
