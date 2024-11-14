package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.InvoiceDto;
import com.flexshose.flexshoesbackend.entity.Invoice;

public class InvoiceMapper {
    public static InvoiceDto mapToInvoiceDto(Invoice invoice) {
//        InvoiceDto invoiceDto = new InvoiceDto();
//        invoiceDto.setInvoiceId(invoice.getInvoiceId());
//        invoiceDto.setTotal(invoice.getTotal());
//        return invoiceDto;
        return new InvoiceDto(
                invoice.getInvoiceId(),
                invoice.getIssueDate(),
                invoice.getReceiverNumber(),
                invoice.getReceiverName(),
                invoice.getReceiverAddress(),
                invoice.getPaymentMethod(),
                invoice.getDeliveryMethod(),
                invoice.getOrderStatus(),
                invoice.getTotal()
        );
    }

    public static Invoice mapToInvoice(InvoiceDto invoiceDto) {
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceId(invoiceDto.getInvoiceId());
//        invoice.setTotal(invoiceDto.getTotal());
//        return invoice;

        Invoice invoice = new Invoice();
        invoice.setIssueDate(invoiceDto.getIssueDate());
        invoice.setReceiverNumber(invoiceDto.getReceiverNumber());
        invoice.setReceiverName(invoiceDto.getReceiverName());
        invoice.setReceiverAddress(invoiceDto.getReceiverAddress());
        invoice.setPaymentMethod(invoiceDto.getPaymentMethod());
        invoice.setDeliveryMethod(invoiceDto.getDeliveryMethod());
        invoice.setOrderStatus(invoiceDto.getOrderStatus());
        invoice.setTotal(invoiceDto.getTotal());
        return invoice;
    }
}
