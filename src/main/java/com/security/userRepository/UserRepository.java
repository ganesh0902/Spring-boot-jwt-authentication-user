package com.security.userRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entities.User;

public interface UserRepository extends JpaRepository<User,String>{

	public Optional<User> findByEmail(String email);
}