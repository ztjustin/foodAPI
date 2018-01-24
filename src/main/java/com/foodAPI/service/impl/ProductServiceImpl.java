package com.foodAPI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.foodAPI.entity.Product;
import com.foodAPI.repository.ProductJpaRepository;
import com.foodAPI.service.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	@Qualifier("productJpaRepository")
	private ProductJpaRepository productJpaRepository;
	
	@Override
	public List<Product> getAll() {
		return productJpaRepository.findAll();
	}

	@Override
	public Product getOne(int product_id) {
		return productJpaRepository.getOne(product_id);
	}

	@Override
	public Product addOne(Product product) {
		return productJpaRepository.saveAndFlush(product);
	}

	@Override
	public void delete(int product_id) {
		productJpaRepository.delete(product_id);
	}
	
	

}
