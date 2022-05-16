package com.github.maykonoliveira.seeddesafiocdc.api.rest

import com.github.maykonoliveira.seeddesafiocdc.api.rest.input.AuthorCreateForm
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Author
import com.github.maykonoliveira.seeddesafiocdc.application.repository.AuthorRepository
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * CI - 3
 */
@RestController
@RequestMapping("/authors")
class AuthorController(val repository: AuthorRepository) {

    @PostMapping
    @Transactional
    fun create(@Valid @RequestBody authorForm: AuthorCreateForm): ResponseEntity<Author> {
        val author = authorForm.toDomain();
        repository.save(author)
        return ResponseEntity.ok(author);
    }

}