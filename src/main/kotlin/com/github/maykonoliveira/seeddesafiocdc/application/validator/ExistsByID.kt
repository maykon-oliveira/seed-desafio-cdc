package com.github.maykonoliveira.seeddesafiocdc.application.validator

import org.springframework.data.repository.CrudRepository
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

/**
 * CI - 2
 */
@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [ExistsByIDValidator::class])
annotation class ExistsByID(
    val message: String = "com.github.maykonoliveira.seeddesafiocdc.application.validator.existsbyid",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val repository: KClass<out CrudRepository<*, Long>>
)
