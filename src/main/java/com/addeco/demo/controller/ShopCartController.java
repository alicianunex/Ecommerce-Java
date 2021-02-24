package com.addeco.demo.controller;


import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.addeco.demo.entity.Product;
import com.addeco.demo.entity.ShopCart;
import com.addeco.demo.repository.CustomerRepository;
import com.addeco.demo.repository.ProductRepository;
import com.addeco.demo.repository.ShopCartRepository;






@Controller
public class ShopCartController {


	
	@Autowired
CustomerRepository customerrepo;
	
	@Autowired
ShopCartRepository shopcartrepo;
	
	@Autowired
ProductRepository	productrepo;
	
	
	
		@GetMapping("/shopcarts/{id}/addproduct")
		public String addToShopCart(@PathVariable Long id, Model model, HttpSession session) {
			
			ShopCart shopcart = (ShopCart) session.getAttribute("shopcart");
			if (shopcart == null) {
				
				shopcart = new ShopCart();
			}
			
			
			Optional<Product> productOpt = productrepo.findById(id);
			if (productOpt.isPresent()) { // If movie exists then add it to shopcart
				Product product = productOpt.get();
				
				if (!shopcart.getProduct().contains(product)) {
					shopcart.getProduct().add(product);
				}
			}
			
			session.setAttribute("shopcart", shopcart);
			
			model.addAttribute("shopcart_items", shopcart.getProduct().size());
			model.addAttribute("products", productrepo.findAll());

			return "product-list";
	}
	
	
}