package com.gabrieldemery.pedidosapikotlinspringboot.models

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
@Table(name = "tbg_orderitem")
data class OrderItem(
	@ManyToOne
    @JoinColumn(name = "order_id")
	val order: Order?,
	
	@OneToOne
    @JoinColumn(name = "product_id")
	val product: Product,
	
	val quantity: Int = 0
) {
	@Id
	@GeneratedValue
	val id: Long? = 0L
	
    val total
		get() = product.price * quantity
}