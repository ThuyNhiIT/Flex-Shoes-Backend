package com.flexshose.flexshoesbackend.service;

import java.util.List;

import com.flexshose.flexshoesbackend.dto.CustomerDTO;
import com.flexshose.flexshoesbackend.entity.Customer;

public interface CustomerService {
	public CustomerDTO save(CustomerDTO customer);
	public CustomerDTO findByID(Integer id);
	public Customer update(CustomerDTO customer);
	public void delete(Integer id);
	public List<CustomerDTO> findAllCustomer();
	
}
