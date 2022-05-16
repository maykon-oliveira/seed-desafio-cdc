package com.github.maykonoliveira.seeddesafiocdc.application.repository

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long>;