package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.repository.ListInvoiceRepository;
import com.flexshose.flexshoesbackend.service.ListInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ListInvoiceImpl implements ListInvoiceService {

    private final ListInvoiceRepository listInvoiceRepository;

    @Autowired
    public ListInvoiceImpl(ListInvoiceRepository listInvoiceRepository) {
        this.listInvoiceRepository = listInvoiceRepository;
    }

    /**
     * Get invoices by customer ID.
     *
     * @param customerId The ID of the customer.
     * @return List of invoices, or an empty list if none are found.
     * @throws IllegalArgumentException if customerId is null.
     */
    @Override
    public List<Invoice> getInvoicesByCustomerId(Integer customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }

        List<Invoice> invoices = listInvoiceRepository.findByCustomerCustomerId(customerId);

        // Return an empty list if no invoices are found
        return invoices != null ? invoices : Collections.emptyList();
    }
}
