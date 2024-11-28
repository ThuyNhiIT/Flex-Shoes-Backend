package com.flexshose.flexshoesbackend.service;

import com.flexshose.flexshoesbackend.dto.AddProductDto;
import com.flexshose.flexshoesbackend.dto.ProductDto;

import java.util.List;

public interface ProductService  {
    AddProductDto createProductDto(AddProductDto addProductDto);
    // getAllProducts
    List<ProductDto> getAllProducts();
    
    // searchProductsByName
    public List<ProductDto> searchProductsByName(String name);


}
