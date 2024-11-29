package com.flexshose.flexshoesbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flexshose.flexshoesbackend.entity.Invoice;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
	@Query("SELECT d FROM InvoiceDetail d WHERE d.invoice = :invoice")
	List<InvoiceDetail> findDetailByInvoiceId(Invoice invoice);
	
	boolean existsByInvoice(Invoice invoice);
	boolean existsByInvoiceAndProductProductId(Invoice invoice, Integer productId);
	
	@Query("SELECT d FROM InvoiceDetail d WHERE d.invoice = :invoice")
	void deleteByInvoice(Invoice invoice);
}
