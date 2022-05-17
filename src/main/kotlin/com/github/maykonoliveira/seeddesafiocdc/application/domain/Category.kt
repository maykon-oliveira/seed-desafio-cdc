package com.github.maykonoliveira.seeddesafiocdc.application.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Category(val name: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null
}
