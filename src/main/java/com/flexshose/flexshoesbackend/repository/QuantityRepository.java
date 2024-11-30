package com.flexshose.flexshoesbackend.repository;

import com.flexshose.flexshoesbackend.entity.Color;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.entity.Quantity;
import com.flexshose.flexshoesbackend.entity.Size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Integer> {
    	List<Quantity> findByProduct(Product product);
    	//Update quantity of product by product id, color id, size id
    	Quantity findByProductAndColorAndSize(Product product, Color color, Size size);
    	
}
