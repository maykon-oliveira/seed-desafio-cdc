package com.github.maykonoliveira.seeddesafiocdc.api.rest

import com.github.maykonoliveira.seeddesafiocdc.api.rest.input.BookCreateForm
import com.github.maykonoliveira.seeddesafiocdc.application.repository.AuthorRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.BookRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CategoryRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * CI - 4
 */
@RestController
@RequestMapping("/books")
class BookController(
    private val repository: BookRepository,
    private val categoryRepository: CategoryRepository,
    private val authorRepository: AuthorRepository
) {
    @PostMapping
    fun create(@Valid @RequestBody bookForm: BookCreateForm): ResponseEntity<*> {
        val book = bookForm.toDomain(categoryRepository, authorRepository)
        repository.save(book)
        return ResponseEntity.ok(book)
    }
}