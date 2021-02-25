package com.addeco.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



@Entity
@Table(name = "shopcart")
public class ShopCart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	

	@ManyToMany
	@JoinTable(name = "product_shopcart",
	joinColumns = @JoinColumn(name = "shopcart_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	private List<Product> product = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customers;

	
	
	public ShopCart() {
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public List<Product> getProduct() {
		return product;
	}



	public void setProduct(List<Product> product) {
		this.product = product;
	}



	public Customer getCustomers() {
		return customers;
	}



	public void setCustomers(Customer customers) {
		this.customers = customers;
	}



	@Override
	public String toString() {
		return "ShopCart [id=" + id + ", product=" + product + ", customers=" + customers + "]";
	}
	
	

	
	
	

    






}
