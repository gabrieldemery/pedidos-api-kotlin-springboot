package com.gabrieldemery.pedidosapikotlinspringboot.tests

import com.gabrieldemery.pedidosapikotlinspringboot.models.Address
import com.gabrieldemery.pedidosapikotlinspringboot.models.CreditCard
import com.gabrieldemery.pedidosapikotlinspringboot.models.Customer
import com.gabrieldemery.pedidosapikotlinspringboot.models.Order
import com.gabrieldemery.pedidosapikotlinspringboot.models.Product
import com.gabrieldemery.pedidosapikotlinspringboot.models.enums.ProductType
import com.gabrieldemery.pedidosapikotlinspringboot.repositories.OrderRepository
import org.junit.Assert.*
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OrdersTest {
	
	lateinit var orderRepository: OrderRepository
	
	@Test
	fun createOrder() {
		
		val shirt = Product("Flowered t-shirt", ProductType.PHYSICAL, 35.00)
	    val netflix = Product("Familiar plan", ProductType.MEMBERSHIP, 29.90)
	    val book = Product("The Hitchhiker's Guide to the Galaxy", ProductType.BOOK, 120.00)
	    val music = Product("Stairway to Heaven", ProductType.DIGITAL, 5.00)
		
		val addressCustomer = Address("Brasil", "51020-210", "Pernambuco", "Recife", "Rua Padre Bernadino Pessoa", "277", "Apartamento 2202")
		val customerOrder = Customer("Gabriel D'Emery", addressCustomer, "falecomigo@gabrieldemery.com")

		val addressOrder = addressCustomer

    	val order = Order(customerOrder, addressOrder)
		orderRepository.save(order)
		assertTrue(order.id > 0)

	    order.addProduct(shirt, 2)
	    order.addProduct(netflix, 1)
	    order.addProduct(book, 1)
	    order.addProduct(music, 1)
		orderRepository.save(order)
		assertEquals(order.items.size, 4)
	
	    order.pay(CreditCard("43567890-987654367"))
		orderRepository.save(order)
		assertEquals(order.totalDiscount, 10)
		assertTrue(order.isPaid())
	}
}