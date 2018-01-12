package com.foodAPI.service;

import java.util.List;

import com.foodAPI.entity.Client;

public interface ClientService {
	
	public abstract List<Client> getAll();
	
	public abstract Client getOne(Long phone);
	
	public abstract Client addOne(Client client);
	
	public abstract void delete(Long phone);
	
	public abstract boolean Exists(int phone);
	
}
