package com.flexshose.flexshoesbackend.repository;

import com.flexshose.flexshoesbackend.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
