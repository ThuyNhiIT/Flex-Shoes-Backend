package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.ListInvoiceDto;
import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;
import com.flexshose.flexshoesbackend.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ListInvoiceMapper {


    public static List<ListInvoiceDto> toListInvoiceDto(List<Invoice> invoices) {
        return invoices.stream().map(invoice -> {
            ListInvoiceDto dto = new ListInvoiceDto();
            dto.setIssueDate(invoice.getIssueDate());

            if (invoice.getInvoiceDetails() != null && !invoice.getInvoiceDetails().isEmpty()) {
                InvoiceDetail invoiceDetail = invoice.getInvoiceDetails().iterator().next();
                if (invoiceDetail != null && invoiceDetail.getProduct() != null) {
                    Product product = invoiceDetail.getProduct();
                    dto.setProductName(product.getProductName());
                    dto.setImage(product.getImages() != null ?
                            product.getImages().stream().findFirst().orElse("No Image") :
                            "No Image");
                }
            }

            dto.setTotal(invoice.getTotal());
            return dto;
        }).collect(Collectors.toList());
    }

}
