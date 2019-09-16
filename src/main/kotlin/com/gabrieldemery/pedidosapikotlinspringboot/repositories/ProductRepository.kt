package com.gabrieldemery.pedidosapikotlinspringboot.repositories

import com.gabrieldemery.pedidosapikotlinspringboot.models.Product
import com.gabrieldemery.pedidosapikotlinspringboot.models.enums.ProductType
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
	
	fun findByType(type: ProductType): List<Product>
	
}