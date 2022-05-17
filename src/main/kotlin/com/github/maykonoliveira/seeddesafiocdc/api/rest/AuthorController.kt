package com.github.maykonoliveira.seeddesafiocdc.api.rest

import com.github.maykonoliveira.seeddesafiocdc.api.rest.input.AuthorCreateForm
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Author
import com.github.maykonoliveira.seeddesafiocdc.application.repository.AuthorRepository
import com.github.maykonoliveira.seeddesafiocdc.application.validator.AuthorUniqueEmailValidator
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * CI - 4
 */
@RestController
@RequestMapping("/authors")
class AuthorController(
    private val repository: AuthorRepository,
    private val authorUniqueEmailValidator: AuthorUniqueEmailValidator
) {

    @InitBinder
    fun init(binder: WebDataBinder) {
        binder.addValidators(authorUniqueEmailValidator)
    }

    @PostMapping
    @Transactional
    fun create(@Valid @RequestBody authorForm: AuthorCreateForm): ResponseEntity<Author> {
        val author = authorForm.toDomain();
        repository.save(author)
        return ResponseEntity.ok(author);
    }

}