package com.tushar.Authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tushar.Authorization.entity.UserCredentials;
@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredentials, Integer>{
	UserCredentials findByName(String username);
}
