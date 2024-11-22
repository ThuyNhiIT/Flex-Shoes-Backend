package com.flexshose.flexshoesbackend.repository;

import com.flexshose.flexshoesbackend.entity.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Integer> {
    List<Quantity> findByProduct_productId(Integer productId);  // Correct query method
}
