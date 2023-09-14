package com.innova.store.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "city",uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public City(String name) {
        this.name=name;
    }
    public  City(){

    }
}
