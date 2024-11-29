package com.flexshose.flexshoesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.flexshose.flexshoesbackend.entity.InvoiceDetail;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
	boolean existsById(Integer invoice);

}
