package com.flexshose.flexshoesbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;

@Mapper(componentModel = "spring")
public interface InvoiceDetailMapper {
	
	@Mapping(source = "invoiceDetail.invoice.invoiceId", target = "invoiceId")
	@Mapping(source = "invoiceDetail.product.productId", target = "productId")
	@Mapping(source = "invoiceDetail.product.productName", target = "productName")
	@Mapping(source = "invoiceDetail.product.salePrice", target = "salePrice")
	InvoiceDetailDto toInvoiceDetailDTO(InvoiceDetail invoiceDetail);

}
