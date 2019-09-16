package com.gabrieldemery.pedidosapikotlinspringboot.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_address")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Address(
	@JsonProperty("country")
	val country: String = "",
	
	@JsonProperty("zip")
	val zip: String = "",
	
	@JsonProperty("state")
	val state: String = "",
	
	@JsonProperty("city")
	val city: String = "",
	
	@JsonProperty("address")
	val address: String = "",
	
	@JsonProperty("number")
	val number: String = "",
	
	@JsonProperty("complement")
	val complement: String = ""
) {
	@Id
	@GeneratedValue
	val id: Long = 0L
	
	val fullAddress
		get() = "$address, $number - $complement, $zip - $city, $state, $country"
}