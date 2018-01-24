package com.foodAPI.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodAPI.entity.Product;
import com.foodAPI.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productServiceImpl;
	
	private static final Log LOG = LogFactory.getLog(ProductRestController.class);
	
	@GetMapping("/api/products")
	public ResponseEntity<List<Product>> getAll(){
		LOG.info("se ha obtenido a todos los productos");
		return new ResponseEntity<List<Product>>(productServiceImpl.getAll(),HttpStatus.OK);	
	}
	
	@GetMapping("/api/products/{productId}")
	public  ResponseEntity<Product> findProduct(@PathVariable(name = "productId") Long productId){
		LOG.info("se ha obtenido a 1 producto");
		return new ResponseEntity<Product>(productServiceImpl.getOne(productId),HttpStatus.OK);
	}
	
	@PostMapping("/api/products/add")
	public  ResponseEntity<Product> addProduct(@ModelAttribute(name = "product") Product product){
		LOG.info("se ha ingresado a 1 producto");
		return new ResponseEntity<Product>(productServiceImpl.addOne(product),HttpStatus.OK);
	}
	
	@PutMapping("/api/products/update")
	public  ResponseEntity<Product> updateProduct(@ModelAttribute(name = "product") Product product){
		LOG.info("se ha actualizado a 1 producto");
		return new ResponseEntity<Product>(productServiceImpl.addOne(product),HttpStatus.OK);	
	}
	
	@DeleteMapping("/api/products/delete/{productId}")
	public  Boolean deleteProduct(@PathVariable(name = "productId") Long productId){
		LOG.info("se ha eliminado a 1 producto");
		productServiceImpl.delete(productId);
		return true;
	}

}
