package com.foodAPI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.foodAPI.entity.Role;
import com.foodAPI.repository.RoleJpaRepository;
import com.foodAPI.service.RoleService;


@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	@Qualifier("roleJpaRepository")
	private RoleJpaRepository roleJpaRepository;

	@Override
	public List<Role> getAll() {
		return roleJpaRepository.findAll();
	}

	@Override
	public Role getOne(int role_id) {
		return roleJpaRepository.getOne(role_id);
	}

	@Override
	public Role addOne(Role role) {
		return roleJpaRepository.saveAndFlush(role);
	}

	@Override
	public void delete(int role_id) {
		roleJpaRepository.delete(role_id);
		
	}

	@Override
	public Role getByNameRole(String role) {
		return roleJpaRepository.findByName(role);
	}

}
