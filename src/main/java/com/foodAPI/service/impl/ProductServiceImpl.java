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
	public Product getOne(Long productId) {
		return productJpaRepository.getOne(productId);
	}

	@Override
	public Product addOne(Product product) {
		return productJpaRepository.saveAndFlush(product);
	}

	@Override
	public void delete(long productId) {
		productJpaRepository.delete(productId);
	}
	




}
