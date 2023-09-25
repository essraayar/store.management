package com.innova.store.management.service.implementation;

import com.innova.store.management.model.StoreEntity;
import com.innova.store.management.repository.StoreRepository;
import com.innova.store.management.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;
    @Override
    public List<StoreEntity> findByCityAndDistrict(String city, String district) {
        return storeRepository.findByCityAndDistrict(city,district);
    }

    @Override
    public List<StoreEntity> findAll() {
        return storeRepository.findAll();
    }
}
