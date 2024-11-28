package com.flexshose.flexshoesbackend.repository;

import com.flexshose.flexshoesbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
