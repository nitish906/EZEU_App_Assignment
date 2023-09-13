package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.User;
import com.masai.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices services;
	
	
	@PostMapping("/user")
	public ResponseEntity<User> createUserHandler(@RequestBody User user){
		
		User findUser= services.saveusUser(user);
		
		return new ResponseEntity<User>(findUser, HttpStatus.CREATED);
		
	}

}
