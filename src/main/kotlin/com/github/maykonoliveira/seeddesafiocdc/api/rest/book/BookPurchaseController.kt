package com.github.maykonoliveira.seeddesafiocdc.api.rest.book

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/books/buy")
class BookPurchaseController {
    @PostMapping
    fun buyBook(@Valid @RequestBody bookPurchaseForm: BookPurchaseForm): ResponseEntity<*> {
        return ResponseEntity.ok(null)
    }
}