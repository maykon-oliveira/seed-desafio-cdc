package com.github.maykonoliveira.seeddesafiocdc.application.repository

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Coupon
import org.springframework.data.repository.CrudRepository
import java.util.*

/**
 * CI - 1
 */
interface CouponRepository : CrudRepository<Coupon, Long> {
    fun findByCode(code: String): Optional<Coupon>
}
