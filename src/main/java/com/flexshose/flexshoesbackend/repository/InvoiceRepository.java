package com.flexshose.flexshoesbackend.repository;

import com.flexshose.flexshoesbackend.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	
	long count(); // Trả về tổng số đơn đặt hàng

    long countByOrderStatus(String status); // Trả về tổng số đơn đang vận chuyển (trạng thái "Processing")

    @Query("SELECT SUM(i.total) FROM Invoice i") // Trả về tổng tiền của tất cả các hóa đơn
    double sumTotalAmount();
    
    
}
