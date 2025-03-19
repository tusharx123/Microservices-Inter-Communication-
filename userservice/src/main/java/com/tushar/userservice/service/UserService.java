package com.tushar.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.userservice.entity.Users;
import com.tushar.userservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

    public List<Users> getAllUsers() {
        return repo.findAll();
    }

    public Users addUser(Users user) {
        return repo.save(user);
    }

    public Users getUserById(int id) {
        return repo.findById(id).get();
    }

}
