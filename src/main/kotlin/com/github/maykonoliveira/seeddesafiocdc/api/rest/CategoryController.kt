package com.github.maykonoliveira.seeddesafiocdc.api.rest

import com.github.maykonoliveira.seeddesafiocdc.api.rest.input.CategoryCreateForm
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Category
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CategoryRepository
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * CI - 3
 */
@RestController
@RequestMapping("/categories")
class CategoryController(
    private val repository: CategoryRepository
) {

    @PostMapping
    @Transactional
    fun create(@Valid @RequestBody categoryForm: CategoryCreateForm): ResponseEntity<Category> {
        val category = categoryForm.toDomain()
        repository.save(category)
        return ResponseEntity.ok(category)
    }

}