package com.tushar.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tushar.productservice.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
