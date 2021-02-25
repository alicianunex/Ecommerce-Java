package com.addeco.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.addeco.demo.entity.Customer;
import com.addeco.demo.entity.Product;
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
	public String findproducts(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		if(customer != null)
			model.addAttribute("customer", customer);
		model.addAttribute("products", productrepo.findAll());
		return "product-list";
	}
	
	
	@GetMapping("/userproducts")
	public String findUserProducts(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		if(customer != null)
			model.addAttribute("customer", customer);
		model.addAttribute("products", productrepo.findAllByCustomersId(customer.getId()));
		return "product-list";
	}
	
	
	@GetMapping("/products/{id}/view")
	public String viewProduct(@PathVariable Long id, Model model) {
		Optional<Product> productOpt = productrepo.findById(id);
		if (!productOpt.isPresent()) {
			model.addAttribute("error", "ID product not found.");
			model.addAttribute("products", productrepo.findAll());
			return "product-list";
		}
		model.addAttribute("product", productOpt.get());
		return "product-view";
	}
	
	@GetMapping("/products/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "product-edit";
		
	}
	
	
	@GetMapping("/products/{id}/edit")
	public String editProduct(@PathVariable Long id, Model model) {
		model.addAttribute("product", productrepo.findById(id).get());
		return "product-edit";
		
	}
	
	@PostMapping("/products")
	public String saveProduct(@ModelAttribute("product") Product product) {
		System.out.println(product);
		productrepo.save(product);
		return "redirect:/products";
	}
	
	
	@GetMapping("/products/{id}/delete")
	public String Product(@PathVariable Long id) {
		productrepo.deleteById(id);
		return "redirect:/products";
	}
	
	@GetMapping("/products/delete")
	public String deleteProducts() {
		productrepo.deleteAll();
		return "redirect:/products";
	}
	
	@GetMapping("/products/{code}/search")
	public String searchProductByCode(@PathVariable Integer code, Model model) {
		model.addAttribute("products", productrepo.findAllByCode(code));
		return "product-list";
		
	}
	
	
	

}