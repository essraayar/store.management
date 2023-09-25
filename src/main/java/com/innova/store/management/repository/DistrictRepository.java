package com.innova.store.management.repository;

import com.innova.store.management.model.City;
import com.innova.store.management.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {
    @Query("select d from District d Where d.name=:name And d.city.name=:city")
    District findByNameAndCityName(@Param("name") String name,@Param("city") String city);
    @Query("select d from District d Where d.city.name=:city")
    List<District> findByCityName(@Param("city") String city);


}
