package com.github.maykonoliveira.seeddesafiocdc.application.validator

import com.github.maykonoliveira.seeddesafiocdc.api.rest.input.CategoryCreateForm
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CategoryRepository
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class CategoryUniqueNameValidator(private val repository: CategoryRepository) : Validator {
    override fun supports(clazz: Class<*>): Boolean = clazz == CategoryCreateForm::class.java

    override fun validate(target: Any, errors: Errors) {
        if (errors.hasErrors()) return

        val category = (target as CategoryCreateForm).toDomain()

        if (repository.findByName(category.name).isPresent) {
            errors.rejectValue("name", "name.unique")
        }
    }

}
