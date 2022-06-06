package com.github.maykonoliveira.seeddesafiocdc.application.domain

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Coupon(
    val code: String,
    val pct: Int,
    val validate: LocalDate
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
}