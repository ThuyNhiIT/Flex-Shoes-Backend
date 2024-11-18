package com.flexshose.flexshoesbackend.service;

import com.flexshose.flexshoesbackend.dto.ListingProductDto;


import java.util.List;

public interface ListingProductService {
    List<ListingProductDto> filterProductsByCriteria(String[] colors, String[] sizes, String[] brands,String[] categorys, String[] genders, double minPrice, double maxPrice);
}
