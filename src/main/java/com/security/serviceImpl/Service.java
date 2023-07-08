package com.security.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.entities.User;
import com.security.userRepository.UserRepository;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	public List<User> getUser()
	{
		System.out.println("Service.getUser()"+repo.findAll());
		return repo.findAll();
	}
	public User createUser(User user)
	{
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User save = repo.save(user);
		
		return save;
	}
}
