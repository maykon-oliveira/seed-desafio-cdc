package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import com.github.maykonoliveira.seeddesafiocdc.application.model.CountryAndStateModel
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CountryRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.StateRepository
import com.github.maykonoliveira.seeddesafiocdc.application.validator.CPFOrCNPJ
import com.github.maykonoliveira.seeddesafiocdc.application.validator.CountryAndState
import com.github.maykonoliveira.seeddesafiocdc.application.validator.ExistsByID
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import kotlin.NoSuchElementException

/**
 * CI - 8
 */
data class BookPurchaseForm(
    @field:Email
    @field:NotBlank
    val email: String?,
    @field:NotBlank
    val name: String?,
    @field:NotBlank
    val lastName: String?,
    @field:NotBlank
    @field:CPFOrCNPJ
    val document: String?,
    @field:NotBlank
    val cellphone: String?,
    @field:Valid
    @field:NotNull
    val address: AddressCreateForm?
) {
    fun toDomain(countryRepository: CountryRepository, stateRepository: StateRepository): Unit {
        val country = countryRepository.findById(address!!.countryId!!).orElseThrow { NoSuchElementException() }
        val stateOptional = Optional.ofNullable(address.stateId).flatMap { stateRepository.findById(it) }
    }
}

@CountryAndState
data class AddressCreateForm(
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
