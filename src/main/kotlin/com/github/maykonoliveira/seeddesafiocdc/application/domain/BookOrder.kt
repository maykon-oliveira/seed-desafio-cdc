package com.github.maykonoliveira.seeddesafiocdc.application.domain

import org.springframework.util.Assert
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class BookOrder(
    @OneToOne private val purchase: BookPurchase,
    @ElementCollection val orderItems: Set<BookOrderItem>
) {
    init {
        Assert.notEmpty(orderItems, "Items não pode ser vazio")
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null

    fun total(): BigDecimal = orderItems.sumOf { it.total() }

}