package com.gabrieldemery.pedidosapikotlinspringboot.repositories

import com.gabrieldemery.pedidosapikotlinspringboot.models.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
}