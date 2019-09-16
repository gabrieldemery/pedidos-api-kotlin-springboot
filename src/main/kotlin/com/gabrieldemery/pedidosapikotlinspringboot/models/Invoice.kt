package com.gabrieldemery.pedidosapikotlinspringboot.models

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.JoinColumn

data class Invoice(val order: Order) {
	
    val billingAddress
		get() = order.customer.address.fullAddress
	
    val shippingAddress
		get() = order.address.fullAddress
	
}