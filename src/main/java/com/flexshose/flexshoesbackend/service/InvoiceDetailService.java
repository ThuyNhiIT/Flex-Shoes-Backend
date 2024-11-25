package com.flexshose.flexshoesbackend.service;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;

import java.util.List;

public interface  InvoiceDetailService {
    InvoiceDetailDto createInvoiceDetail(InvoiceDetailDto invoiceDetailDto);
    List<InvoiceDetailDto> getAllInvoiceDetail();
}
