package controller;

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
}

