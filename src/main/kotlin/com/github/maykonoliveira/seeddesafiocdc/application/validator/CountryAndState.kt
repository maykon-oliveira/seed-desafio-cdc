package com.github.maykonoliveira.seeddesafiocdc.application.validator

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Constraint(validatedBy = [CountryAndStateValidator::class])
@Retention(AnnotationRetention.RUNTIME)
annotation class CountryAndState(
    val message: String = "com.github.maykonoliveira.seeddesafiocdc.application.validator.countryandstate",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
