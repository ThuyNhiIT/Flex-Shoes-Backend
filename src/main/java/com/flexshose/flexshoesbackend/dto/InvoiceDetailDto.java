package com.flexshose.flexshoesbackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceDetailDto {
	Integer invoiceId;
	Integer productId;
	String productName;
	double salePrice;
	int quantity;
}
