package com.addeco.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.addeco.demo.entity.Product;
import com.addeco.demo.repository.CustomerRepository;
import com.addeco.demo.repository.ManuFacturerRepository;
import com.addeco.demo.repository.ProductRepository;
import com.addeco.demo.repository.ShopCartRepository;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ManuFacturerRepository manufacturerRepository;
	@Autowired
	ShopCartRepository shopcartRepository;
	
	
			//CREATE/UPDATE
			// Crea un producto nuevo
			@GetMapping("/new")
			public String createProduct(@ModelAttribute ("product") Model model) {
				model.addAttribute("product", new Product());
				// model.addAttribute("manufacturer", manufacturerRepository.findAll());
				return "product-edit";
			}
			
			
			// Guarda el producto creado
			@PostMapping
			public String crearProducto(@ModelAttribute("product") Product product) {
				productRepository.save(product);
				return "redirect:/products";
			}
			
			//RETRIEVE
			// Nos carga el producto que hemos buscado, si existe. En caso contrario, nos dará un error
			@GetMapping("/products/{id}/view")
			public String verProducto(@PathVariable Long id, Model model) {
				if(id == null) 
					return "redirect:/products";
				
				Optional<Product> productOpt = productRepository.findById(id);
				if (productOpt.isPresent()) { 
					model.addAttribute("product", productOpt.get());
					return "product-view";
				} else {
				model.addAttribute("error", "No existe el producto solicitado");
				return "redirect:/products";
				}
			}
			
			// Encuentra todos los productos
			@GetMapping({"/products", "/"})
			public String findAll(Model model) {
				model.addAttribute("products", productRepository.findAll());
				return "product-list";
			}
				
				// Busca la ID del producto para editarlo. En caso contrario, nos dará un error.
				@GetMapping("/products/{id}/edit")
				public String editarProducto(@PathVariable Long id, Model model) {
					if(id == null) 
						return "redirect:/products";
					
					Optional<Product> productOpt = productRepository.findById(id);
					if (productOpt.isPresent()) { 
						model.addAttribute("product", productOpt.get());
						return "product-edit";
					} else {
					model.addAttribute("error", "No existe el producto solicitado");
					return "redirect:/products";
					}
					
				}
				
				// DELETE
				// Borra el producto que corresponda con la ID seleccionada
				@GetMapping("/{id}/delete")
				public String borrarProducto(@PathVariable Long id) {
					productRepository.deleteById(id);
					return "redirect:/products";
				}
				
				// Borra todos los productos
				@GetMapping("/delete/all")
				public String borrarProductos() {
					productRepository.deleteAll();
					return "redirect:/products";
				}
	
}
