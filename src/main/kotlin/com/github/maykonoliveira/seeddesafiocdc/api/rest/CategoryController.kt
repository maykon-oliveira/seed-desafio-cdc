package com.github.maykonoliveira.seeddesafiocdc.api.rest

import com.github.maykonoliveira.seeddesafiocdc.api.rest.input.CategoryCreateForm
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Category
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CategoryRepository
import com.github.maykonoliveira.seeddesafiocdc.application.validator.CategoryUniqueNameValidator
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * CI - 4
 */
@RestController
@RequestMapping("/categories")
class CategoryController(
    private val repository: CategoryRepository,
    private val categoryUniqueNameValidator: CategoryUniqueNameValidator
) {

    @InitBinder
    fun init(binder: WebDataBinder) {
        binder.addValidators(categoryUniqueNameValidator)
    }

    @PostMapping
    @Transactional
    fun create(@Valid @RequestBody categoryForm: CategoryCreateForm): ResponseEntity<Category> {
        val category = categoryForm.toDomain()
        repository.save(category)
        return ResponseEntity.ok(category)
    }

}