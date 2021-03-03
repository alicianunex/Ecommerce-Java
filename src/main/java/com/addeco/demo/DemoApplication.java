package com.addeco.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.addeco.demo.entity.Customer;
import com.addeco.demo.entity.Manufacturer;
import com.addeco.demo.entity.Product;
import com.addeco.demo.entity.ShopCart;
import com.addeco.demo.repository.CustomerRepository;
import com.addeco.demo.repository.ManuFacturerRepository;
import com.addeco.demo.repository.ProductRepository;
import com.addeco.demo.repository.ShopCartRepository;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customrepository;

	@Autowired
	ManuFacturerRepository manurepository;

	@Autowired
	ProductRepository productrepositoy;

	@Autowired
	ShopCartRepository shopcartrepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Manufacturer Amazon=new Manufacturer("84277777","apple","cl madrid plaza",1000);
		manurepository.save(Amazon);
		Product product1 = new Product("Iphone 12", "new versions with 8 ram", 3, 500.05,"img/banner.jpg");
		//product1.setUrlImg("1.png");
		Product product2 = new Product("Iphone 11", "new versions with 6 ram", 2, 400.0,Amazon);
		product2.setUrlImg("2.png");

		List<Product> products = Arrays.asList(product1, product2);
		Amazon.setProducts(products);
		productrepositoy.saveAll(products);
		Customer customer1 = new Customer("ayman", "cl rio escudo", "a@a", "1234", "633258741", "aymansalem",products);
		customrepository.save(customer1);
//		ShopCart shopcart1=new ShopCart();
//		shopcart1.setProducts(Arrays.asList(product1, product2));
//		shopcart1.setCustomers(customer1);
//		shopcartrepository.save(shopcart1);
		
//		Customer customer1 = new Customer("ayman", "cl rio escudo", "a@a", "1234", "633258741", "aymansalem");
//		Customer customer2 = new Customer("ayman", "cl rio escudo", "a@aa", "1234", "633258741", "ayman");
//		List<Customer> customer = Arrays.asList(customer1,customer2);
//		customrepository.saveAll(customer);
//		Manufacturer Amazon=new Manufacturer("84277777","apple","cl madrid plaza",1000);
//		manurepository.save(Amazon);
//		Product product1 = new Product("Iphone 12", "new versions with 8 ram", 3, 500.05);
//	    product1.getCustomers().add(customer1);
//		Product product2 = new Product("Iphone 11", "new versions with 6 ram", 2, 400.0);
//		Product product3 = new Product("Iphone 10", "new versions with 4 ram", 4, 350.00);
//		Product product4 = new Product("Iphone 9", "new versions with 4 ram", 6, 300.15);
//		Product product5 = new Product("Iphone 7", "new versions with 3 ram", 6, 300.05);
//		Product product6 = new Product("Iphone 8", "new versions with 1 ram", 7, 600.05);
//		Product product7 = new Product("Iphone 9", "new versions with 8 ram", 3, 310.05);
//		Product product8 = new Product("Iphone 6", "new versions with 6 ram", 22, 320.15);
//		
//		List<Product> products = Arrays.asList(product1, product2, product3, product4,product5,product6,product7,product8);
//		customer1.setProducts(products);
//		
//		
//
//		productrepositoy.saveAll(products);
//		
//		
//		Amazon.setProducts(products);
//		
//		
//		
//		//     *****       *************/
//		
//		//Customer customer2 = new Customer("ayman", "cl rio escudo", "a@aa", "1234", "633258741", "aymansalem");
//		Manufacturer Ebay=new Manufacturer("84277777","apple","cl madrid plaza",1000);
//		manurepository.save(Ebay);
//		
//		
//		
//		
//
//		ShopCart cart1 = new ShopCart();
//	
//	cart1.setProducts(products);
//		
//		product1.setCustomers(customer);
//		
//		cart1.setCustomers(customer1);
//		
//		shopcartrepository.save(cart1);			
		
		
        
		

	}

}
