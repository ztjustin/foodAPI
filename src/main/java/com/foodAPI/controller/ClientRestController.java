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

import com.foodAPI.entity.Client;
import com.foodAPI.service.ClientService;


@RestController
public class ClientRestController {
	
	@Autowired
	@Qualifier("clientServiceImpl")
	private ClientService clientServiceImpl;
	
	private static final Log LOG = LogFactory.getLog(ClientRestController.class);
	
	@GetMapping("/api/clients") 
	public ResponseEntity<List<Client>> getAll(){
		LOG.info("se ha obtenido a todos los clientes");
		return new ResponseEntity<List<Client>>(clientServiceImpl.getAll(),HttpStatus.OK);	
	}
	
	@GetMapping("/api/clients/{phone}")
	public  ResponseEntity<Client> findClient(@PathVariable(name = "phone") Long phone){
		LOG.info("se ha obtenido a 1 cliente");
		return new ResponseEntity<Client>(clientServiceImpl.getOne(phone),HttpStatus.OK);
	}
	
	@PostMapping("/api/clients/add")
	public  ResponseEntity<Client> addClient(@ModelAttribute(name = "client") Client client){
		LOG.info("se ha ingresado a 1 cliente");
		return new ResponseEntity<Client>(clientServiceImpl.addOne(client),HttpStatus.OK);
	}
	
	@PutMapping("/api/clients/update")
	public  ResponseEntity<Client> updateClient(@ModelAttribute(name = "client") Client client){
		LOG.info("se ha actualizado a 1 cliente");
		return new ResponseEntity<Client>(clientServiceImpl.addOne(client),HttpStatus.OK);	
	}
	
	@DeleteMapping("/api/clients/delete/{phone}")
	public  Boolean deleteClient(@PathVariable(name = "id") Long phone){
		LOG.info("se ha eliminado a 1 cliente");
		clientServiceImpl.delete(phone);
		return true;
	}
	
	
}
