package com.innova.store.management.repository;


import com.innova.store.management.model.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity , Long> {

    @Query("select s from StoreEntity s where s.city.name=:city and s.district.name=:district")
    List<StoreEntity> findByCityAndDistrict(@Param("city")String city, @Param("district")String district);

    @Query("select s from StoreEntity s where s.city.name=:city ")
    List<StoreEntity> findByCity(@Param("city")String city);
}
