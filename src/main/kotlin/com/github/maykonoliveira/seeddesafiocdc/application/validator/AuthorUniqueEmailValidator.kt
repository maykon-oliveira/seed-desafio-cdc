package com.github.maykonoliveira.seeddesafiocdc.application.validator

import com.github.maykonoliveira.seeddesafiocdc.api.rest.input.AuthorCreateForm
import com.github.maykonoliveira.seeddesafiocdc.application.repository.AuthorRepository
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 * CI - 4
 */
@Component
class AuthorUniqueEmailValidator(val repository: AuthorRepository) : Validator {

    override fun supports(clazz: Class<*>): Boolean = clazz == AuthorCreateForm::class.java

    override fun validate(target: Any, errors: Errors) {
        if (errors.hasErrors()) return

        val author = (target as AuthorCreateForm).toDomain()

        if (repository.findByEmail(author.email).isPresent) {
            errors.rejectValue("email", "email.unique")
        }
    }

}
