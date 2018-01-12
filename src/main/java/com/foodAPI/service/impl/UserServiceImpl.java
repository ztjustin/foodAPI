package com.foodAPI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.foodAPI.entity.User;
import com.foodAPI.repository.UserJpaRepository;
import com.foodAPI.service.UserService;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userJpaRepository")
	private UserJpaRepository userJpaRepository;

	@Override
	public List<User> getAll() {
		return userJpaRepository.findAll();
	}

	@Override
	public User getOne(String username) {
		return userJpaRepository.getOne(username);
	}

	@Override
	public User addOne(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userJpaRepository.saveAndFlush(user);
	}

	@Override
	public void delete(String username) {
		userJpaRepository.delete(username);
	}

}

