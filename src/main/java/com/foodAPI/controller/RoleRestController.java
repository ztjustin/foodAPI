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

import com.foodAPI.entity.Role;
import com.foodAPI.service.RoleService;

@RestController
public class RoleRestController {
	
	@Autowired
	@Qualifier("roleServiceImpl")
	private RoleService roleServiceImpl;
	
	private static final Log LOG = LogFactory.getLog(RoleRestController.class);
	
	@GetMapping("/api/roles") 
	public ResponseEntity<List<Role>> getAll(){
		LOG.info("se ha obtenido a todos los roles");
		return new ResponseEntity<List<Role>>(roleServiceImpl.getAll(),HttpStatus.OK);	
	}
	
	@GetMapping("/api/roles/{roleId}")
	public  ResponseEntity<Role> findRole(@PathVariable(name = "roleId") int roleId){
		LOG.info("se ha obtenido a 1 role");
		return new ResponseEntity<Role>(roleServiceImpl.getOne(roleId),HttpStatus.OK);
	}
	
	@PostMapping("/api/roles/add")
	public  ResponseEntity<Role> addRole(@ModelAttribute(name = "role") Role role){
		LOG.info("se ha ingresado a 1 role");
		return new ResponseEntity<Role>(roleServiceImpl.addOne(role),HttpStatus.OK);
	}
	
	@PutMapping("/api/roles/update")
	public  ResponseEntity<Role> updateRole(@ModelAttribute(name = "role") Role role){
		LOG.info("se ha actualizado a 1 role");
		return new ResponseEntity<Role>(roleServiceImpl.addOne(role),HttpStatus.OK);	
	}
	
	@DeleteMapping("/api/roles/delete/{roleId}")
	public  Boolean deleteRole(@PathVariable(name = "roleId") int roleId){
		LOG.info("se ha eliminado a 1 role");
		roleServiceImpl.delete(roleId);
		return true;
	}
	
	
	

}
