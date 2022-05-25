package com.github.maykonoliveira.seeddesafiocdc.application.validator

import org.springframework.context.ApplicationContext
import org.springframework.data.repository.CrudRepository
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ExistsByIDValidator(private val entityManager: ApplicationContext) :
    ConstraintValidator<ExistsByID, Any> {
    private lateinit var repository: CrudRepository<*, Long>

    override fun initialize(constraintAnnotation: ExistsByID) {
        super.initialize(constraintAnnotation)
        this.repository = entityManager.getBean(constraintAnnotation.repository.java)
    }

    override fun isValid(value: Any?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) return true

        return repository.existsById(value as Long);
    }
}