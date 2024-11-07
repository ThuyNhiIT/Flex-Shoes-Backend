package com.flexshose.flexshoesbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceDto {
    private Integer invoiceId;
    private double total;
}
