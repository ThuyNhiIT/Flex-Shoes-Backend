package com.flexshose.flexshoesbackend.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ListInvoiceDto {
    private LocalDate issueDate;
    private String productName;
    private String image;
    private double total;

    // Constructors, getters and setters
}
