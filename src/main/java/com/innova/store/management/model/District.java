package com.innova.store.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "district",uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public District() {

    }
    public District(String name,City city) {
        this.name=name;
        this.city=city;
    }
}
