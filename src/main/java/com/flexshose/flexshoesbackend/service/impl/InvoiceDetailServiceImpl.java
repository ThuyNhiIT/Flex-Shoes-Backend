package com.flexshose.flexshoesbackend.service.impl;

import org.springframework.stereotype.Service;

import com.flexshose.flexshoesbackend.repository.InvoiceDetailRepository;
import com.flexshose.flexshoesbackend.service.InvoiceDetailService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
	InvoiceDetailRepository invoiceDetailRepository;

	@Override
	public boolean deleteInvoiceDetailById(Integer detailId) {
		if (invoiceDetailRepository.existsById(detailId)) {
			invoiceDetailRepository.deleteById(detailId);
			return true;
		} else {
			return false;
		}

	}

}
