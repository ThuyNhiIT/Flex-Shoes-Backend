package com.flexshose.flexshoesbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flexshose.flexshoesbackend.entity.Account;
import com.flexshose.flexshoesbackend.entity.Customer;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Optional<Account> findByUsername(String  userName);
	Customer findCustomerByUsername(String username);
}
