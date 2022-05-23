package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import com.github.maykonoliveira.seeddesafiocdc.application.repository.AuthorRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.BookRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CategoryRepository
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * CI - 6
 */
@RestController
@RequestMapping("/books")
class BookController(
    private val repository: BookRepository,
    private val categoryRepository: CategoryRepository,
    private val authorRepository: AuthorRepository
) {
    @PostMapping
    @Transactional
    fun create(@Valid @RequestBody bookForm: BookCreateForm): ResponseEntity<*> {
        val book = bookForm.toDomain(categoryRepository, authorRepository)
        repository.save(book)
        return ResponseEntity.ok(book)
    }

    @GetMapping
    fun listOnlyIdAndTitle(): List<BookOnlyIdAndTitle> {
        return repository.findAll().map { BookOnlyIdAndTitle(it.id!!, it.title) }
    }

}