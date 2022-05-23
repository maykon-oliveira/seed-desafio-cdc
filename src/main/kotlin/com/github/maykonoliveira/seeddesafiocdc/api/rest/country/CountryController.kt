package com.github.maykonoliveira.seeddesafiocdc.api.rest.country

import com.github.maykonoliveira.seeddesafiocdc.application.repository.CountryRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * CI - 2
 */
@RestController
@RequestMapping("/countries")
class CountryController(private val repository: CountryRepository) {
    @PostMapping
    fun create(@Valid @RequestBody countryForm: CountryCreateForm): ResponseEntity<*> {
        val country = countryForm.toDomain()
        repository.save(country)
        return ResponseEntity.ok(country)
    }
}