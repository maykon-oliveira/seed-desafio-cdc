package com.github.maykonoliveira.seeddesafiocdc.api.rest.states

import com.github.maykonoliveira.seeddesafiocdc.application.repository.CountryRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.StateRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * CI - 3
 */
@RestController
@RequestMapping("/states")
class StateController(private val repository: StateRepository, private val countryRepository: CountryRepository) {
    @PostMapping
    fun create(@Valid @RequestBody stateCreateForm: StateCreateForm): ResponseEntity<*> {
        val state = stateCreateForm.toDomain(countryRepository)
        repository.save(state)
        return ResponseEntity.ok(state)
    }
}