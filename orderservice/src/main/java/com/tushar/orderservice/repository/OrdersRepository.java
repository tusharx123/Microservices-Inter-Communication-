package com.tushar.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tushar.orderservice.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	

}
