package com.foodAPI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.foodAPI.entity.Client;
import com.foodAPI.repository.ClientJpaRepository;
import com.foodAPI.service.ClientService;


@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	@Qualifier("clientJpaRepository")
	private ClientJpaRepository clientJpaRepository;
	
	@Override
	public List<Client> getAll() {
		return clientJpaRepository.findAll();
	}

	@Override
	public Client getOne(Long phone) {
		return clientJpaRepository.findOne(phone);
	}

	@Override
	public Client addOne(Client client) {
		return clientJpaRepository.save(client);
	}

	@Override
	public void delete(Long phone) {
		clientJpaRepository.delete(phone);
	}

	@Override
	public boolean Exists(int phone) {
		// TODO Auto-generated method stub
		return clientJpaRepository.exists(phone);
	}

}
