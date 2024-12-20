package com.carStore.service;

import com.carStore.entity.Car;
import com.carStore.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<Car> searchCars(String keyword) {
        return searchRepository.searchCars(keyword.trim());
    }
}
