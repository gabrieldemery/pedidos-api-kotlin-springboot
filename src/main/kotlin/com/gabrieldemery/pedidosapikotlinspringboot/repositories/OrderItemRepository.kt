package com.gabrieldemery.pedidosapikotlinspringboot.repositories

import com.gabrieldemery.pedidosapikotlinspringboot.models.Order
import com.gabrieldemery.pedidosapikotlinspringboot.models.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItem, Long> {
	
	fun findByOrder(order: Order): List<OrderItem>?
	
}