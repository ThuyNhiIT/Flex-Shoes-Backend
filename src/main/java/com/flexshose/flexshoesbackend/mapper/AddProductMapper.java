package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.AddProductDto;
import com.flexshose.flexshoesbackend.entity.Brand;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.entity.ProductCategory;

import java.util.HashSet;

public class AddProductMapper {

    // Convert Product entity to AddProductDto
    public static AddProductDto toAddProductDto(Product product) {
        AddProductDto addProductDto = new AddProductDto();
        addProductDto.setProductId(product.getProductId());
        addProductDto.setProductName(product.getProductName());
        addProductDto.setDescription(product.getDescription());
        addProductDto.setOriginalPrice(product.getOriginalPrice());
        addProductDto.setStatus(product.getStatus());
        addProductDto.setSalePrice(product.getSalePrice());
        addProductDto.setVat(product.getVat());
        addProductDto.setImages(new HashSet<>(product.getImages())); // Convert Set<String> to Set<String>
        addProductDto.setGender(product.getGender());
        addProductDto.setProductCategory(product.getProductCategory()); // Set the ProductCategory
        addProductDto.setBrand(product.getBrand()); // Set the Brand
        return addProductDto;
    }

    // Convert AddProductDto to Product entity
    public static Product toProduct(AddProductDto addProductDto) {
        Product product = new Product();
        product.setProductName(addProductDto.getProductName());
        product.setDescription(addProductDto.getDescription());
        product.setOriginalPrice(addProductDto.getOriginalPrice());
        product.setStatus(addProductDto.getStatus());
        product.setSalePrice(addProductDto.getSalePrice());
        product.setVat(addProductDto.getVat());
        product.setImages(new HashSet<>(addProductDto.getImages())); // Convert Set<String> to Set<String>
        product.setGender(addProductDto.getGender());
        product.setProductCategory(addProductDto.getProductCategory()); // Set the ProductCategory
        product.setBrand(addProductDto.getBrand()); // Set the Brand
        return product;
    }
}
