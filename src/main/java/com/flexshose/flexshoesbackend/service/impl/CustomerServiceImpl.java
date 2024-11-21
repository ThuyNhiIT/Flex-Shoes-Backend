package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.CustomerDto;
import com.flexshose.flexshoesbackend.mapper.CustomerMapper;
import com.flexshose.flexshoesbackend.repository.CustomerRepository;
import com.flexshose.flexshoesbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public List<CustomerDto> getAllCustomer() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::mapToCustomerDto)
                .collect(Collectors.toList());
    }
}
