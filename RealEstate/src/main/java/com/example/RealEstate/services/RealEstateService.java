package com.example.RealEstate.services;

import com.example.RealEstate.dto.RealEstateCartRequest;
import com.example.RealEstate.entities.RealEstateCart;

import java.util.List;

public interface RealEstateService {
    void addProperty(RealEstateCartRequest realEstateCartRequest);
    void updateProperty(Long id, RealEstateCartRequest realEstateCartRequest);
    void deleteProperty(Long id);
    List<RealEstateCart> allProperties();
}
