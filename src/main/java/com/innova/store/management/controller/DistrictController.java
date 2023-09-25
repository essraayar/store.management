package com.innova.store.management.controller;

import com.innova.store.management.repository.DistrictRepository;
import com.innova.store.management.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/district")
@CrossOrigin("http://localhost:8080/")
public class DistrictController {

    @Autowired
    private DistrictService districtService;
    @GetMapping("/get-all-districts")
    public ResponseEntity<List<String>> getAllDistricts(@RequestParam("city") String city) {
        List<String> allDistrictlist = districtService.findByCity(city).stream().
                map(i -> i.getName()).
                collect(Collectors.toList());//select d.* from district d,city c where d.city_id=c.id and c.name=** --> name;
        return ResponseEntity.ok(allDistrictlist);
    }
}


