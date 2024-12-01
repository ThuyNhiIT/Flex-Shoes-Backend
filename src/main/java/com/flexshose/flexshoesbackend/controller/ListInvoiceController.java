package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.ListInvoiceDto;
import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.mapper.ListInvoiceMapper;
import com.flexshose.flexshoesbackend.service.ListInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/invoices")
public class ListInvoiceController {

    private final ListInvoiceService listInvoiceService;

    @Autowired
    public ListInvoiceController(ListInvoiceService listInvoiceService) {
        this.listInvoiceService = listInvoiceService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getInvoicesByCustomer(@PathVariable Integer customerId) {
        List<Invoice> invoices = listInvoiceService.getInvoicesByCustomerId(customerId);

        if (invoices == null || invoices.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of(
                    "message", "No invoices found for this customer.",
                    "customerId", customerId
            ));
        }

        // Sử dụng ListInvoiceMapper để chuyển đổi Invoice thành ListInvoiceDto
        List<ListInvoiceDto> invoiceDtos = ListInvoiceMapper.toListInvoiceDto(invoices);

        return ResponseEntity.ok(invoiceDtos);
    }
}
