package com.tushar.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tushar.userservice.entity.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}
