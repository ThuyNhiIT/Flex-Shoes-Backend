package com.flexshose.flexshoesbackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.flexshose.flexshoesbackend.dto.CustomerDTO;
import com.flexshose.flexshoesbackend.dto.response.MyAPIResponse;
import com.flexshose.flexshoesbackend.service.CustomerService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomerController {
	
	CustomerService customerService;
	
	
	@PostMapping("/add")
	public MyAPIResponse<CustomerDTO>  register(@RequestBody CustomerDTO customerDTO) {
		  MyAPIResponse<CustomerDTO> result = new MyAPIResponse<CustomerDTO>();
	        result.setResult(customerService.save(customerDTO));
		return result;
		
	}
	@GetMapping("/findByID/{id}")
	public CustomerDTO findByID(@PathVariable Integer id) {
		return customerService.findByID(id);
	}
	@GetMapping("/getAll")
	public List<CustomerDTO> getMethodName() {
		return customerService.findAllCustomer();
	}
	
}
