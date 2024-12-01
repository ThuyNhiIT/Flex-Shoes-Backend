	package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;
import com.flexshose.flexshoesbackend.dto.InvoiceDto;
import com.flexshose.flexshoesbackend.dto.response.MyAPIResponse;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;
import com.flexshose.flexshoesbackend.mapper.InvoiceDetailMapper;
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

	// Tạo hóa đơn mới
//    @PostMapping
//    public ResponseEntity<Map<String, Object>> createInvoice(@RequestBody InvoiceDto invoiceDto) {
//        Invoice invoice = InvoiceMapper.mapToInvoice(invoiceDto);
//        invoice.setOrderStatus("Processing"); // Đặt trạng thái mặc định là Processing
//        Invoice savedInvoice = invoiceService.saveInvoice(invoice);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("id", savedInvoice.getInvoiceId());
//        response.put("orderStatus", savedInvoice.getOrderStatus());
//        response.put("message", "Invoice created successfully");
//
//        return ResponseEntity.ok(response);
//    }

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

//	@GetMapping("/findDetailById/{id}")
//	public MyAPIResponse<List<InvoiceDetailDto>> findDetailByID(@PathVariable Integer id) {
//		List<InvoiceDetail> list = invoiceService.getInvoiceDetail(id);
//		List<InvoiceDetailDto> listDto = list.stream().map(item -> detailMapper.toInvoiceDetailDTO(item)).toList();
//		return MyAPIResponse.<List<InvoiceDetailDto>>builder().result(listDto).build();
//	}

    
    
//    @GetMapping("/recent")
//    public ResponseEntity<List<InvoiceDto>> getRecentInvoices() {
//        List<InvoiceDto> recentInvoices = invoiceService.getRecentInvoices();
//        return ResponseEntity.ok(recentInvoices);
//    }
//    
// // Trả về tổng số đơn đặt hàng
//    @GetMapping("/total")
//    public ResponseEntity<Long> getTotalOrderCount() {
//        long totalOrders = invoiceService.getTotalOrderCount();
//        return ResponseEntity.ok(totalOrders);
//    }
//
//    // Trả về tổng số đơn đang vận chuyển (Processing)
//    @GetMapping("/shipping")
//    public ResponseEntity<Long> getTotalShippingOrders() {
//        long totalShipping = invoiceService.getTotalShippingOrders();
//        return ResponseEntity.ok(totalShipping);
//    }
//
//    // Trả về tổng số tiền của tất cả các hóa đơn
//    @GetMapping("/total-amount")
//    public ResponseEntity<Double> getTotalAmount() {
//        double totalAmount = invoiceService.getTotalAmount();
//        return ResponseEntity.ok(totalAmount);
//    }
	
	@GetMapping("/search")
	public ResponseEntity<List<InvoiceDto>> searchInvoices(
	        @RequestParam(required = false) Integer id,
	        @RequestParam(required = false) String customerName,
	        @RequestParam(required = false) String orderStatus) {
	    List<InvoiceDto> invoices = invoiceService.searchInvoices(id, customerName, orderStatus);
	    return ResponseEntity.ok(invoices);
	}

}

