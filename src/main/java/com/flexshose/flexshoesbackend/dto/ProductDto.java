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
    private Integer productId;
    private String productName;
//    private double Price;
    private double price;
    private String description;
    private boolean status;
    private float discount;
    private int quantity;
    private boolean gender;
//    private Map<String, Integer> colors;
//    private Map<String, Integer> sizes;
//    private double tax;
//    private double salePrice;
    private List<String> imageUrls;  // Assuming you want to return URLs of images in DTO
//    private int categoryId;
//    private int brandId;

	public ProductDto(Integer productId, String productName, double price, String description) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
	}
	public ProductDto(Integer productId, String productName, double price, String description, List<String> imageUrls) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.imageUrls = imageUrls;
	}
	
	
    
	
}
