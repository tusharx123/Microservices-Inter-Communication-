package com.tushar.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.userservice.entity.Users;
import com.tushar.userservice.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/getAllUsers")
	public List<Users> getUsers()
	{
		return repo.findAll();
		
	}
	@PostMapping("/addUser")
	public void addUser(@RequestBody Users user)
	{
		repo.save(user);
	}
	@GetMapping("/getById/{user_id}")
	public Users getById(@PathVariable int user_id)
	{
		return repo.findById(user_id).get();
		
	}
	

}
