package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.ListingProductDto;
import com.flexshose.flexshoesbackend.service.ListingProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/listing")
public class ListingController {

    private final ListingProductService listingProductService;

    public ListingController(ListingProductService listingProductService) {
        this.listingProductService = listingProductService;
    }

    @PostMapping("/filter")
    public ResponseEntity<List<?>> filterProductsByCriteria(
            @RequestParam(required = false) String[] sizes,
            @RequestParam(required = false) String[] colors,
            @RequestParam(required = false) String[] brands,
            @RequestParam(required = false) String[] categorys,
            @RequestParam(required = false) String[] genders,
            @RequestParam(required = false) double minPrice,
            @RequestParam(required = false) double maxPrice)

    {
        System.out.println("Colors: " + (colors != null ? String.join(", ", colors) : "null"));
        System.out.println("Sizes: " + (sizes != null ? String.join(", ", sizes) : "null"));
        System.out.println("Brands: " + (brands != null ? String.join(", ", brands) : "null"));
        System.out.println("Genders: " + (genders != null ? String.join(", ", genders) : "null"));
        System.out.println("Min Price: " + minPrice);
        System.out.println("Max Price: " + maxPrice);



        List<ListingProductDto> listingProductDtos = listingProductService.filterProductsByCriteria(colors, sizes,brands,categorys,genders,minPrice,maxPrice);
        return new ResponseEntity<>(listingProductDtos, HttpStatus.OK);

    }

}
