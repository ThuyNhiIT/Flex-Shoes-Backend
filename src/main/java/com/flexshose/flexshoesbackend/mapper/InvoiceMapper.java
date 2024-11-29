package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.InvoiceDto;
import com.flexshose.flexshoesbackend.entity.Customer;
import com.flexshose.flexshoesbackend.entity.Invoice;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring", uses = {CustomerMapper.class, InvoiceDetailMapper.class})
public interface InvoiceMapper {
	
	 // Ánh xạ từ DTO sang Entity
    @Mapping(target = "customer", source = "customerId", qualifiedByName = "mapCustomerIdToCustomer")
    @Mapping(target = "invoiceDetails", source = "invoiceDetails")
    Invoice toEntity(InvoiceDto invoiceDTO);

    // Ánh xạ từ Entity sang DTO
    @Mapping(target = "customerId", source = "customer.customerId")
    
    InvoiceDto toDTO(Invoice invoice);

    List<Invoice> toEntities(List<InvoiceDto> invoiceDTOs);

    List<InvoiceDto> toDTOs(List<Invoice> invoices);

    // Ánh xạ ID sang Customer entity
    @Named("mapCustomerIdToCustomer")
    static Customer mapCustomerIdToCustomer(Integer customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        return customer;
    }
	
}
