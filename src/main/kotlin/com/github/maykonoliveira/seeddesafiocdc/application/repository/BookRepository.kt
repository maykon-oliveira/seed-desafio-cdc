package com.github.maykonoliveira.seeddesafiocdc.application.repository

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>