package com.github.maykonoliveira.seeddesafiocdc.api.rest.category

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Category
import com.github.maykonoliveira.seeddesafiocdc.application.validator.UniqueValue
import javax.validation.constraints.NotBlank

/**
 * CI - 2
 */
data class CategoryCreateForm(
    @field:NotBlank @field:UniqueValue(
        fieldName = "name",
        domainClass = Category::class
    ) val name: String?
) {
    fun toDomain(): Category = Category(name!!)
}
