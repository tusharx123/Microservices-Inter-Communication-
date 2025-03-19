package com.tushar.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	private int user_id;
	private String username;
	private String email;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Users(int user_id, String username, String email) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", email=" + email + "]";
	}
	
	
	

}
