package com.tushar.userservice.controller;

import java.util.List;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.userservice.entity.Users;
import com.tushar.userservice.repository.UserRepository;
import com.tushar.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/getAllUsers")
	public List<Users> getUsers()
	{
		
		System.out.println("Running on port: "+port);
		return service.getAllUsers();
		
	}
	@PostMapping("/addUser")
	public void addUser(@RequestBody Users user)
	{
		service.addUser(user);
	}
	@GetMapping("/getById/{user_id}")
	public Users getById(@PathVariable int user_id)
	{
		System.out.println("Running on port: "+port);
		return service.getUserById(user_id);
		
	}
	

}
