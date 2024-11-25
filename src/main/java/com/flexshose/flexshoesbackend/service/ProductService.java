package com.flexshose.flexshoesbackend.service;

import com.flexshose.flexshoesbackend.dto.ProductDto;

import java.util.List;

public interface ProductService  {
    ProductDto createProductDto(ProductDto productDto);
    // getAllProducts
    List<ProductDto> getAllProducts();
    
    // searchProductsByName
    public List<ProductDto> searchProductsByName(String name);

}
