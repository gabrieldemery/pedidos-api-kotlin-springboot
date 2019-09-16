package com.gabrieldemery.pedidosapikotlinspringboot.utils

import com.gabrieldemery.pedidosapikotlinspringboot.models.Customer
import com.gabrieldemery.pedidosapikotlinspringboot.models.OrderItem
import com.gabrieldemery.pedidosapikotlinspringboot.models.enums.ProductType

class LabelUtils {
	companion object {
	
		fun printLabel(customer: Customer, products: List<OrderItem>) {
			// Print Label with data of Customer and list of Products, if exists Products of type Book print "Tax-free"
			println(" ========== LABEL PRINTING BEGINS")
            println("Name: " + customer.fullName)
            println("Address: " + customer.address.fullAddress)
            println("Products:")
            products.forEach {
                var line = it.quantity.toString() + "x " + it.product.name + " = " + it.total
                if (it.product.type === ProductType.BOOK)
                    line = line + " (Tax-free)"
                println(line)
            }
            println(" ========== LABEL PRINTING TERMINATION")
		}
		
	}
}