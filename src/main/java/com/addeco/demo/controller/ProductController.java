package com.addeco.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.addeco.demo.repository.CustomerRepository;
import com.addeco.demo.repository.ProductRepository;
import com.addeco.demo.repository.ShopCartRepository;



@Controller
public class ProductController {
	@Autowired
CustomerRepository customerrepo;
	
	@Autowired
ShopCartRepository shopcartrepo;
	
	@Autowired
   ProductRepository productrepo;
	
	
	@GetMapping("/products")
	public String findAll(Model model) {
		model.addAttribute("products", productrepo.findAll());
		return "product-list";
	
}

}