package com.tushar.orderservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tushar.productservice.entity.Products;

@FeignClient(name = "productservice")
public interface ProductClient {
	
	@GetMapping("products/getById/{prod_id}")
	public Products findById(@PathVariable int prod_id);
	
}
