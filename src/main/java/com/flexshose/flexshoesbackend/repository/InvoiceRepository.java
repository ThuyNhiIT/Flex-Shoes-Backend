package com.flexshose.flexshoesbackend.repository;

import com.flexshose.flexshoesbackend.entity.Invoice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	
	long count(); // Trả về tổng số đơn đặt hàng

    long countByOrderStatus(String status); // Trả về tổng số đơn đang vận chuyển (trạng thái "Processing")

    @Query("SELECT SUM(i.total) FROM Invoice i") // Trả về tổng tiền của tất cả các hóa đơn
    double sumTotalAmount();
    
    @Query("SELECT i FROM Invoice i " +
            "LEFT JOIN i.customer c " +
            "WHERE " +
            "(:id IS NULL OR CAST(i.invoiceId AS string) LIKE CONCAT('%', :id, '%')) AND " +
            "(:customerName IS NULL OR LOWER(c.customerName) LIKE LOWER(CONCAT('%', :customerName, '%'))) AND " +
            "(:orderStatus IS NULL OR LOWER(i.orderStatus) LIKE LOWER(CONCAT('%', :orderStatus, '%')))")
    List<Invoice> searchInvoices(
            @Param("id") Integer id,
            @Param("customerName") String customerName,
            @Param("orderStatus") String orderStatus);

}
