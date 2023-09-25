package com.innova.store.management.service.implementation;

import com.innova.store.management.model.City;
import com.innova.store.management.repository.CityRepository;
import com.innova.store.management.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public City findCityByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
