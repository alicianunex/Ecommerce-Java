package com.addeco.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.example.demopagination.entities.Customer;




@Controller
public class CustomerController {

	
	@Autowired
	private CustomerRepository customerRepository;

  @GetMapping("/customers")
  public String findCustomers(Model model){
    model.addAttribute("customers", customerRepository.findAll());
    return "customer-list";
  }

	@GetMapping("/customers/{id}/view")
	public String viewCustomer(@PathVariable Long id, Model model) {
		if (id == null) {
			return "redirect:/customers";
		}
		Optional<Customer> manOpt = repository.findById(id);
		if (manOpt.isPresent()) {
			model.addAttribute("customer", manOpt.get());
			return "customer-view";
		}
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/new")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customers-edit";
	}
	
	@PostMapping("/customers")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		repository.save(customer);
		return "redirect:/customers";
	}