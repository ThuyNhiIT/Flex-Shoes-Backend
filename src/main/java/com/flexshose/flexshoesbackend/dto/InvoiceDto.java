package com.flexshose.flexshoesbackend.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceDto {
    private Integer invoiceId;
    private LocalDate issueDate;
    private String receiverNumber;
    private String receiverName;
    private String receiverAddress;
    private String paymentMethod;
    private String deliveryMethod;
    private String orderStatus;//trang thai don hang
    private double total;
    private Integer customerId;
}
