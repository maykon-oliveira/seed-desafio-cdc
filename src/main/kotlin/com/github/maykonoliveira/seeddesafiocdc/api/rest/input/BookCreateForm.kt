package com.github.maykonoliveira.seeddesafiocdc.api.rest.input

import com.fasterxml.jackson.annotation.JsonFormat
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Author
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Book
import com.github.maykonoliveira.seeddesafiocdc.application.domain.Category
import com.github.maykonoliveira.seeddesafiocdc.application.repository.AuthorRepository
import com.github.maykonoliveira.seeddesafiocdc.application.repository.CategoryRepository
import com.github.maykonoliveira.seeddesafiocdc.application.validator.ExistsByID
import com.github.maykonoliveira.seeddesafiocdc.application.validator.UniqueValue
import org.hibernate.validator.constraints.Range
import java.time.LocalDate
import javax.validation.constraints.*

/**
 * CI - 4
 */
data class BookCreateForm(
    @field:NotBlank
    @field:UniqueValue(
        fieldName = "title",
        domainClass = Book::class
    )
    val title: String?,
    @field:NotBlank
    @field:Size(max = 500)
    val resume: String?,
    @field:NotBlank
    val summary: String?,
    @field:Min(20)
    @field:NotNull
    val price: Long?,
    @field:NotNull
    @field:Min(100)
    val numberOfPages: Int?,
    @field:NotBlank
    @field:UniqueValue(
        fieldName = "isbn",
        domainClass = Book::class
    )
    val isbn: String?,
    @field:Future
    @field:NotNull
    @field:JsonFormat(pattern = "dd/MM/yyyy")
    val publicationDate: LocalDate?,
    @field:NotNull
    @field:ExistsByID(repository = CategoryRepository::class)
    val categoryId: Long?,
    @field:NotNull
    @field:ExistsByID(repository = AuthorRepository::class)
    val authorId: Long?,
) {
    fun toDomain(categoryRepository: CategoryRepository, authorRepository: AuthorRepository): Book {
        val category: Category = categoryRepository.findById(categoryId!!).orElseThrow { NoSuchElementException() }
        val author: Author = authorRepository.findById(authorId!!).orElseThrow { NoSuchElementException() }

        return Book(
            title!!,
            resume!!,
            summary!!,
            price!!.toBigDecimal(),
            numberOfPages!!,
            isbn!!,
            publicationDate!!,
            category,
            author
        )
    }
}