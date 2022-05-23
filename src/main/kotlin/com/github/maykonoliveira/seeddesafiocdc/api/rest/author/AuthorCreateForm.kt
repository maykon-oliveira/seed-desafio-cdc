package com.github.maykonoliveira.seeddesafiocdc.api.rest.author

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Author
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Category
import com.github.maykonoliveira.seeddesafiocdc.application.validator.UniqueValue
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

/**
 * CI - 2
 */
data class AuthorCreateForm (
    @field:NotBlank
    val name: String?,
    @field:NotBlank
    @field:Size(max = 400)
    val description: String?,
    @field:Email
    @field:NotBlank
    @field:UniqueValue(
        fieldName = "email",
        domainClass = Author::class
    )
    val email: String?
) {

    fun toDomain(): Author = Author(name!!, description!!, email!!)

}
