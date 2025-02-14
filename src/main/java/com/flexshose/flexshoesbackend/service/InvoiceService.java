package com.flexshose.flexshoesbackend.service;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;
import com.flexshose.flexshoesbackend.dto.InvoiceDto;
import com.flexshose.flexshoesbackend.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    InvoiceDto createInvoiceFormOrder(InvoiceDto invoiceDto);

    List<InvoiceDto> getAllInvoice();

    InvoiceDto saveInvoice(InvoiceDto invoice);

    List<InvoiceDto> getRecentInvoices();

    long getTotalOrderCount();

    long getTotalShippingOrders();

    double getTotalAmount();

    InvoiceDto getInvoice(Integer id);

    Boolean updateOrderStatus(Integer invoiceId, String newStatus);

    boolean updateInvoice(InvoiceDto invoiceDto);

    List<InvoiceDto> searchInvoices(Integer id, String customerName, String orderStatus);

}