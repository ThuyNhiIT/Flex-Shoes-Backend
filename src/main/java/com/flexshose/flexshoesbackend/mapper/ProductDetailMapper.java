// src/main/java/com/flexshose/flexshoesbackend/mapper/ProductDetailMapper.java

package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.ProductDetailDto;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.entity.Quantity;
import com.flexshose.flexshoesbackend.dto.ColorDto;
import com.flexshose.flexshoesbackend.dto.SizeDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDetailMapper {

    public static ProductDetailDto mapToProductDetailDto(Product product) {
        ProductDetailDto productDetailDto = new ProductDetailDto();
        productDetailDto.setProductId(product.getProductId());
        productDetailDto.setProductName(product.getProductName());
        productDetailDto.setDescription(product.getDescription());
        productDetailDto.setSalePrice(product.getSalePrice());
        productDetailDto.setStatus(product.getStatus());
        productDetailDto.setImages(List.copyOf(product.getImages()));
        productDetailDto.setOriginalPrice(product.getOriginalPrice());
        // Map colors
        List<ColorDto> colors = product.getQuantities().stream()
                .map(quantity -> new ColorDto(quantity.getColor().getColorId(), quantity.getColor().getColorName()))
                .collect(Collectors.toList());
        productDetailDto.setColors(colors);

        // Map sizes
        List<SizeDto> sizes = product.getQuantities().stream()
                .map(quantity -> new SizeDto(quantity.getSize().getSizeId(), quantity.getSize().getSizeName()))
                .distinct()
                .collect(Collectors.toList());
        productDetailDto.setSizes(sizes);
        double finalPrice = (product.getOriginalPrice() - (product.getOriginalPrice() * product.getSalePrice() / 100)) * (1 + product.getVat() / 100);
        finalPrice = Math.round(finalPrice * 100.0) / 100.0; // Làm tròn đến 2 chữ số thập phân
        productDetailDto.setFinalPrice(finalPrice);
        return productDetailDto;
    }
}
