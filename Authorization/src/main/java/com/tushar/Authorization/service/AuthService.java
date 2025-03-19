package com.tushar.Authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.tushar.Authorization.entity.UserCredentials;
import com.tushar.Authorization.repository.UserCredentialRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserCredentialRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private JwtService service;
	
	public void saveUser(UserCredentials user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);
		
	}
	
	public String generateToken(String username)
	{
		return service.generateToken(username);
		
	}
	
	public void validateToken(String token)
	{
		service.validateToken(token);
	}

}
