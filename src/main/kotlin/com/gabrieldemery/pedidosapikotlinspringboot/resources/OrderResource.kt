package com.gabrieldemery.pedidosapikotlinspringboot.resources

import com.gabrieldemery.pedidosapikotlinspringboot.models.Address
import com.gabrieldemery.pedidosapikotlinspringboot.models.Customer
import com.gabrieldemery.pedidosapikotlinspringboot.models.Order
import com.gabrieldemery.pedidosapikotlinspringboot.models.OrderItem
import com.gabrieldemery.pedidosapikotlinspringboot.repositories.OrderItemRepository
import com.gabrieldemery.pedidosapikotlinspringboot.repositories.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.gabrieldemery.pedidosapikotlinspringboot.models.interfaces.PaymentMethod
import com.gabrieldemery.pedidosapikotlinspringboot.models.enums.ProductType
import com.gabrieldemery.pedidosapikotlinspringboot.utils.EmailUtils
import com.gabrieldemery.pedidosapikotlinspringboot.utils.LabelUtils
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.CrossOrigin
import io.swagger.annotations.ApiOperation
import com.gabrieldemery.pedidosapikotlinspringboot.resources.dto.OrderCreationDTO
import com.gabrieldemery.pedidosapikotlinspringboot.resources.dto.OrderProductAdditionDTO
import com.gabrieldemery.pedidosapikotlinspringboot.resources.dto.OrderPaymentDTO

@RestController
@RequestMapping("/order")
@Api(value = "Endpoints of Order")
class OrderResource {
	
	@Autowired
	lateinit var orderRepository: OrderRepository
	
	@PostMapping
	@ApiOperation(value = "Create Order")
	fun create(@RequestBody orderCreationDTO: OrderCreationDTO): Long? {
		var order = orderRepository.save(Order(orderCreationDTO.customer, orderCreationDTO.address))
		return order.id
    }
	
	@PostMapping("/addProducts")
	@ApiOperation(value = "Add Products with Item in Order")
	fun addProducts(@RequestBody orderProductAdditionDTO: OrderProductAdditionDTO): Boolean {
		var optionalOrder = orderRepository.findById(orderProductAdditionDTO.id)
		
		if (optionalOrder == null)
			throw Exception("The order entered does not exist.")
		
		// Save Items
		val order = optionalOrder.get()
		orderProductAdditionDTO.items.forEach { order.addProduct(it.product, it.quantity) }
		orderRepository.save(order)
		
		return true;
    }
	
	@PostMapping("/pay")
	@ApiOperation(value = "Run payment of Order")
	fun pay(@RequestBody orderPaymentDTO: OrderPaymentDTO): Boolean {
		var optionalOrder = orderRepository.findById(orderPaymentDTO.id)
		
		if (optionalOrder == null)
			throw Exception("The order entered does not exist.")
		
		// Save Payment
		val order = optionalOrder.get()
		order.pay(orderPaymentDTO.method)
		orderRepository.save(order)
		
		return true;
    }
	
}