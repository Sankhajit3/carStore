package com.carStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.carStore.entity.Car;
import com.carStore.service.CarService;



import java.util.*;

@Controller
public class CarController {
	
	@Autowired
	private CarService service;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/car_register")
	public String carRegister() {
		return "carRegister";
	}
	
	 @GetMapping("/available_cars")
	    public ModelAndView getAllCars(
	            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
	            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
	            @RequestParam(value = "sortField", defaultValue = "name", required = false) String sortField,
	            @RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection) {

	        // Adjust pageNumber for zero-based indexing
	        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.fromString(sortDirection), sortField));
	        Page<Car> pageCar = service.getAllCars(pageable);

	        ModelAndView modelAndView = new ModelAndView("carList");
	        modelAndView.addObject("car", pageCar.getContent());
	        modelAndView.addObject("pageNumber", pageNumber);
	        modelAndView.addObject("totalPages", pageCar.getTotalPages());
	        modelAndView.addObject("pageSize", pageSize);
	        modelAndView.addObject("sortField", sortField);
	        modelAndView.addObject("sortDirection", sortDirection);

	        return modelAndView;
	    }
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Car b) {
		service.save(b);
		return "redirect:/available_cars";
	}
	
	
	@RequestMapping("/editCar/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Car b=service.getCarById(id);
		model.addAttribute("car",b);
		return "carEdit";
	}
	@RequestMapping("/deleteCar/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_cars";
	}
	
}
