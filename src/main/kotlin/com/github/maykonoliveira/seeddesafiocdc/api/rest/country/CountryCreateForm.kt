package com.github.maykonoliveira.seeddesafiocdc.api.rest.country

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Country
import com.github.maykonoliveira.seeddesafiocdc.application.validator.UniqueValue
import javax.validation.constraints.NotBlank

/**
 * CI - 1
 */
data class CountryCreateForm(
    @field:NotBlank @UniqueValue(
        fieldName = "name",
        domainClass = Country::class
    ) val name: String?
) {
    fun toDomain(): Country = Country(name!!)
}
