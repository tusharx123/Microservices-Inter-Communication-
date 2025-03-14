package com.tushar.productservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Products {
	@Id
	private int prod_id;
	private String prod_name;
	private double price;
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [prod_id=" + prod_id + ", prod_name=" + prod_name + ", price=" + price + "]";
	}
	
	
}
