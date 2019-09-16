package com.gabrieldemery.pedidosapikotlinspringboot.models.interfaces

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class PaymentMethod {
	
	@Id
	@GeneratedValue
	val id: Long = 0L
	
	open fun validatedPaymentMethod(): Boolean {
		return true;
	}
	
}