package com.gabrieldemery.pedidosapikotlinspringboot.models

import com.gabrieldemery.pedidosapikotlinspringboot.models.enums.ProductType
import javax.persistence.Entity
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbg_product")
data class Product(
	val name: String = "",
	@Enumerated(EnumType.STRING)
	val type: ProductType = ProductType.PHYSICAL,
	val price: Double = 0.00
) {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	val id: Long = 0L
}