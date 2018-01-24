package com.foodAPI.service;

import java.util.List;

import com.foodAPI.entity.Bill;

public interface BillService {
	
	public abstract List<Bill> getAll();
	
	public abstract Bill getOne(Long billId);
	
	public abstract Bill addOne(Bill bill);
	
	public abstract void delete(Long billId);
	
	public abstract boolean Exists(Long billId);

}
