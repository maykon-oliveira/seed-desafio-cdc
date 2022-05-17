package com.github.maykonoliveira.seeddesafiocdc.application.validator

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

/**
 * CI - 1
 */
@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UniqueValueValidator::class])
annotation class UniqueValue(
    val message: String = "com.github.maykonoliveira.seeddesafiocdc.application.validator.uniquevalue",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val fieldName: String,
    val domainClass: KClass<*>
)
