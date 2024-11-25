package com.flexshose.flexshoesbackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flexshose.flexshoesbackend.dto.CustomerDTO;
import com.flexshose.flexshoesbackend.entity.Customer;
import com.flexshose.flexshoesbackend.mapper.CustomerMapper;
import com.flexshose.flexshoesbackend.repository.CustomerRepository;
import com.flexshose.flexshoesbackend.service.CustomerService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomerServiceImpl implements CustomerService {
	
	CustomerMapper customerMapper;
	CustomerRepository customerRepository;
	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		try {
			customer = customerMapper.mapToCustomer(customerDTO);
			customerRepository.save(customer);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Add customer failed!!");
		}
		return customerMapper.mapToCustomerDTO(customer);
		
	}

	@Override
	public CustomerDTO findByID(Integer id) {
		// TODO Auto-generated method stub
		CustomerDTO customerDTO = new CustomerDTO();
		try {
			Customer cus = customerRepository.findById(id).get();
			customerDTO = customerMapper.mapToCustomerDTO(cus);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Customer not found");
		}
		return customerDTO;
		}

	@Override
	public Customer update(CustomerDTO customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		customerRepository.deleteById(id);
		
	}

	@Override
	public List<CustomerDTO> findAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll().stream().map(cus ->  customerMapper.mapToCustomerDTO(cus)).toList();
	}

}
