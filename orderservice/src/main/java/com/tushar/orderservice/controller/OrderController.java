package com.tushar.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.orderservice.entity.Orders;
import com.tushar.orderservice.feignclient.ProductClient;
import com.tushar.orderservice.feignclient.UserClient;
import com.tushar.orderservice.repository.OrdersRepository;
import com.tushar.productservice.entity.Products;
import com.tushar.userservice.entity.Users;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private UserClient user;
	@Autowired
	private ProductClient product;
	
	@Autowired
	private OrdersRepository order;
	
	@PostMapping("/addOrder/{user_id}/{prod_id}")
	public void addOrder(@PathVariable int user_id, @PathVariable int prod_id)
	{
		Users users = user.getById(user_id);
		Products prod = product.findById(prod_id);
		Orders obj = new Orders();
		obj.setProd_id(prod.getProd_id());
		obj.setProd_name(prod.getProd_name());
		obj.setUser_id(users.getUser_id());
		obj.setUsername(users.getUsername());
		order.save(obj);
		
	}
	@GetMapping("/getAllOrders")
	public List<Orders> getAllOrders()
	{
		return order.findAll();
	}
	

}
