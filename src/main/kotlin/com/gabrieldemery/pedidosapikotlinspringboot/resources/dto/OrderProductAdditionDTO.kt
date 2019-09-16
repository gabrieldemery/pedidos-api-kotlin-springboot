package com.gabrieldemery.pedidosapikotlinspringboot.resources.dto

import com.gabrieldemery.pedidosapikotlinspringboot.models.OrderItem

class OrderProductAdditionDTO(val id: Long, val items: List<OrderItem>)