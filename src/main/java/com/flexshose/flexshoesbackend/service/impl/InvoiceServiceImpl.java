package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.InvoiceDto;

import com.flexshose.flexshoesbackend.entity.Customer;

import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.mapper.InvoiceDetailMapper;
import com.flexshose.flexshoesbackend.mapper.InvoiceMapper;
import com.flexshose.flexshoesbackend.repository.CustomerRepository;
import com.flexshose.flexshoesbackend.repository.InvoiceDetailRepository;
import com.flexshose.flexshoesbackend.repository.InvoiceRepository;
import com.flexshose.flexshoesbackend.service.InvoiceDetailService;
import com.flexshose.flexshoesbackend.service.InvoiceService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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
    InvoiceMapper invoiceMapper;
    InvoiceDetailMapper invoiceDetailMapper;
    CustomerRepository customerRepository;
    InvoiceDetailService invoiceDetailService;


    @Override
    public InvoiceDto createInvoiceFormOrder(InvoiceDto invoiceDto) {
       
        Invoice invoice = invoiceMapper.toInvoice(invoiceDto);
        invoice.setOrderStatus("Processing");
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.toInvoiceDTO(savedInvoice);
    }

    @Override
    public List<InvoiceDto> getAllInvoice() {
        return invoiceRepository.findAll().stream()
                .map(item -> invoiceMapper.toInvoiceDTO(item))
                .collect(Collectors.toList());
    }

    public Invoice saveInvoice(InvoiceDto invoiceDto) {
		Invoice invoice = invoiceMapper.toInvoice(invoiceDto);
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
		return invoiceMapper.toInvoiceDTO(invoice);
	}

	@Override
	public List<InvoiceDto> getRecentInvoices() {
		 // Lấy tất cả hóa đơn, sắp xếp theo ngày phát hành giảm dần
        return invoiceRepository.findAll(Sort.by(Sort.Direction.DESC, "issueDate"))
                .stream()
                .map(item -> invoiceMapper.toInvoiceDTO(item))
                .toList();
	}

	@Override
	public long getTotalOrderCount() {
		// TODO Auto-generated method stub
		return invoiceRepository.count();
	}

	@Override
	public long getTotalShippingOrders() {
		// TODO Auto-generated method stub
		 return invoiceRepository.countByOrderStatus("Processing");
	}

	@Override
	public double getTotalAmount() {
		// TODO Auto-generated method stub
		return invoiceRepository.sumTotalAmount();
	}

	@Override
	public boolean updateInvoice(InvoiceDto invoiceDto) {
		try {
			
			Customer customer = customerRepository.findById(invoiceDto.getCustomerId()).get();
			Invoice invoice = invoiceMapper.toInvoice(invoiceDto);
			invoice.setCustomer(customer);
			invoiceRepository.save(invoice);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}


}
