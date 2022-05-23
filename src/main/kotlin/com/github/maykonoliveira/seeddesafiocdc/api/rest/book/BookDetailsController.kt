package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import com.github.maykonoliveira.seeddesafiocdc.application.repository.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * CI - 3
 */
@RestController
@RequestMapping("/books")
class BookDetailsController(
    private val repository: BookRepository
) {

    @GetMapping("/{id}")
    fun bookById(@PathVariable id: Long): ResponseEntity<BookDetailDto> {
        return repository.findById(id)
            .map { ResponseEntity.ok(BookDetailDto(it)) }
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build())
    }
}