package com.example.RealEstate.services;
import com.example.RealEstate.dto.RealEstateCartRequest;
import com.example.RealEstate.entities.RealEstateCart;
import com.example.RealEstate.repo.RealEstateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RealEstateServiceImpl implements RealEstateService{
    @Autowired
    private RealEstateRepo realEstateRepo;

    @Override
    public void addProperty(RealEstateCartRequest realEstateCartRequest) {
        RealEstateCart realEstateCart=new RealEstateCart();
        realEstateCart.setProperty_id(realEstateCartRequest.getProperty_id());
        realEstateCart.setCustomer_id(realEstateCartRequest.getCustomer_id());
        realEstateCart.setPropertyName(realEstateCartRequest.getPropertyName());
        realEstateCart.setAddress(realEstateCartRequest.getAddress());
        realEstateCart.setLocation(realEstateCartRequest.getLocation());
        realEstateCart.setPrice(realEstateCartRequest.getPrice());
        realEstateRepo.save(realEstateCart);
    }

    @Override
    public void updateProperty(Long id, RealEstateCartRequest realEstateCartRequest) {
        RealEstateCart item = realEstateRepo.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setProperty_id(realEstateCartRequest.getProperty_id());
        item.setCustomer_id(realEstateCartRequest.getCustomer_id());
        item.setPropertyName(realEstateCartRequest.getPropertyName());
        item.setAddress(realEstateCartRequest.getAddress());
        item.setLocation(realEstateCartRequest.getLocation());
        item.setPrice(realEstateCartRequest.getPrice());
        realEstateRepo.save(item);
    }

    @Override
    public void deleteProperty(Long id) {
        Optional<RealEstateCart> item = realEstateRepo.findById(id);
        if(item.isPresent())
            realEstateRepo.deleteById(id);
        else
            throw new RuntimeException("Item not found");
    }

    @Override
    public List<RealEstateCart> allProperties() {
        return realEstateRepo.findAll();
    }
}
