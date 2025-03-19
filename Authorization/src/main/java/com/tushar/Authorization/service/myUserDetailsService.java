package com.tushar.Authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tushar.Authorization.entity.UserCredentials;
import com.tushar.Authorization.repository.UserCredentialRepository;
@Service
public class myUserDetailsService implements UserDetailsService {
	
	@Autowired
	private  UserCredentialRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserCredentials credential = repository.findByName(username);
		if(credential == null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		return new UserPrincipal(credential);
	}

}
