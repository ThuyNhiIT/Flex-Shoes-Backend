package com.flexshose.flexshoesbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.flexshose.flexshoesbackend.dto.CustomerDTO;
import com.flexshose.flexshoesbackend.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	CustomerDTO mapToCustomerDTO(Customer customer);
	
	Customer mapToCustomer(CustomerDTO customerDTO);
}
