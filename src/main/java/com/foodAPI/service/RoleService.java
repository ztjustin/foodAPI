package com.foodAPI.service;

import java.util.List;

import com.foodAPI.entity.Role;

public interface RoleService {
	
	public abstract List<Role> getAll();
	
	public abstract Role getOne(int role_id);
	
	public abstract Role addOne(Role role);
	
	public abstract void delete(int role_id);
	
	public abstract Role getByNameRole(String role);

}
