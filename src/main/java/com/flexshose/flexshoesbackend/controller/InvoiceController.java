package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.InvoiceDto;
import com.flexshose.flexshoesbackend.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private InvoiceService invoiceService;

public InvoiceController(InvoiceService invoiceService) {
    this.invoiceService = invoiceService;
    }

    //Lay all hoa don
    @GetMapping
    public List<InvoiceDto> getAllInvoices() {
        List<InvoiceDto> invoices = invoiceService.getAllInvoice();
        return new ResponseEntity<>(invoices, HttpStatus.OK).getBody();
    }

    // API để tạo mới hóa đơn (POST /api/invoices)
    @PostMapping
    public ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDto) {
        InvoiceDto createdInvoice = invoiceService.createInvoiceFormOrder(invoiceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoice);
    }

}
