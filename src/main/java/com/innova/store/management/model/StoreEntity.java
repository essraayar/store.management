package com.innova.store.management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stores")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_type", nullable = false)
    private String store_type;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "store_name", nullable = false)
    private String store_name;


    public StoreEntity() {

    }

    public StoreEntity(String store_type, String city, String district, String store_name) {
        this.store_type = store_type;
        this.city = city;
        this.district = district;
        this.store_name = store_name;
    }

    public String getStore_type() {
        return store_type;
    }
    public void setStore_type(String store_type) {
        this.store_type = store_type;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }


    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStore_name() {
        return store_name;
    }
    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }


    @Override
    public String toString() {
        return "StoreEntity{" +
                "store_type='" + store_type + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", store_name='" + store_name + '\'' +
                '}';
    }

}





