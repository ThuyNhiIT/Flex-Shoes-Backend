package com.flexshose.flexshoesbackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;
import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.mapper.InvoiceDetailMapper;
import com.flexshose.flexshoesbackend.repository.CustomerRepository;
import com.flexshose.flexshoesbackend.repository.InvoiceDetailRepository;
import com.flexshose.flexshoesbackend.repository.InvoiceRepository;
import com.flexshose.flexshoesbackend.repository.ProductRepository;
import com.flexshose.flexshoesbackend.service.InvoiceDetailService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InvoiceDetailServiceImpl implements InvoiceDetailService{
	InvoiceDetailRepository invoiceDetailRepository;
	InvoiceDetailMapper invoiceDetailMapper;
	ProductRepository productRepository;
	InvoiceRepository invoiceRepository;
	@Override
	public InvoiceDetailDto saveInvoiceDetail(InvoiceDetailDto invoiceDetailDto) {
		Product customer = productRepository.findById(invoiceDetailDto.getProductId()).get();
		Invoice invoice = invoiceRepository.findById(invoiceDetailDto.getInvoiceId()).get();
		InvoiceDetail invoiceDetail = invoiceDetailMapper.toInvoiceDetail(invoiceDetailDto);
		invoiceDetail.setProduct(customer);
		invoiceDetail.setInvoice(invoice);
		return invoiceDetailMapper.toInvoiceDetailDTO(invoiceDetailRepository.save(invoiceDetail));
	}
	@Override
	public List<InvoiceDetailDto> getInvoiceDetail(Integer invoiceId) {	
			// Lấy ra hóa đơn theo ID
		Invoice invoice = invoiceRepository.findById(invoiceId).get();
		List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.findDetailByInvoiceId(invoice);
		return invoiceDetails.stream().map(item -> invoiceDetailMapper.toInvoiceDetailDTO(item)).toList();
	}
	@Override
	public boolean updateInvoiceDetail(InvoiceDetailDto invoiceDetailDto) {
		// TODO Auto-generated method stub
		
		return false;
	}
	@Override
	public boolean deleteInvoiceDetail(Integer invoice) {
		Invoice i =  invoiceRepository.findById(invoice).orElseThrow(() -> new IllegalArgumentException("Invoice not found"));
		try {
			invoiceDetailRepository.deleteByInvoice(i);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<InvoiceDetailDto> getInvoiceDetailByInvoiceId(Integer invoiceId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}	
