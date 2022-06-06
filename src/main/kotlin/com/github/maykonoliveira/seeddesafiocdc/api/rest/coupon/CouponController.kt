package com.github.maykonoliveira.seeddesafiocdc.api.rest.coupon

import com.github.maykonoliveira.seeddesafiocdc.application.repository.CouponRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * CI - 2
 */
@RestController
@RequestMapping("/coupons")
class CouponController(private val repository: CouponRepository) {
    @PostMapping
    fun create(@Valid @RequestBody createForm: CouponCreateForm): ResponseEntity<*> {
        val coupon = createForm.toDomain()
        repository.save(coupon)
        return ResponseEntity.ok(coupon)
    }
}