package com.tushar.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.productservice.entity.Products;
import com.tushar.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/getAllProducts")
	public List<Products> getAllProducts()
	{
		return repo.findAll();
	}
	
	@PostMapping("/addProduct")
	public void addProduct(@RequestBody Products product)
	{
		repo.save(product);
	}
	
	@GetMapping("/getById/{prod_id}")
	public Products findById(@PathVariable int prod_id)
	{
		return repo.findById(prod_id).get();
	}

}
