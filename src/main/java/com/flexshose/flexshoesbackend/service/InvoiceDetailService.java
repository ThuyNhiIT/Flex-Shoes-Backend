package com.flexshose.flexshoesbackend.service;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;
import com.flexshose.flexshoesbackend.entity.Invoice;

import java.util.List;

public interface  InvoiceDetailService {

	InvoiceDetailDto saveInvoiceDetail(InvoiceDetailDto invoiceDetailDto);

	List<InvoiceDetailDto> getInvoiceDetail(Integer invoiceId);

	boolean updateInvoiceDetail(InvoiceDetailDto invoiceDetailDto);

	boolean deleteInvoiceDetail(Integer invoice);

	List<InvoiceDetailDto> getInvoiceDetailByInvoiceId(Integer invoiceId);
}
