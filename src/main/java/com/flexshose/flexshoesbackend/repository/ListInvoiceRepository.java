package com.flexshose.flexshoesbackend.repository;

import com.flexshose.flexshoesbackend.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ListInvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findByCustomerCustomerId(Integer customerId);
}
