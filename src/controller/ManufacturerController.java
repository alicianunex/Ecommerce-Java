package com.addeco.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.addeco.demo.entity.Manufacturer;
import com.addeco.demo.repository.ManuFacturerRepository;

@Controller
public class ManufacturerController {

	@Autowired
	ManuFacturerRepository repository;
	
	@GetMapping("/manufacturers")
	public String listManufacturers(Model model) {
		List<Manufacturer> manufacturer = repository.findAll();
		model.addAttribute("manufacturer", manufacturer);
		return "manufacturer-list";
	}
	
	@GetMapping("/manufacturers/{id}/view")
	public String viewManufacturer(@PathVariable Long id, Model model) {
		if (id == null) {
			return "redirect:/manufacturers";
		}
		Optional<Manufacturer> manOpt = repository.findById(id);
		if (manOpt.isPresent()) {
			model.addAttribute("manufacturer", manOpt.get());
			return "manufacturer-view";
		}
		return "redirect:/manufacturers";
	}
	
	@GetMapping("/manufacturers/new")
	public String showForm(Model model) {
		model.addAttribute("manufacturer", new ManufacturerController());
		return "manufacturer-edit";
	}
	
	@PostMapping("/manufacturers")
	public String saveManufacturer(@ModelAttribute("manufacturer") ManufacturerController manufacturer) {
		ManuFacturerRepository.save(manufacturer);
		return "redirect:/manufacturers";
	}
	
}
