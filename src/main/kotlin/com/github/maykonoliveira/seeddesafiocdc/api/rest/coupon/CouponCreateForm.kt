package com.github.maykonoliveira.seeddesafiocdc.api.rest.coupon

import com.fasterxml.jackson.annotation.JsonFormat
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Coupon
import com.github.maykonoliveira.seeddesafiocdc.application.validator.UniqueValue
import org.hibernate.validator.constraints.Range
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.Future
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

/**
 * CI - 2
 */
data class CouponCreateForm(
    @field:NotBlank @field:UniqueValue(fieldName = "code", domainClass = Coupon::class) val code: String?,
    @field:Positive
    @field:Range(max = 100)
    val pct: BigDecimal?,
    @field:Future
    @field:NotNull
    @field:JsonFormat(pattern = "dd/MM/yyyy")
    val validate: LocalDate?
) {
    fun toDomain(): Coupon = Coupon(code!!, pct!!, validate!!)
}
