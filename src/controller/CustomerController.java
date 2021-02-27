package com.addeco.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.addeco.demo.entity.Customer;
import com.addeco.demo.repository.CustomerRepository;




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
		Optional<Customer> manOpt = customerRepository.findById(id);
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
		customerRepository.save(customer);
		return "redirect:/customers";
	}
}
