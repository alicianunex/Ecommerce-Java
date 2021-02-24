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
		Customer customer1 = new Customer("ayman", "cl rio escudo", "a@a", "1234", "633258741", "aymansalem");
		Manufacturer Amazon=new Manufacturer("84277777","apple","cl madrid plaza",1000);
		manurepository.save(Amazon);
		Product product1 = new Product("Iphone 12", "new versions with 8 ram", 3, 500.05,Amazon);
		Product product2 = new Product("Iphone 11", "new versions with 6 ram", 2, 400.05,Amazon);
		Product product3 = new Product("Iphone 10", "new versions with 4 ram", 4, 350.05,Amazon);
		Product product4 = new Product("Iphone 9", "new versions with 4 ram", 6, 300.15,Amazon);
		List<Product> products1 = Arrays.asList(product1, product2, product3, product4);
		Amazon.setProducts(products1);
		productrepositoy.saveAll(products1);
		
		
		//            *************/
		
		Customer customer2 = new Customer("ayman", "cl rio escudo", "a@a", "1234", "633258741", "aymansalem");
		Manufacturer Ebay=new Manufacturer("84277777","apple","cl madrid plaza",1000);
		manurepository.save(Ebay);
		Product product5 = new Product("Iphone 7", "new versions with 3 ram", 6, 300.05,Ebay);
		Product product6 = new Product("Iphone 8", "new versions with 1 ram", 7, 600.05,Ebay);
		Product product7 = new Product("Iphone 9", "new versions with 8 ram", 3, 310.05,Ebay);
		Product product8 = new Product("Iphone 6", "new versions with 6 ram", 22, 320.15,Ebay);
		List<Product> products2 = Arrays.asList(product5, product6, product7, product8);
		
		Ebay.setProducts(products2);
		
		productrepositoy.saveAll(products2);

		ShopCart cart1 = new ShopCart();
		ShopCart cart2 = new ShopCart();
		cart1.setProduct(products1);
		cart2.setProduct(products2);
		customer1.setProduct(products1);
		customer2.setProduct(products2);
		customrepository.save(customer1);
		customrepository.save(customer2);
		cart1.setCustomer(customer1);
		cart2.setCustomer(customer2);
		shopcartrepository.save(cart1);			
		shopcartrepository.save(cart2);	 
		
        
		

	}

}
