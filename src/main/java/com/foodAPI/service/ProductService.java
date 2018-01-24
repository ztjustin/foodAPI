package com.foodAPI.service;

import java.util.List;

import com.foodAPI.entity.Product;

public interface ProductService {
	
	public abstract List<Product> getAll();
	
	public abstract Product getOne(Long productId);
	
	public abstract Product addOne(Product product);
	
	public abstract void delete(long productId);
	
}
