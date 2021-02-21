package com.addeco.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String description;
	private Integer quantity;
	private Double price;

	@ManyToOne
	@JoinColumn(name = "id_manufacturer")
	private Manufacturer manufacturer;

	@ManyToMany(mappedBy = "product")
	private List<ShopCart> shopcart;

	@ManyToMany
	@JoinTable(name = "product_customer", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
	private List<Customer> customers = new ArrayList<>();

	public List<Customer> getCustomer() {
		return customers;
	}

	public void setCustomer(List<Customer> customer) {
		this.customers = customer;
	}

	public Product() {

	}

	public Product(String name, String description, Integer quantity, Double price, Manufacturer manufacturer) {

		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.manufacturer = manufacturer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<ShopCart> getShopcart() {
		return shopcart;
	}

	public void setShopcart(List<ShopCart> shopcart) {
		this.shopcart = shopcart;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", price=" + price + ", manufacturer=" + manufacturer + ", shopcart=" + shopcart + "]";
	}

}
