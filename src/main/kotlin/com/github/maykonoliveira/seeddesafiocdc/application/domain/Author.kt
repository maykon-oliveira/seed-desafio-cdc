package com.github.maykonoliveira.seeddesafiocdc.application.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
class Author(val name: String, val description: String, val email: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null

    @CreatedDate
    private var createdDate: LocalDateTime? = null;
}