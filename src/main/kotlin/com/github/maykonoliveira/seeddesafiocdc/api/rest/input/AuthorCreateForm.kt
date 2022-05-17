package com.github.maykonoliveira.seeddesafiocdc.api.rest.input

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Author
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

/**
 * CI - 1
 */
data class AuthorCreateForm (
    @field:NotBlank
    val name: String?,
    @field:NotBlank
    @field:Size(max = 400)
    val description: String?,
    @field:Email
    @field:NotBlank
    val email: String?
) {

    fun toDomain(): Author = Author(name!!, description!!, email!!)

}
