package com.flexshose.flexshoesbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "INVOICE")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_ID", columnDefinition = "int", updatable = false, insertable = false)
    private Integer invoiceId;

    @Column(name = "ISSUE_DATE")
    private LocalDate issueDate;

    @Column(name = "RECEIVER_NUMBER", columnDefinition = "nvarchar(12)")
    private String receiverNumber;

    @Column(name = "RECEIVER_NAME", columnDefinition = "nvarchar(105)")
    private String receiverName;

    @Column(name = "RECEIVER_ADDRESS", columnDefinition = "nvarchar(105)")
    private String receiverAddress;

    // Payment method: Cash || Online Payment
    @Column(name = "PAYMENT_METHOD", columnDefinition = "nvarchar(50)")
    private String paymentMethod;

    // Delivery method: At store || Delivery
    @Column(name = "DELIVERY_METHOD", columnDefinition = "nvarchar(50)")
    private String deliveryMethod;

    // Order status: processing -> delivered -> canceled
    @Column(name = "ORDER_STATUS", columnDefinition = "nvarchar(50)")
    private String orderStatus;

    @Column(name = "TOTAL")
    private double total;

    // Mapping to Customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", nullable = true)
    private Customer customer;
}
