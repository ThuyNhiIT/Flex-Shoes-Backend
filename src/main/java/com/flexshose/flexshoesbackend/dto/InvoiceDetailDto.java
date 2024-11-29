package com.flexshose.flexshoesbackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceDetailDto {
	Integer detailId;
	Integer invoiceId;
	Integer productId;
	int quantity;
	
	//ProductDto product;
	String productName;
	double originalPrice;
	double salePrice;
}
