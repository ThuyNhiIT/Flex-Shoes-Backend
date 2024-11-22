package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.InvoiceDto;
import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.mapper.InvoiceMapper;
import com.flexshose.flexshoesbackend.repository.InvoiceRepository;
import com.flexshose.flexshoesbackend.service.InvoiceService;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    
    
    @Override
    public InvoiceDto createInvoiceFormOrder(InvoiceDto invoiceDto) {
        //Chuyen doi InvoiceDto sang  entity Invoice
        Invoice invoice = InvoiceMapper.mapToInvoice(invoiceDto);
        invoice.setOrderStatus("Processing"); // Đặt trạng thái mặc định là Processing
        //Luu Invoice vao database
        Invoice savedInvoice = invoiceRepository.save(invoice);
        // Kiểm tra kết quả của savedInvoice trước khi ánh xạ lại
        // System.out.println("Invoice Saved: " + savedInvoice);
        // Lấy `invoiceId` tự phát sinh
        System.out.println("Generated Invoice ID: " + savedInvoice.getInvoiceId());
        //Chuyen doi Invoice vua luu thanh InvoiceDto de tra ve
        return InvoiceMapper.mapToInvoiceDto(savedInvoice);
    }

    @Override
    public List<InvoiceDto> getAllInvoice() {
        return invoiceRepository.findAll().stream()
                .map(InvoiceMapper::mapToInvoiceDto)
                .collect(Collectors.toList());
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

	@Override
	public List<InvoiceDto> getRecentInvoices() {
		// Lấy 10 hóa đơn gần nhất, sắp xếp theo ngày phát hành giảm dần
        return invoiceRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "issueDate")))
                .getContent()
                .stream()
                .map(InvoiceMapper::mapToInvoiceDto)
                .toList();
	}
}
