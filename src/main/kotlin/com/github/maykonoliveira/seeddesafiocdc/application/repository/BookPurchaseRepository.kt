package com.github.maykonoliveira.seeddesafiocdc.application.repository

import com.github.maykonoliveira.seeddesafiocdc.application.domain.BookPurchase
import org.springframework.data.jpa.repository.JpaRepository

interface BookPurchaseRepository : JpaRepository<BookPurchase, Long>
