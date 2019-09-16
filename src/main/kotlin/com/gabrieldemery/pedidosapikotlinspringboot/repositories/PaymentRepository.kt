package com.gabrieldemery.pedidosapikotlinspringboot.repositories

import com.gabrieldemery.pedidosapikotlinspringboot.models.Order
import com.gabrieldemery.pedidosapikotlinspringboot.models.Payment
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository: JpaRepository<Payment, Long> {
	
	fun findByOrder(order: Order): Payment?
	
}