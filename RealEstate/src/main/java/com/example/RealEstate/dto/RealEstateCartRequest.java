package com.example.RealEstate.dto;

import lombok.Data;

@Data
public class RealEstateCartRequest {
    private Long property_id;
    private Long customer_id;
    private String propertyName;
    private String address;
    private String location;
    private Double price;
}
