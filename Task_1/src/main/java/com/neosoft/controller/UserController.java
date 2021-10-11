package com.neosoft.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.entity.User;
import com.neosoft.service.UserService;

@RestController
public class UserController {

	 @Autowired
	 private UserService userService;
	 
	 // used on a method that needs to be executed after dependency injection 
	 // is done to perform any initialization.
	 
	 @PostConstruct
	 public void initRoleAndUser() 
	 {
	    userService.initRoleAndUser();
	 }
	 
	 // http://localhost:8080/registerNewUser
	 @PostMapping({"/registerNewUser"})
	 public User registerNewUser(@RequestBody User user) 
	 {
	    return userService.registerNewUser(user);
	 }
}
