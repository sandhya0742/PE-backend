package com.arshaa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshaa.entity.User;
import com.arshaa.repository.UserRepository;

@Service
public class UserService {

	@Autowired(required = true)
	private UserRepository repository;

	public List<User> findUsers() {
		return repository.findAll();
	}

	public void save(User user) {
		repository.save(user);
	}
}
