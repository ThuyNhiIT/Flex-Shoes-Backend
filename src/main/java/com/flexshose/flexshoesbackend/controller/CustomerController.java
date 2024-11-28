package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.CustomerDto;
import com.flexshose.flexshoesbackend.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

     //API để lấy tất cả khách hàng (GET /api/customers)
     @GetMapping
     public List<CustomerDto> getAllCustomers() {
         List<CustomerDto> customers = customerService.getAllCustomer();
         return new ResponseEntity<>(customers, HttpStatus.OK).getBody();
     }



}
