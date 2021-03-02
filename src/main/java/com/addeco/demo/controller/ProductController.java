package com.addeco.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.addeco.demo.entity.Customer;
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
	
	
			//CREATE
			// Crea un producto nuevo
			@GetMapping("/products/new")
			public String newProduct(Model model) {
				model.addAttribute("product", new Product());
				
				
				
				model.addAttribute("manufacturers", manufacturerRepository.findAll());
				return "product-edit";
		
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
			public String findproducts(Model model, HttpSession session) {
				Customer customer = (Customer) session.getAttribute("customer");
				if(customer != null)
					model.addAttribute("customer", customer);
				model.addAttribute("products", productRepository.findAll());
				return "product-list";
			}
			
			@GetMapping("/userproducts")
			public String findUserProducts(Model model, HttpSession session) {
				Customer customer = (Customer) session.getAttribute("customer");
				if(customer != null)
					model.addAttribute("customer", customer);
				model.addAttribute("products", productRepository.findAllByCustomersId(customer.getId()));
				return "product-list";
			}
			
			// UPDATE
			// Busca la ID del producto para editarlo. En caso contrario, nos dará un error.
			@GetMapping("/products/{id}/edit")
			public String editarProducto(@PathVariable Long id, Model model) {
				if(id == null) {
					return "redirect:/products";
					}
				Optional<Product> productOpt = productRepository.findById(id);
				if (productOpt.isPresent()) { 
					model.addAttribute("product", productOpt.get());
					model.addAttribute("manufacturers", manufacturerRepository.findAll());
					return "product-edit";
				} else {
				model.addAttribute("error", "No existe el producto solicitado");
				return "redirect:/products";
				}		
			}
			
			// GUARDAR Y/O ACTUALIZAR PRODUCTOS
			@PostMapping("/products")
			public String crearProducto(@ModelAttribute("product") Product product, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
				
				String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				product.setLogo(fileName);
				
				
				Product productSaved = productRepository.save(product);
				
				// PRUEBA PARA VER SI SE PUEDEN SUBIR IMAGENES DEL PRODUCTO
				String uploadDir = "./product-logos/" + productSaved.getId();
				Path uploadPath = Paths.get(uploadDir);
				
				if(!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}
				try (InputStream inputStream = multipartFile.getInputStream()) {
					Path filePath = uploadPath.resolve(fileName);
					Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e){
					throw new IOException("Upload image could not be saved" + fileName + ". Please, upload a jpeg or prg file.");
				}
				// FIN DE LA PRUEBA
				
				return "redirect:/products";
			}	
				
				// DELETE
				// Borra el producto que corresponda con la ID seleccionada
				@GetMapping("/products/{id}/delete")
				public String borrarProducto(@PathVariable Long id) {
					productRepository.deleteById(id);
					return "redirect:/products";
				}
				
				// Borra todos los productos
				@GetMapping("/products/delete")
				public String borrarProductos() {
					productRepository.deleteAll();
					return "redirect:/products";
				}
				

				
				
				
				
}
