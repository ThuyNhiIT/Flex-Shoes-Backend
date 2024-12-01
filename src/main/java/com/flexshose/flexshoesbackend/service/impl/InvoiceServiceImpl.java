package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;
import com.flexshose.flexshoesbackend.dto.InvoiceDto;


import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.mapper.InvoiceMapper;
import com.flexshose.flexshoesbackend.repository.InvoiceDetailRepository;
import com.flexshose.flexshoesbackend.repository.InvoiceRepository;
import com.flexshose.flexshoesbackend.repository.ProductRepository;
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
	ProductRepository productRepository;
	InvoiceMapper invoiceMapper;



	@Override
	public InvoiceDto createInvoiceFormOrder(InvoiceDto invoiceDto) {

		Invoice invoice = invoiceMapper.toEntity(invoiceDto);
		Invoice invoice2 =  invoiceRepository.save(invoice);
		System.out.println("invoice2 === " + invoice2);
		if (invoice.getInvoiceDetails() != null) {
			for (InvoiceDetail detail : invoice.getInvoiceDetails()) {

				// Gán Product dựa trên productId từ DTO
				Product product = productRepository.findById(detail.getProduct().getProductId())
						.orElseThrow(() -> new RuntimeException("Product not found"));
				detail.setProduct(product);
				detail.setInvoice(invoice2);
			}
		}
		// Kiểm tra Product tồn tại cho từng InvoiceDetail
		for (InvoiceDetail detail : invoice.getInvoiceDetails()) {
			productRepository.findById(detail.getProduct().getProductId())
					.orElseThrow(() -> new RuntimeException("Product not found"));
		}



		return invoiceMapper.toDTO(invoiceRepository.save(invoice));
	}

	@Override
	public List<InvoiceDto> getAllInvoice() {
		return invoiceRepository.findAll().stream()
				.map(item -> invoiceMapper.toDTO(item))
				.collect(Collectors.toList());
	}



	@Override
	public Boolean updateOrderStatus(Integer invoiceId, String newStatus) {
		try {
			Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);
			if (optionalInvoice.isPresent()) {
				Invoice invoice = optionalInvoice.get();
				invoice.setOrderStatus(newStatus);
				invoiceRepository.save(invoice);
				return true;
			}else{
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
		return invoiceMapper.toDTO(invoice);
	}

	@Override
	public List<InvoiceDto> getRecentInvoices() {
		// Lấy tất cả hóa đơn, sắp xếp theo ngày phát hành giảm dần
		return invoiceRepository.findAll(Sort.by(Sort.Direction.DESC, "issueDate"))
				.stream()
				.map(item -> invoiceMapper.toDTO(item))
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
	public boolean updateInvoice(InvoiceDto invoiceDTO) {
		try {
			Integer invoiceId = invoiceDTO.getInvoiceId();
			Invoice invoice = invoiceRepository.findById(invoiceId)
					.orElseThrow(() -> new RuntimeException("Invoice not found"));

			// Cập nhật thông tin của Invoice từ DTO
			invoice.setIssueDate(invoiceDTO.getIssueDate());
			invoice.setReceiverNumber(invoiceDTO.getReceiverNumber());
			invoice.setReceiverName(invoiceDTO.getReceiverName());
			invoice.setReceiverAddress(invoiceDTO.getReceiverAddress());
			invoice.setPaymentMethod(invoiceDTO.getPaymentMethod());
			invoice.setDeliveryMethod(invoiceDTO.getDeliveryMethod());
			invoice.setOrderStatus(invoiceDTO.getOrderStatus());
			invoice.setTotal(invoiceDTO.getTotal());

			// Cập nhật các InvoiceDetails nếu có thay đổi
			if (invoiceDTO.getInvoiceDetails() != null) {
				for (InvoiceDetailDto detailDTO : invoiceDTO.getInvoiceDetails()) {
					// Kiểm tra nếu InvoiceDetail đã có hay chưa, nếu có thì cập nhật
					InvoiceDetail invoiceDetail = detailRepository.findById(detailDTO.getDetailId())
							.orElseThrow(() -> new RuntimeException("InvoiceDetail not found"));

					// Cập nhật thông tin của InvoiceDetail
					invoiceDetail.setQuantity(detailDTO.getQuantity());

					// Cập nhật Product nếu cần
					Product product = new Product(detailDTO.getProductId());
					invoiceDetail.setProduct(product);

					// Gán lại Invoice cho InvoiceDetail
					invoiceDetail.setInvoice(invoice);

					// Lưu lại InvoiceDetail
					detailRepository.save(invoiceDetail);
				}
			}
			invoiceRepository.save(invoice);
			// Lưu lại Invoice đã cập nhật
			return true ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}


	}


	@Override
	public List<InvoiceDto> searchInvoices(Integer id, String customerName, String orderStatus) {
		// TODO Auto-generated method stub
		return invoiceRepository.searchInvoices(id, customerName, orderStatus)
				.stream()
				.map(item -> invoiceMapper.toDTO(item))
				.toList();
	}

	public InvoiceDto saveInvoice(InvoiceDto invoiceDto) {
		Invoice invoice = invoiceMapper.toEntity(invoiceDto);

		if (invoice.getInvoiceDetails() != null) {
			for (InvoiceDetail detail : invoice.getInvoiceDetails()) {
				Product product = productRepository.findById(detail.getProduct().getProductId())
						.orElseThrow(() -> new RuntimeException("Product not found"));
				detail.setProduct(product);
				detail.setInvoice(invoice);
			}
		}

		for (InvoiceDetail detail : invoice.getInvoiceDetails()) {
			productRepository.findById(detail.getProduct().getProductId())
					.orElseThrow(() -> new RuntimeException("Product not found"));
		}



		return invoiceMapper.toDTO(invoiceRepository.save(invoice));
	}


}