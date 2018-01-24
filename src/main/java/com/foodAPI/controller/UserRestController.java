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

import com.foodAPI.entity.User;
import com.foodAPI.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
	private static final Log LOG = LogFactory.getLog(UserRestController.class);
	
	@GetMapping("/api/users") 
	public ResponseEntity<List<User>> getAll(){
		LOG.info("se ha obtenido a todos los usuarios");
		return new ResponseEntity<List<User>>(userServiceImpl.getAll(),HttpStatus.OK);	
	}
	
	@GetMapping("/api/users/{username}")
	public  ResponseEntity<User> findUser(@PathVariable(name = "username") String username){
		LOG.info("se ha obtenido a 1 usuario");
		return new ResponseEntity<User>(userServiceImpl.getOne(username),HttpStatus.OK);
	}
	
	@PostMapping("/api/users/add")
	public  ResponseEntity<User> addUser(@ModelAttribute(name = "user") User user){
		LOG.info("se ha ingresado a 1 usuario");
		return new ResponseEntity<User>(userServiceImpl.addOne(user),HttpStatus.OK);
	}
	
	@PutMapping("/api/users/update")
	public  ResponseEntity<User> updateUser(@ModelAttribute(name = "user") User user){
		LOG.info("se ha actualizado a 1 usuario");
		return new ResponseEntity<User>(userServiceImpl.addOne(user),HttpStatus.OK);	
	}
	
	@DeleteMapping("/api/users/delete/{username}")
	public  Boolean deleteUser(@PathVariable(name = "username") String username){
		LOG.info("se ha eliminado a 1 cliente");
		userServiceImpl.delete(username);
		return true;
	}
	
	

}
