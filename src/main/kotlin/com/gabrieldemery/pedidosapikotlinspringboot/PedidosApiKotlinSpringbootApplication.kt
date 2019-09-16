package com.gabrieldemery.pedidosapikotlinspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PedidosApiKotlinSpringbootApplication

fun main(args: Array<String>) {
	runApplication<PedidosApiKotlinSpringbootApplication>(*args)
}
