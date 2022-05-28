package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import com.github.maykonoliveira.seeddesafiocdc.application.model.CountryAndStateModel
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CountryRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.StateRepository
import com.github.maykonoliveira.seeddesafiocdc.application.validator.CountryAndState
import com.github.maykonoliveira.seeddesafiocdc.application.validator.ExistsByID
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * CI - 5
 */
@CountryAndState
data class BookPurchaseBuyerAddress(
    @field:NotBlank
    val address: String?,
    @field:NotBlank
    val complement: String?,
    @field:NotBlank
    val city: String?,
    @field:NotNull
    @field:ExistsByID(repository = CountryRepository::class)
    val countryId: Long?,
    @field:ExistsByID(repository = StateRepository::class)
    val stateId: Long?,
    @field:NotBlank
    val cep: String?
) : CountryAndStateModel {
    override fun countryId(): Long = countryId!!

    override fun stateId(): Long? = stateId
}