package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.CustomersDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.flexshose.flexshoesbackend.dto.CustomersDTO;
import com.flexshose.flexshoesbackend.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomersDTO mapToCustomerDTO(Customer customer);

    Customer mapToCustomer(CustomersDTO customerDTO);
}
