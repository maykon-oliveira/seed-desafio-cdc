package com.github.maykonoliveira.seeddesafiocdc.application.domain

import org.springframework.util.Assert
import javax.persistence.*

/**
 * CI - 3
 */
@Entity
class BookPurchase(
    val email: String,
    val name: String,
    val lastname: String,
    val email1: String,
    val document: String,
    val address: String,
    val complement: String,
    val cep: String,
    val city: String,
    @ManyToOne val country: Country,
    bookOrderConstructor: (BookPurchase) -> BookOrder
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null

    @OneToOne(mappedBy = "purchase", cascade = [CascadeType.PERSIST])
    val order: BookOrder

    init {
        this.order = bookOrderConstructor(this)
    }

    @ManyToOne
    var state: State? = null
        set(value) {
            if (value != null) {
                Assert.isTrue(value.isFrom(country), "Esse estado não pertece ao Pais dessa compra")
            }
            field = value
        }
}
