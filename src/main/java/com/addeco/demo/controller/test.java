package com.addeco.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class test {

	
	  @GetMapping("/test")
	  public String findCustomers(Model model, HttpSession session){
	
	    return "index";
	  }
}
