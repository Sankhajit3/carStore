package com.carStore.controller;

import com.carStore.entity.Car;
import com.carStore.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping()
    public ModelAndView searchCars(@RequestParam(value = "keyword", required = false) String keyword) {
    	
  
        List<Car> cars = keyword != null && !keyword.trim().isEmpty()
                ? searchService.searchCars(keyword)
                : List.of(); // Return an empty list if the keyword is blank

        ModelAndView modelAndView = new ModelAndView("searchResults");
        modelAndView.addObject("searchResults", cars);
        modelAndView.addObject("query", keyword); // Pass the original query for display
        return modelAndView;
    }
}
