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
		
		// Usuario de pruebas
		Customer customer1 = new Customer("ayman", "cl rio escudo", "a@a", "1234", "633258741", "aymansalem");
		customerRepository.save(customer1);
		
		Manufacturer manufacturer1 = new Manufacturer("012345V", "Vodaphone", "C/Mobiles 175, Madrid", 200);
		manufacturerRepository.save(manufacturer1);
		Manufacturer manufacturer2 = new Manufacturer("012345M", "Movistar", "C/Mobiles 176, Madrid", 200);
		manufacturerRepository.save(manufacturer2);
		
	}

}
