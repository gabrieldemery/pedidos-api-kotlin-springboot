package com.gabrieldemery.pedidosapikotlinspringboot.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "tbg_customer")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Customer(
	
	@JsonProperty("fullName")
	val fullName: String,
	
	@OneToOne
	@JoinColumn(name = "address_id")
	@JsonProperty("address")
    val address: Address,
	
	@JsonProperty("email")
	val email: String

) {
	
	@Id
	@GeneratedValue
	val id: Long = 0L
	
}