package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.CustomerDto;
import com.flexshose.flexshoesbackend.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer.getCustomerId());
        return customerDto;

    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());

        return customer;
    }
}
