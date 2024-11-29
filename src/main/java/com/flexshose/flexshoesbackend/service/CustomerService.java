package com.flexshose.flexshoesbackend.service;


import com.flexshose.flexshoesbackend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomer();
    CustomerDTO save(CustomerDTO customersDTO);
    CustomerDTO findByID(Integer id);
    
}
