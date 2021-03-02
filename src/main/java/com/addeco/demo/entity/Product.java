package com.addeco.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



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
	
	@Column(length = 45, nullable = true)
	private String logo;
	

	@ManyToOne
	@JoinColumn(name = "id_manufacturer")
	private Manufacturer manufacturer;



	@ManyToMany(mappedBy="products")
	private List<Customer> customers = new ArrayList<>();

	

	

	public Product(String name, String description, Manufacturer manufacturer, Integer quantity, Double price,
			List<Customer> customers) {
		super();
		this.name = name;
		this.description = description;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.price = price;
		this.customers = customers;
		
	}

	public Product() {

	}

	
	public Product(String name, String description, Integer quantity, Double price, Manufacturer manufacturer) {
		super();
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

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
	@Override
	public String toString() {
		return "Product [id: " + id + ", name: " + name + ", description: " + description + ", manufacturer: " + manufacturer.getName() +
				", quantity: " + quantity + ", price: " + price + ", customers: " + customers + "]";
	}
	

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Transient
	public String getProductImagePath() {
		if (logo == null || id == null) return null;
		
		return "/product-logos/" + id + "/" + logo;
	}
	

}
