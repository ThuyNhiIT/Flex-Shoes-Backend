package com.flexshose.flexshoesbackend.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;
import com.flexshose.flexshoesbackend.dto.InvoiceDto;
import com.flexshose.flexshoesbackend.dto.response.MyAPIResponse;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;
import com.flexshose.flexshoesbackend.mapper.InvoiceDetailMapper;
import com.flexshose.flexshoesbackend.service.InvoiceDetailService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoiceDetail")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InvoiceDetailController {
	InvoiceDetailService invoiceDetailService;
//	InvoiceDetailMapper invoiceDetailMapper;
	@PostMapping("/add")
	public List<InvoiceDetailDto> addInvoiceDetail(@RequestBody List<InvoiceDetailDto> invoiceDto) {
		List<InvoiceDetailDto> invoiceDetail = invoiceDto
				.stream()
				.map(item -> 
						invoiceDetailService.saveInvoiceDetail(item))
				.collect(Collectors.toList());
		return invoiceDetail;
	}
	@PutMapping("/update")
	public MyAPIResponse<List<InvoiceDetailDto>>  updateInvoiceDetail(@RequestBody List<InvoiceDetailDto> invoiceDto) {
		Integer invoiceId = invoiceDto.get(0).getInvoiceId();
		invoiceDetailService.deleteInvoiceDetail(invoiceId);
		List<InvoiceDetailDto> invoiceDetail = invoiceDto
				.stream()
				.map(item -> 
						invoiceDetailService.saveInvoiceDetail(item))
				.collect(Collectors.toList());
		return MyAPIResponse.<List<InvoiceDetailDto>>builder()
				.result(invoiceDetail)
				.build();
	}


}
