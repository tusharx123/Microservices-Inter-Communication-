package com.tushar.Authorization.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tushar.Authorization.entity.UserCredentials;

public class UserPrincipal implements UserDetails {
	
	private UserCredentials credential;
	public UserPrincipal(UserCredentials credential)
	{
		this.credential = credential;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return credential.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return credential.getName();
	}

}
