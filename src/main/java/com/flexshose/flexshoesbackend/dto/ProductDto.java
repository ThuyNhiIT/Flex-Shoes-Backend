package com.flexshose.flexshoesbackend.dto;

import lombok.*;

import java.util.List;
import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
//    private int productId;
    private String productName;
    private double Price;
    private String description;
    private boolean status;
    private float discount;
    private int quantity;
    private boolean gender;
//    private Map<String, Integer> colors;
//    private Map<String, Integer> sizes;
//    private double tax;
//    private double salePrice;
//    private List<String> imageUrls;  // Assuming you want to return URLs of images in DTO
//    private int categoryId;
//    private int brandId;

}
