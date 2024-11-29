package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.ListInvoiceDto;
import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;
import com.flexshose.flexshoesbackend.entity.Product;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class ListInvoiceMapper {

    public static List<ListInvoiceDto> toListInvoiceDto(List<Invoice> invoices) {
        return invoices.stream().flatMap(invoice -> invoice.getInvoiceDetails().stream().map(invoiceDetail -> {
            ListInvoiceDto dto = new ListInvoiceDto();
            dto.setIssueDate(invoice.getIssueDate());  // Lấy ngày hóa đơn từ Invoice

            // Lấy thông tin sản phẩm từ InvoiceDetail
            Product product = invoiceDetail.getProduct();
            dto.setProductName(product.getProductName());  // Tên sản phẩm
            dto.setImage(product.getImages().stream().findFirst().orElse(null));  // Lấy hình ảnh đầu tiên của sản phẩm
            dto.setQuantity(invoiceDetail.getQuantity());  // Số lượng sản phẩm

            dto.setTotal(invoice.getTotal());  // Tổng tiền của hóa đơn
            return dto;
        })).collect(Collectors.toList());
    }
}
