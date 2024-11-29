package com.flexshose.flexshoesbackend.dto;

import java.util.Set;

import com.flexshose.flexshoesbackend.entity.Brand;
import com.flexshose.flexshoesbackend.entity.ProductCategory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTOv2 {

	 Integer productId; // Using productId as the identifier

	 String productName;

	 String description;

	 double originalPrice;

	 String status;

	 double salePrice;

	 double vat;

	 Set<String> images;

	 String gender;
	 
	 String categoryId;
	 
	 String categoryName;
	 
	 String brandId;
	 
	 String brandName;

}
