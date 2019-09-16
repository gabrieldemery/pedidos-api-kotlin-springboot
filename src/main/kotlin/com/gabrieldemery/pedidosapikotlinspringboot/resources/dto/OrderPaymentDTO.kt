package com.gabrieldemery.pedidosapikotlinspringboot.resources.dto

import com.gabrieldemery.pedidosapikotlinspringboot.models.interfaces.PaymentMethod

class OrderPaymentDTO(val id: Long, val method: PaymentMethod)