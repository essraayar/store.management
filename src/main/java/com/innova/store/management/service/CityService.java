package com.innova.store.management.service;

import com.innova.store.management.model.City;

import java.util.List;

public interface CityService {
    City findCityByName(String name);

    List<City> findAll();

}
