package com.foodAPI.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodAPI.entity.Client;


@Repository("clientJpaRepository")
public interface ClientJpaRepository extends JpaRepository<Client, Serializable> {
	
	public Client findByName(String clientname);
	
}
