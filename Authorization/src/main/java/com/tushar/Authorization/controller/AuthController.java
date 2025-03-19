package com.tushar.Authorization.controller;

import java.net.Authenticator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.Authorization.entity.UserCredentials;
import com.tushar.Authorization.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	
	@Autowired
	private AuthService service;
	
	@Autowired
	private AuthenticationManager authentication;
	
	@PostMapping("/register")
	public String addNewUser(@RequestBody UserCredentials user)
	{
		service.saveUser(user);
		return "User added successfully";
	}

	@PostMapping("/getToken")
	public String generateToken(@RequestBody UserCredentials user)
	{
		Authentication authenticate = authentication.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
		if(authenticate.isAuthenticated())
		{
			return service.generateToken(user.getName());
		}
		else
		{
			throw new RuntimeException("Invalid access"); 
		}

	}
	
	 @GetMapping("/validate")
	    public ResponseEntity<String> validateToken(@RequestParam("token") String token) {
	        try {
	            service.validateToken(token);
	            return ResponseEntity.ok("Token is valid");
	        } catch (Exception e) {
	            return ResponseEntity.status(403).body("Invalid or expired token");
	        }
	    }
	

}
