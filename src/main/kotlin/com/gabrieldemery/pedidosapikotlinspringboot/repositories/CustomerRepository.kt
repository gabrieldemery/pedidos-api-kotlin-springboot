package com.gabrieldemery.pedidosapikotlinspringboot.repositories

import com.gabrieldemery.pedidosapikotlinspringboot.models.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long> {
}