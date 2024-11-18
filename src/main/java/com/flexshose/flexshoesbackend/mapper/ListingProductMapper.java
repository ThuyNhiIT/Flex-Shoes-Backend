package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.ListingProductDto;
import com.flexshose.flexshoesbackend.dto.ProductDto;
import com.flexshose.flexshoesbackend.entity.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

public class ListingProductMapper {
    public static ListingProductDto mapToListingProductDto(Product product, Quantity quantity, Brand brand, ProductCategory productCategory,Size size,Color color) {
        ListingProductDto listingProductDto = new ListingProductDto();
        listingProductDto.setProductId(product.getProductId());
        listingProductDto.setProductName(product.getProductName());
        listingProductDto.setOriginalPrice(product.getOriginalPrice());
        listingProductDto.setSalePrice(product.getSalePrice());
        listingProductDto.setColorName(color.getColorName());
        listingProductDto.setSizeName(size.getSizeName());
        listingProductDto.setQuantity(quantity.getQuantity());
        listingProductDto.setBrandName(brand.getBrandName());
        listingProductDto.setCategoryName(productCategory.getCategoryName());
        listingProductDto.setGender(product.getGender().toString());
        listingProductDto.setImages(product.getImages());
        double finalPrice = product.getSalePrice() * (1 + product.getVat() / 100);
        listingProductDto.setFinalPrice(finalPrice);
        return listingProductDto;

    }



}
