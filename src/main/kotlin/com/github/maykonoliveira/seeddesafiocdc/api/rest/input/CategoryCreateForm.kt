package com.github.maykonoliveira.seeddesafiocdc.api.rest.input

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Category
import javax.validation.constraints.NotBlank

/**
 * CI - 1
 */
data class CategoryCreateForm(@field:NotBlank val name: String?) {
    fun toDomain(): Category = Category(name!!)
}
