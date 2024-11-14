package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.ListingProductDto;
import com.flexshose.flexshoesbackend.service.ListingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listing-products")
public class ListingProductController {

    @Autowired
    private ListingProductService listingProductService;

    @GetMapping("/filter")
    public ResponseEntity<List<ListingProductDto>> filterProducts(
            @RequestParam(required = false) String[] colors,
            @RequestParam(required = false) String[] sizes,
            @RequestParam(required = false) String[] brands,
            @RequestParam(required = false) String[] category,
            @RequestParam(required = false) String[] genders,
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {
        
        List<ListingProductDto> filteredProducts = listingProductService.filterProductsByCriteria(colors, sizes, brands,category, genders, minPrice, maxPrice);
        return ResponseEntity.ok(filteredProducts);
    }
} 