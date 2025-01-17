package com.github.maykonoliveira.seeddesafiocdc.application.repository

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Author
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 * CI - 1
 */
interface AuthorRepository : JpaRepository<Author, Long> {
    fun findByEmail(email: String): Optional<Author>;
}