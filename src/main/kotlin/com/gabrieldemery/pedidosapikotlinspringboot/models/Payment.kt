package com.gabrieldemery.pedidosapikotlinspringboot.models

import com.gabrieldemery.pedidosapikotlinspringboot.models.interfaces.PaymentMethod
import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Transient

@Entity
@Table(name = "tbg_payment")
data class Payment(
	@OneToOne
	@JoinColumn(name = "order_id")
	val order: Order,
	
	@OneToOne
	val paymentMethod: PaymentMethod
) {
	@Id
	@GeneratedValue
	val id: Long = 0L
    val paidAt = Date()
    val authorizationNumber = paidAt.time
    val amount = order.totalAmount
	
	@Transient
    val invoice = Invoice(order)
}