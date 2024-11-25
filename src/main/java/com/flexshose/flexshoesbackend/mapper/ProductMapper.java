package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.ProductDto;
import com.flexshose.flexshoesbackend.entity.Product;


public class ProductMapper {
    public static ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
//        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setDescription(product.getDescription());
        productDto.setImages(product.getImages());
//        productDto.setPrice(product.getPrice());
//        productDto.setCategoryId(product.getProductCategory().getCategoryId());
//        productDto.setBrandId(product.getBrand().getBrandId());
//        productDto.setImageUrls(product.getImages().stream().map(image -> image.getUrl()).collect(Collectors.toList()));
        return productDto;

    }
    public static Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
//        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
//        product.setPrice(productDto.getPrice());
        //image
//        productDto.getImageUrls().forEach(imageUrl -> {
//            Image image = new Image();
//            image.setUrl(imageUrl);
//            image.setProduct(product);
//            product.getImages().add(image);
//        });
        return product;
    }

}