package com.example.RealEstate.repo;

import com.example.RealEstate.entities.RealEstateCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateRepo extends JpaRepository<RealEstateCart, Long> {
}
