package com.github.maykonoliveira.seeddesafiocdc.application.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Coupon(
    val code: String,
    val pct: BigDecimal,
    val validate: LocalDate
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    fun percentage(): BigDecimal = this.pct.divide(BigDecimal(100))

    @JsonIgnore
    fun isValid(): Boolean = validate >= LocalDate.now()

}