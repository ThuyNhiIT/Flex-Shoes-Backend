package com.flexshose.flexshoesbackend.repository;

import com.flexshose.flexshoesbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductAdminRepository extends JpaRepository<Product, Integer> {
    // Tìm tất cả sản phẩm
    List<Product> findAll();
}
