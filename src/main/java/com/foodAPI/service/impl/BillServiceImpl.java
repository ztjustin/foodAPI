package com.foodAPI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.foodAPI.entity.Bill;
import com.foodAPI.repository.BillJpaRepository;
import com.foodAPI.service.BillService;

@Service("billServiceImpl")
public class BillServiceImpl implements BillService {
	
	@Autowired
	@Qualifier("billJpaRepository")
	private BillJpaRepository billJpaRepository;

	@Override
	public List<Bill> getAll() {
		// TODO Auto-generated method stub
		return billJpaRepository.findAll();
	}

	@Override
	public Bill getOne(Long billId) {
		// TODO Auto-generated method stub
		return billJpaRepository.findByBillId(billId);
	}

	@Override
	public Bill addOne(Bill bill) {
		// TODO Auto-generated method stub
		return billJpaRepository.saveAndFlush(bill);
	}

	@Override
	public void delete(Long billId) {
		// TODO Auto-generated method stub
		billJpaRepository.delete(billId);
	}

	@Override
	public boolean Exists(Long billId) {
		// TODO Auto-generated method stub
		return billJpaRepository.exists(billId);
	}

}
