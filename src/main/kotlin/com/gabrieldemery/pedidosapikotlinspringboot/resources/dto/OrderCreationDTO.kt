package com.gabrieldemery.pedidosapikotlinspringboot.resources.dto

import com.gabrieldemery.pedidosapikotlinspringboot.models.Address
import com.gabrieldemery.pedidosapikotlinspringboot.models.Customer

data class OrderCreationDTO(val customer: Customer, val address: Address)