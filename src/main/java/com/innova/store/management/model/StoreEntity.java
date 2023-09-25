package com.innova.store.management.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "stores")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_type", nullable = false)
    private String store_type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")
    private District district;

    @Column(name = "store_name", nullable = false)
    private String store_name;

    @Getter
    @Column(name = "store_link", nullable = false)
    private String store_link;


    public StoreEntity() {

    }

    public StoreEntity(String store_type, City city, District district, String store_name, String store_link) {
        this.store_type = store_type;
        this.city = city;
        this.district = district;
        this.store_name = store_name;
        this.store_link = store_link;
    }

    public String getStore_type() {
        return store_type;
    }

    public void setStore_type(String store_type) {
        this.store_type = store_type;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_link() {
        return store_link;
    }

    public void setStore_link(String store_link) {
        this.store_link = store_link;
    }


    @Override
    public String toString() {
        return "StoreEntity{" +
                "store_type='" + store_type + '\'' +
                ", city=" + city +
                ", district=" + district +
                ", store_name='" + store_name + '\'' +
                ", store_link='" + store_link + '\'' +
                '}';
    }

}





