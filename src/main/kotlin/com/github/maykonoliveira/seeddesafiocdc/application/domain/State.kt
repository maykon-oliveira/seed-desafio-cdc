package com.github.maykonoliveira.seeddesafiocdc.application.domain

import javax.persistence.*

@Entity
class State(val name: String, @ManyToOne val country: Country) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
}
