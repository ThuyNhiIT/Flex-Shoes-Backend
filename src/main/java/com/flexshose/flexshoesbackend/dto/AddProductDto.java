package com.flexshose.flexshoesbackend.dto;

import com.flexshose.flexshoesbackend.entity.Brand;
import com.flexshose.flexshoesbackend.entity.Gender;
import com.flexshose.flexshoesbackend.entity.ProductCategory;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddProductDto {
    private Integer productId;
    private String productName;
    private String description;
    private double originalPrice;
    private String status;
    private double salePrice;
    private double vat;
    private Set<String> images;
    private Gender gender;
    private Brand brand;
    private ProductCategory productCategory;


}
