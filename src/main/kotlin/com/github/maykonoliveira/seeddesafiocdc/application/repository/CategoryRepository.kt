package com.github.maykonoliveira.seeddesafiocdc.application.repository

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Category
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 * CI - 1
 */
interface CategoryRepository : JpaRepository<Category, Long> {
    fun findByName(name: String): Optional<Category>
}
