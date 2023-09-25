package com.innova.store.management.service;

import com.innova.store.management.model.StoreEntity;
import com.innova.store.management.model.dto.StoreDto;

import java.util.List;

public interface StoreService {

    List<StoreEntity> findByCityAndDistrict(String city, String district);
    List<StoreEntity> findAll();
}
