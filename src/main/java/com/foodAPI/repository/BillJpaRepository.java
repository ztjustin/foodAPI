package com.foodAPI.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodAPI.entity.Bill;

@Repository("billJpaRepository")
public interface BillJpaRepository extends JpaRepository<Bill, Serializable> {
	
	public Bill findByBillId(Long billId);
	
}
