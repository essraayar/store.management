package com.innova.store.management.repository;

import com.innova.store.management.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    City findByName(String name);

    @Query("select c.name from City c Where c.id=:id")
    String findByNull(@Param("id") Long idd);

    @Query(value = "select count(c.*) from city c Where c.id=:id",nativeQuery = true)
    Long findByNullV2(@Param("id") Long idd);

}
