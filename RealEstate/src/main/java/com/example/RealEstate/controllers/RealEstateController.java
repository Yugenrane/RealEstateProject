package com.example.RealEstate.controllers;
import com.example.RealEstate.dto.RealEstateCartRequest;
import com.example.RealEstate.entities.RealEstateCart;
import com.example.RealEstate.services.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/cart")
@RestController
public class RealEstateController {
    @Autowired
    private RealEstateService realEstateService;

    @PostMapping("/addItem")
    public ResponseEntity<String> addItem(@RequestBody RealEstateCartRequest realEstateCartRequest){
        realEstateService.addProperty(realEstateCartRequest);
        return new ResponseEntity<>("Item added in cart", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable Long id, @RequestBody RealEstateCartRequest realEstateCartRequest){
        realEstateService.updateProperty(id, realEstateCartRequest);
        return new ResponseEntity<>("Card record updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id){
        realEstateService.deleteProperty(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RealEstateCart>> getAllInCart(){
        return new ResponseEntity<>(realEstateService.allProperties(), HttpStatus.OK);
    }
}
