package com.innova.store.management.service;

import com.innova.store.management.model.District;

import java.util.List;

public interface DistrictService {
    District findByNameAndCity(String name, String city);

    List<District> findByCity(String city);

    List<District> findAllDistricts();
}
