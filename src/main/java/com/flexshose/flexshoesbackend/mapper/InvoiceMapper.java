package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.InvoiceDto;
import com.flexshose.flexshoesbackend.entity.Invoice;

public class InvoiceMapper {
    public static InvoiceDto mapToInvoiceDto(Invoice invoice) {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceId(invoice.getInvoiceId());
        invoiceDto.setTotal(invoice.getTotal());
        return invoiceDto;
    }

    public static Invoice mapToInvoice(InvoiceDto invoiceDto) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoiceDto.getInvoiceId());
        invoice.setTotal(invoiceDto.getTotal());
        return invoice;
    }
}
