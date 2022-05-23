package com.github.maykonoliveira.seeddesafiocdc.api.rest.states

import com.github.maykonoliveira.seeddesafiocdc.application.domain.State
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CountryRepository
import com.github.maykonoliveira.seeddesafiocdc.application.validator.ExistsByID
import com.github.maykonoliveira.seeddesafiocdc.application.validator.UniqueValue
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * CI - 2
 */
data class StateCreateForm(
    @field:NotBlank @UniqueValue(
        fieldName = "name",
        domainClass = State::class
    ) val name: String?,
    @field:NotNull
    @field:ExistsByID(repository = CountryRepository::class)
    val countryId: Long?
) {
    fun toDomain(countryRepository: CountryRepository): State {
        val country = countryRepository.findById(countryId!!).orElseThrow { NoSuchElementException() }
        return State(name!!, country)
    }
}
