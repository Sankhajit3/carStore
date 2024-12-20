package com.carStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.carStore.entity.Car;
import com.carStore.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository bRepo;
	
	public void save(Car b) {
		bRepo.save(b);
	}
	
	  public Page<Car> getAllCars(Pageable pageable) {
	        return bRepo.findAll(pageable);
	    }
	
	public Car getCarById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
	
}
