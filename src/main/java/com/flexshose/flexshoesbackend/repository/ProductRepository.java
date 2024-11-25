package com.flexshose.flexshoesbackend.repository;

import com.flexshose.flexshoesbackend.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	//Search products by name
	@Query("SELECT p FROM Product p WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :productName, '%'))")
    List<Product> findByNameContainingIgnoreCase(String productName);

    // Tìm sản phẩm theo ID
    Product findByProductId(Integer productId);

    // Bạn có thể thêm các phương thức tìm kiếm khác nếu cần, ví dụ:
    // Tìm sản phẩm theo tên sản phẩm (chứa từ khóa)
    List<Product> findByProductNameContaining(String productName);
}
