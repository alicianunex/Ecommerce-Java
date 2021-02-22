package controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demopagination.entities.Customer;
import com.example.demopagination.service.api.CustomerSrviceAPI;



@Controller
public class CustomerController {

	
	@Autowired
	private CustomerSrviceAPI customerServiceAPI;
	
	@GetMapping(value = "/")
	public String finnAll (@RequestParam Map <String, Object> params, Model model){
		int page = params.get("page") !=null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		PageRequest pageRequest = PageRequest.of(page, 10);
		Page<Customer> pageCustomer = customerServiceAPI.gettAll(pageRequest);
		
		int totalPage =  pageCustomer.getTotalPages();
		if (totalPage >0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());		
			model.addAttribute("pages", pages);		
		}
		model.addAttribute("list", pageCustomer.getContent());

		return "index";
	}
	
}
