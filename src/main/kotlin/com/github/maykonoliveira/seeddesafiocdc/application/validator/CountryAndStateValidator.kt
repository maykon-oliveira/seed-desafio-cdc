package com.github.maykonoliveira.seeddesafiocdc.application.validator

import com.github.maykonoliveira.seeddesafiocdc.application.model.CountryAndStateModel
import com.github.maykonoliveira.seeddesafiocdc.application.repository.StateRepository
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

/**
 * CI - 5
 */
class CountryAndStateValidator(private val stateRepository: StateRepository) :
    ConstraintValidator<CountryAndState, CountryAndStateModel> {
    override fun isValid(value: CountryAndStateModel, context: ConstraintValidatorContext?): Boolean {
        val states = stateRepository.findAllByCountryId(value.countryId())

        if (states.isEmpty() && value.stateId() == null) {
            return true
        }

        return states.any { value.stateId() == it.id }
    }
}