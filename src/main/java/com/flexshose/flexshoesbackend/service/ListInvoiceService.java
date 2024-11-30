package com.flexshose.flexshoesbackend.service;

import com.flexshose.flexshoesbackend.entity.Invoice;
import java.util.List;

public interface ListInvoiceService {
    List<Invoice> getInvoicesByCustomerId(Integer customerId);
}
