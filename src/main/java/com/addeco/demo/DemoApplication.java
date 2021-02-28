package com.addeco.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import com.addeco.demo.entity.Customer;
import com.addeco.demo.entity.Manufacturer;
import com.addeco.demo.entity.Product;
import com.addeco.demo.entity.ShopCart;
import com.addeco.demo.repository.CustomerRepository;
import com.addeco.demo.repository.ManuFacturerRepository;
import com.addeco.demo.repository.ProductRepository;
import com.addeco.demo.repository.ShopCartRepository;


@SpringBootApplication
//	@ComponentScan(basePackageClasses=ProductController.class)
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ManuFacturerRepository manufacturerRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ShopCartRepository shopcartRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		
		Customer customer1 = new Customer("ayman", "cl rio escudo", "a@a", "1234", "633258741", "aymansalem");
		Manufacturer Amazon=new Manufacturer("84277777","apple","cl madrid plaza",1000);
		manufacturerRepository.save(Amazon);
		Product product1 = new Product("Nokia", "Mobil indestructible", 1, 25.99, null);
		product1.setManufacturer(Amazon);
		productRepository.save(product1);
		
		
		
		
		Customer customer2 = new Customer("ayman", "cl rio escudo", "a@a", "1234", "633258741", "aymansalem");
		Manufacturer Ebay=new Manufacturer("84277777","apple","cl madrid plaza",1000);
		manufacturerRepository.save(Ebay);
		Product product5 = new Product("Iphone 7", "new versions with 3 ram", 6, 300.05,Ebay);
		Product product6 = new Product("Iphone 8", "new versions with 1 ram", 7, 600.05,Ebay);
		Product product7 = new Product("Iphone 9", "new versions with 8 ram", 3, 310.05,Ebay);
		Product product8 = new Product("Iphone 6", "new versions with 6 ram", 22, 320.15,Ebay);
		product5.setManufacturer(Ebay);
		product6.setManufacturer(Ebay);
		product7.setManufacturer(Amazon);
		product8.setManufacturer(Ebay);
		
		productRepository.save(product5);
		productRepository.save(product6);
		productRepository.save(product7);
		productRepository.save(product8);
	 
		
        
		

	}

}
