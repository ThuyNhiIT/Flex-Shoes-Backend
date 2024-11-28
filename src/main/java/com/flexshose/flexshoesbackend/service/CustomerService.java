package com.flexshose.flexshoesbackend.service;


import com.flexshose.flexshoesbackend.dto.CustomersDTO;

import java.util.List;

public interface CustomerService {
    List<CustomersDTO> getAllCustomer();
    CustomersDTO save(CustomersDTO customersDTO);
    CustomersDTO findByID(Integer id);
    
}
