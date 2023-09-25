package com.innova.store.management.controller;

import com.innova.store.management.model.City;
import com.innova.store.management.repository.CityRepository;
import com.innova.store.management.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/city")
@CrossOrigin("http://localhost:8080/")
public class CityController {

    @Autowired
    private CityService cityService;
    @GetMapping("/get-all-cities")
    public ResponseEntity<List<String>> getAllCities () {
        List<String> allCitylist = cityService.findAll().stream().
                map(i->i.getName()).
                collect(Collectors.toList());//select * from city--> name;
        return ResponseEntity.ok(allCitylist);
    }
}
