package com.flexshose.flexshoesbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceDetailDto {
    private Integer invoiceId;
    private Integer productId;
    private int quantity;
}
