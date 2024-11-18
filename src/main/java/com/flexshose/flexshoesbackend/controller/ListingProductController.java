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
            @RequestParam(required = false, defaultValue = "Red,Blue,Green,Black,White,Gray,Yellow,Pink,Brown,Purple") String[] colors,
            @RequestParam(required = false, defaultValue = "S,M,L,XL,XXL,36,37,38,39,40,41,42,43,44,45") String[] sizes,
            @RequestParam(required = false, defaultValue = "Nike,Adidas,Puma,NewBalance,Reebok,Converse,Vans,UnderArmour,ASICS,Fila,Other") String[] brands,
            @RequestParam(required = false, defaultValue = "Men Shoes,Women Shoes,Kids Shoes,Sports Shoes,Casual Shoes") String[] category,
            @RequestParam(required = false, defaultValue = "MEN,WOMEN,UNISEX") String[] genders,
            @RequestParam(required = false, defaultValue = "0") double minPrice,
            @RequestParam(required = false, defaultValue = "1000") double maxPrice)  {
        System.out.println("colors: " + colors);
        System.out.println("sizes: " + sizes);
        System.out.println("brands: " + brands);
        System.out.println("category: " + category);
        System.out.println("gender:" +genders);
        System.out.println("minPrice: " + minPrice);
        System.out.println("maxPrice: " + maxPrice);
        
        List<ListingProductDto> filteredProducts = listingProductService.filterProductsByCriteria(colors, sizes, brands,category, genders, minPrice, maxPrice);
        return ResponseEntity.ok(filteredProducts);
    }
} 