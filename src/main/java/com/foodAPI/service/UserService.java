package com.foodAPI.service;

import java.util.List;

import com.foodAPI.entity.User;

public interface UserService{
	
	public abstract List<User> getAll();
	
	public abstract User getOne(String username);
	
	public abstract User addOne(User user);
	
	public abstract void delete(String username);
	
}
