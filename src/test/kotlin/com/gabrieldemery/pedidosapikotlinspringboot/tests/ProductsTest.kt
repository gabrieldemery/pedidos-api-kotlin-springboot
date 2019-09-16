package com.gabrieldemery.pedidosapikotlinspringboot.tests


import com.gabrieldemery.pedidosapikotlinspringboot.models.Product
import com.gabrieldemery.pedidosapikotlinspringboot.models.enums.ProductType
import com.gabrieldemery.pedidosapikotlinspringboot.repositories.ProductRepository
import org.junit.Assert.assertTrue
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductsTest {
		
	lateinit var productRepository: ProductRepository;
	
	@Test
	fun createProducts() {
		
		val product = Product("Lacoste t-shirt", ProductType.PHYSICAL, 320.00)
		productRepository.save(product)
		
		val products = productRepository.findByType(ProductType.PHYSICAL)
		val lacosteTShirt = products.any { it.name === "Lacoste t-shirt" }
		
		assertTrue(lacosteTShirt)
	}
	
}