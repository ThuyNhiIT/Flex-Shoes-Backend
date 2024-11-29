package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.InvoiceDto;
import com.flexshose.flexshoesbackend.entity.Invoice;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface InvoiceMapper {
	//Bo qua invoiceDetails va customer
	@Mapping(ignore = true, target = "invoiceDetails")
	@Mapping(target = "customerId", source = "customer.customerId")
	InvoiceDto toInvoiceDTO(Invoice invoice);
	
	//Cho cusotomerId thanh object customer va invoiceDetails la null
    @Mapping(target = "customer.customerId", source = "customerId")
    @Mapping(ignore = true, target = "invoiceDetails")
	Invoice toInvoice(InvoiceDto invoiceDto);
	
}
