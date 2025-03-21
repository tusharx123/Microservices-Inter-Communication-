package com.tushar.orderservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tushar.userservice.entity.Users;


@FeignClient(name = "userservice")
public interface UserClient {
	
	@GetMapping("users/getById/{user_id}")
	public Users getById(@PathVariable int user_id);
	
}
