package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.CustomerDto;
import com.flexshose.flexshoesbackend.dto.CustomersDTO;
import com.flexshose.flexshoesbackend.dto.response.MyAPIResponse;
import com.flexshose.flexshoesbackend.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/public/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

     //API để lấy tất cả khách hàng (GET /api/customers)
     @GetMapping
     public List<CustomersDTO> getAllCustomers() {
         List<CustomersDTO> customers = customerService.getAllCustomer();
         return new ResponseEntity<>(customers, HttpStatus.OK).getBody();
     }
    @PostMapping("/add")
    public MyAPIResponse<CustomersDTO> register(@RequestBody CustomersDTO customerDTO) {
        MyAPIResponse<CustomersDTO> result = new MyAPIResponse<CustomersDTO>();
        result.setResult(customerService.save(customerDTO));
        return result;

    }
    @GetMapping("/findByID/{id}")
    public CustomersDTO findByID(@PathVariable Integer id) {
        return customerService.findByID(id);
    }


}
