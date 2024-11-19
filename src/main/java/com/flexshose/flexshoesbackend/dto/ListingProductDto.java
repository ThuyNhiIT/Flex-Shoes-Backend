package com.flexshose.flexshoesbackend.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ListingProductDto {
    private int productId;
    private String productName;
    private double originalPrice;
    private double salePrice;
    private double finalPrice;
    private String colorName;
    private String sizeName;
    private String brandName;
    private String categoryName;
    private String gender;
    private int quantity;
   // image
   private Set<String> images;


}
