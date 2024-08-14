package com.ensemblemaman.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensemblemaman.api.entities.User;
import com.ensemblemaman.api.repository.UserRepository;
import com.ensemblemaman.api.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
    UserService userService;
    

    @GetMapping("all")
	public List<User> getAllEmployees() {
		List<User> users= userService.getAllUsers();
		return users;
	}
}