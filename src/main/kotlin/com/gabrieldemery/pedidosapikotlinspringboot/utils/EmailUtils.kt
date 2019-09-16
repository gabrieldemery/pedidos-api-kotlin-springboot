package com.gabrieldemery.pedidosapikotlinspringboot.utils

import com.gabrieldemery.pedidosapikotlinspringboot.models.Customer
import com.gabrieldemery.pedidosapikotlinspringboot.models.OrderItem

class EmailUtils {
	companion object {
	
		fun sendSignature(customer: Customer, products: List<OrderItem>) {
			// Send for topic to Kafka consumer
			println(" ========== START OF SUBMISSION SUBSCRIPTION ACTIVATION")
            println("To: " + customer.fullName + " <" + customer.email + ">")
            println("Subject: Subscription Activation")
            println("Message:")
            products.forEach { println(it.product.name + " signature activation!") }
            println(" ========== END OF SUBMISSION SUBSCRIPTION ACTIVATION")
		}
	
		fun sendNotify(customer: Customer, products: List<OrderItem>) {
			// Send for topic to Kafka consumer
			println(" ========== START OF PURCHASE NOTIFICATION")
            println("To: " + customer.fullName + " <" + customer.email + ">")
            println("Subject: Purchase Notification")
            println("Message:")
            products.forEach { println(it.product.name + " purchase notification!") }
            println(" ========== END OF PURCHASE NOTIFICATION")
		}
		
	}
}