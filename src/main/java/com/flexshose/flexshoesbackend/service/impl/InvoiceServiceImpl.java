package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;
import com.flexshose.flexshoesbackend.dto.InvoiceDto;

import com.flexshose.flexshoesbackend.entity.CompositeKey;

import com.flexshose.flexshoesbackend.entity.Customer;

import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;
import com.flexshose.flexshoesbackend.mapper.InvoiceDetailMapper;
import com.flexshose.flexshoesbackend.mapper.InvoiceMapper;
import com.flexshose.flexshoesbackend.repository.InvoiceDetailRepository;
import com.flexshose.flexshoesbackend.repository.InvoiceRepository;
import com.flexshose.flexshoesbackend.service.InvoiceService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InvoiceServiceImpl implements InvoiceService {

    InvoiceRepository invoiceRepository;
    InvoiceDetailRepository detailRepository;


    @Override
    public InvoiceDto createInvoiceFormOrder(InvoiceDto invoiceDto) {
        //Chuyen doi InvoiceDto sang  entity Invoice
        Invoice invoice = InvoiceMapper.mapToInvoice(invoiceDto);
        invoice.setOrderStatus("Processing");
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
    public Boolean updateOrderStatus(Integer invoiceId, String newStatus) {
        try {
            Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);
            if (optionalInvoice.isPresent()) {
                Invoice invoice = optionalInvoice.get();
                invoice.setOrderStatus(newStatus);//Cap nhat trang thai don hang
                invoiceRepository.save(invoice);//Luu lai vao database
                System.out.println("Order ID " + invoiceId + " updated to status: " + newStatus);
                return true;
            }else{
                System.out.println("Invoice ID " + invoiceId + " not found.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public InvoiceDto getInvoice(Integer id) {
		// TODO Auto-generated method stub
		Invoice invoice = invoiceRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Invoice with ID " + id + " not found")
				);
		return InvoiceMapper.mapToInvoiceDto(invoice);
	}

	@Override
	public List<InvoiceDetail> getInvoiceDetail(Integer invoiceId) {	
			// Lấy ra hóa đơn theo ID
		Invoice invoice = invoiceRepository.findById(invoiceId).get();
		return detailRepository.findDetailByInvoiceId(invoice);
	}

	@Override
	public List<InvoiceDto> getRecentInvoices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalOrderCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTotalShippingOrders() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
