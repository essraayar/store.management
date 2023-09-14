package com.innova.store.management.model.dto;

import com.innova.store.management.model.City;
import com.innova.store.management.model.District;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class StoreRequest {
    private String store_type;

    private String city;

    private String district;

    private String store_name;
}
