package com.github.maykonoliveira.seeddesafiocdc.api.rest

import com.github.maykonoliveira.seeddesafiocdc.api.rest.input.BookCreateForm
import com.github.maykonoliveira.seeddesafiocdc.api.rest.output.BookOnlyIdAndTitle
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Book
import com.github.maykonoliveira.seeddesafiocdc.application.repository.AuthorRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.BookRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CategoryRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * CI - 7
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

    @GetMapping("/{id}")
    fun bookById(@PathVariable id: Long): ResponseEntity<Book> {
        return repository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build())
    }
}