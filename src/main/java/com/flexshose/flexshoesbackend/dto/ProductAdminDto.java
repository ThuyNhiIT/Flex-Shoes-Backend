package com.flexshose.flexshoesbackend.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAdminDto {
    private int productId;
    private String productName;
    private double originalPrice;
    private double salePrice;
    private double finalPrice;
    private String brandName;
    private String categoryName;
    private int quantity;
    private String description;
    private Set<String> images;
}

// ok
