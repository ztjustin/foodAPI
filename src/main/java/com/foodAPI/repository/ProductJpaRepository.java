package com.foodAPI.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodAPI.entity.Product;

@Repository("productJpaRepository")
public interface ProductJpaRepository extends JpaRepository<Product, Serializable>{
	
}
