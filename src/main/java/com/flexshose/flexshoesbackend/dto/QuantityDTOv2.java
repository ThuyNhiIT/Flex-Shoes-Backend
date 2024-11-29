package com.flexshose.flexshoesbackend.dto;

import com.flexshose.flexshoesbackend.entity.Color;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.entity.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuantityDTOv2 {

	Integer id;

	Integer productId;
	
	String productName;

	Integer colorId;

	String colorName;

	Integer sizeId;

	String sizeName;

	int quantity;
}
