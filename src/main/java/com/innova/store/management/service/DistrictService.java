package com.innova.store.management.service;

import com.innova.store.management.model.City;
import com.innova.store.management.model.District;

public interface DistrictService {
    District findByNameAndCity(String name, String city);


}
