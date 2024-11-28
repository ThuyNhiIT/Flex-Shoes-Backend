package com.flexshose.flexshoesbackend.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
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
