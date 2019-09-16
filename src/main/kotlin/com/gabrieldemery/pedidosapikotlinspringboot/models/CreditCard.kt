package com.gabrieldemery.pedidosapikotlinspringboot.models

import com.gabrieldemery.pedidosapikotlinspringboot.models.interfaces.PaymentMethod
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue

@Entity
@Table(name = "tbg_creditcard")
data class CreditCard(
	val number: String
): PaymentMethod() {
	
	override fun validatedPaymentMethod(): Boolean {
		return number.length > 13 && number.length < 17
	}
}