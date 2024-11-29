package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;
import com.flexshose.flexshoesbackend.dto.InvoiceDto;
import com.flexshose.flexshoesbackend.dto.response.MyAPIResponse;
import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;
import com.flexshose.flexshoesbackend.mapper.InvoiceDetailMapper;
import com.flexshose.flexshoesbackend.mapper.InvoiceMapper;
import com.flexshose.flexshoesbackend.service.InvoiceDetailService;
import com.flexshose.flexshoesbackend.service.InvoiceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/invoices")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class InvoiceController {
	InvoiceService invoiceService;
	InvoiceDetailMapper detailMapper;
	InvoiceMapper invoiceMapper;
	InvoiceDetailService detailService;

	// Lay all hoa don
	@GetMapping
	public List<InvoiceDto> getAllInvoices() {
		List<InvoiceDto> invoices = invoiceService.getAllInvoice();
		return new ResponseEntity<>(invoices, HttpStatus.OK).getBody();
	}

	// API để tạo mới hóa đơn (POST /api/invoices)
//    @PostMapping
//    public ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDto) {
//        InvoiceDto createdInvoice = invoiceService.createInvoiceFormOrder(invoiceDto);
//        // Kiểm tra ID trước khi trả về
//        System.out.println("Invoice ID sent to client: " + createdInvoice.getInvoiceId());
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoice);
//    }

//	 Tạo hóa đơn mới
    @PostMapping("/add")
    public ResponseEntity<Invoice> createInvoice1(@RequestBody InvoiceDto invoiceDto) {
        Invoice invoice = invoiceService.saveInvoice(invoiceDto);
        return ResponseEntity.ok(invoice);
    }

	@PostMapping
	public ResponseEntity<Map<String, Object>> createInvoice(@RequestBody InvoiceDto invoiceDto) {
		InvoiceDto createdInvoice = invoiceService.createInvoiceFormOrder(invoiceDto);
		System.out.println("Generated Invoice ID: " + createdInvoice.getInvoiceId());
		Map<String, Object> response = new HashMap<>();
		response.put("id", createdInvoice.getInvoiceId());
		return ResponseEntity.ok(response);


	}

	@GetMapping("/recent")
	public ResponseEntity<List<InvoiceDto>> getRecentInvoices() {
		List<InvoiceDto> recentInvoices = invoiceService.getRecentInvoices();
		return ResponseEntity.ok(recentInvoices);
	}

	// Trả về tổng số đơn đặt hàng
	@GetMapping("/total")
	public ResponseEntity<Long> getTotalOrderCount() {
		long totalOrders = invoiceService.getTotalOrderCount();
		return ResponseEntity.ok(totalOrders);
	}

	// Trả về tổng số đơn đang vận chuyển (Processing)
	@GetMapping("/shipping")
	public ResponseEntity<Long> getTotalShippingOrders() {
		long totalShipping = invoiceService.getTotalShippingOrders();
		return ResponseEntity.ok(totalShipping);
	}

	// Trả về tổng số tiền của tất cả các hóa đơn
	@GetMapping("/total-amount")
	public ResponseEntity<Double> getTotalAmount() {
		double totalAmount = invoiceService.getTotalAmount();
		return ResponseEntity.ok(totalAmount);
	}

	@GetMapping("/findById/{id}")
	public MyAPIResponse<InvoiceDto> findByID(@PathVariable Integer id) {
		return MyAPIResponse.<InvoiceDto>builder().result(invoiceService.getInvoice(id)).build();
	}

	@GetMapping("/findDetailById/{id}")
	public MyAPIResponse<List<InvoiceDetailDto>> findDetailByID(@PathVariable Integer id) {
		List<InvoiceDetailDto> list = detailService.getInvoiceDetail(id);
		return MyAPIResponse.<List<InvoiceDetailDto>>builder().result(list).build();
	}
	@PutMapping("/updateInvoice")
	public MyAPIResponse<Boolean> updateInvoice(@RequestBody InvoiceDto invoiceDto) {
		return MyAPIResponse.<Boolean>builder().result(invoiceService.updateInvoice(invoiceDto)).build();
	}

 
}

