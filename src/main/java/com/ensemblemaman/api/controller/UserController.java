package com.ensemblemaman.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensemblemaman.api.model.User;
import com.ensemblemaman.api.repository.UserRepository;
import com.ensemblemaman.api.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
    UserService userService;
    

    @GetMapping("/users")
	public List<User> getAllEmployees() {
		List<User> users= userService.getAllUsers();
		return users;
	}
}