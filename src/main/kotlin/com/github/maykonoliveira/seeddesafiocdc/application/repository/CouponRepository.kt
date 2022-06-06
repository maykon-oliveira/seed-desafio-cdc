package com.github.maykonoliveira.seeddesafiocdc.application.repository

import com.github.maykonoliveira.seeddesafiocdc.application.domain.Coupon
import org.springframework.data.repository.CrudRepository

interface CouponRepository : CrudRepository<Coupon, Long>
