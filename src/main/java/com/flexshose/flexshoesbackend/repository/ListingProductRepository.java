package com.flexshose.flexshoesbackend.repository;

import com.flexshose.flexshoesbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingProductRepository extends JpaRepository<Product,Integer> {

}
