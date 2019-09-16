package com.gabrieldemery.pedidosapikotlinspringboot.resources

import com.gabrieldemery.pedidosapikotlinspringboot.models.Product
import com.gabrieldemery.pedidosapikotlinspringboot.models.enums.ProductType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import com.gabrieldemery.pedidosapikotlinspringboot.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.Api

@RestController
@RequestMapping("/products")
@Api(value = "Endpoints of Products")
class ProductsResource {
	
	@Autowired
	lateinit var productRepository: ProductRepository

	@PostMapping
	@ApiOperation(value = "Create Product")
    fun create(@RequestBody product: Product): Product{
        return productRepository.save(product);
    }
	
	@GetMapping
	@ApiOperation(value = "List all Products")
    fun listProducts(@RequestParam(value = "type", required = false) type: ProductType?): List<Product>? {
		
		val products: List<Product>?;
		
		if (type != null) {
			products = productRepository.findByType(type);
		} else {
			products = productRepository.findAll();
		}
		
        return products;
    }
	
}