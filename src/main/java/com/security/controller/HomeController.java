package com.security.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entities.User;
import com.security.serviceImpl.Service;
import com.security.serviceImpl.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Service service;
	
	@GetMapping("/user")
	public ResponseEntity<?> getUser()
	{
		
		List<User> user = this.service.getUser();
		
		if(user==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Null Record");
		}	
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body(this.service.getUser());
		}
		//return this.service.getUser();
	}
	@GetMapping("/current_user")
	public String getLoggedInUser(Principal principal)
	{
		System.out.println("Current User is "+principal.getName());
		return principal.getName();
	}
}