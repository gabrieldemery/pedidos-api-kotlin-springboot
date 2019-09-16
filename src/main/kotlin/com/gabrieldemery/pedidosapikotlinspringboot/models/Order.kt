package com.gabrieldemery.pedidosapikotlinspringboot.models

import java.util.Date
import com.gabrieldemery.pedidosapikotlinspringboot.models.interfaces.PaymentMethod
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.OneToOne
import com.gabrieldemery.pedidosapikotlinspringboot.models.enums.ProductType
import com.gabrieldemery.pedidosapikotlinspringboot.utils.LabelUtils
import com.gabrieldemery.pedidosapikotlinspringboot.utils.EmailUtils

@Entity
@Table(name="tbg_order")
class Order(
	@ManyToOne
    @JoinColumn(name = "customer_id")
	val customer: Customer,
	
	@OneToOne
	@JoinColumn(name = "address_id")
	val address: Address
) {
	@Id
	@GeneratedValue
	val id: Long = 0L
	
	@OneToMany(mappedBy = "order")
    val items = mutableListOf<OrderItem>()
	
    var closedAt: Date? = null
        private set
	
	var totalDiscount = 0.00
		private set
	
	@OneToOne(mappedBy = "order")
    var payment: Payment? = null
        private set
	
    val totalAmount
        get() = items.sumByDouble { it.total } - totalDiscount

    fun addProduct(product: Product, quantity: Int) {
        var productAlreadyAdded = items.any { it.product == product }
        if (productAlreadyAdded)
            throw Exception("The product have already been added. Change the amount if you want more.")

        items.add(OrderItem(this, product, quantity))
    }

    fun pay(method: PaymentMethod) {
		
        if (payment != null)
            throw Exception("The order has already been paid!")
		
        if (!method.validatedPaymentMethod())
            throw Exception("The payment method is not valid.")

        if (items.count() == 0)
            throw Exception("Empty order can not be paid!")

		checkDigitalProduct()
		
        payment = Payment(this, method)
		
		close()

        if(isPaid())
            confirmedPayment(customer, items)
    }
	
	private fun checkDigitalProduct() {
		var containsDigitalProduct = items.any { it.product.type === ProductType.DIGITAL }
		if (containsDigitalProduct)
			totalDiscount = 10.00
	}

    private fun close() {
        closedAt = Date()
    }

    fun isPaid(): Boolean {
        var response = false
        if(closedAt != null) {
            response = true
        }
        return response
    }
	
	private fun confirmedPayment(customer: Customer, list: List<OrderItem>) {
		var listPhysicalOrBook = list.filter { it.product.type === ProductType.PHYSICAL || it.product.type === ProductType.BOOK }
		if (listPhysicalOrBook.isNotEmpty()) LabelUtils.printLabel(customer, listPhysicalOrBook)
		
	    var listDigital = list.filter { it.product.type === ProductType.DIGITAL }
		if (listDigital.isNotEmpty()) EmailUtils.sendNotify(customer, listDigital)
		
	    var listMembership = list.filter { it.product.type === ProductType.MEMBERSHIP }
		if (listMembership.isNotEmpty()) EmailUtils.sendSignature(customer, listMembership)
	}
}