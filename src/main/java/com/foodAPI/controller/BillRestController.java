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

import com.foodAPI.entity.Bill;
import com.foodAPI.service.BillService;

@RestController
public class BillRestController {
	
	@Autowired
	@Qualifier("billServiceImpl")
	private BillService billServiceImpl;
	
	private static final Log LOG = LogFactory.getLog(BillRestController.class);
	
	@GetMapping("/api/bills") 
	public ResponseEntity<List<Bill>> getAll(){
		LOG.info("se ha obtenido a todos las facturas");
		return new ResponseEntity<List<Bill>>(billServiceImpl.getAll(),HttpStatus.OK);	
	}
	
	@GetMapping("/api/bills/{billId}")
	public  ResponseEntity<Bill> findBill(@PathVariable(name = "billId") Long billId){
		LOG.info("se ha obtenido a 1 factura");
		return new ResponseEntity<Bill>(billServiceImpl.getOne(billId),HttpStatus.OK);
	}
	
	@PostMapping("/api/bills/add")
	public  ResponseEntity<Bill> addBill(@ModelAttribute(name = "bill") Bill bill){
		LOG.info("se ha ingresado a 1 factura");
		return new ResponseEntity<Bill>(billServiceImpl.addOne(bill),HttpStatus.OK);
	}
	
	@PutMapping("/api/bills/update")
	public  ResponseEntity<Bill> updateBill(@ModelAttribute(name = "bill") Bill bill){
		LOG.info("se ha actualizado a 1 factura");
		return new ResponseEntity<Bill>(billServiceImpl.addOne(bill),HttpStatus.OK);	
	}
	
	@DeleteMapping("/api/bills/delete/{billId}")
	public  Boolean deleteBill(@PathVariable(name = "billId") Long billId){
		LOG.info("se ha eliminado a 1 factura");
		billServiceImpl.delete(billId);
		return true;
	}

}
