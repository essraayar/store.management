package com.innova.store.management.service.implementation;

import com.innova.store.management.model.City;
import com.innova.store.management.model.District;
import com.innova.store.management.repository.DistrictRepository;
import com.innova.store.management.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired

    private DistrictRepository districtRepository;

    @Override
    public District findByNameAndCity(String name, String city) {
        return districtRepository.findByNameAndCityName(name,city);
    }

    @Override
    public List<District> findByCity(String city) {
        return districtRepository.findByCityName(city);
    }

    @Override
    public List<District> findAllDistricts() {
        return districtRepository.findAll();
    }


}
