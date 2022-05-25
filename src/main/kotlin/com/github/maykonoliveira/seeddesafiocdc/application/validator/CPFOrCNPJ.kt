package com.github.maykonoliveira.seeddesafiocdc.application.validator

import org.hibernate.validator.constraints.CompositionType
import org.hibernate.validator.constraints.ConstraintComposition
import org.hibernate.validator.constraints.br.CNPJ
import org.hibernate.validator.constraints.br.CPF
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@CPF
@CNPJ
@Target(
    AnnotationTarget.FIELD,
)
@Constraint(validatedBy = [])
@Retention(AnnotationRetention.RUNTIME)
@ConstraintComposition(CompositionType.OR)
annotation class CPFOrCNPJ(
    val message: String = "com.github.maykonoliveira.seeddesafiocdc.application.validator.cpforcnpj",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
