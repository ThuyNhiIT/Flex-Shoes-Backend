package com.flexshose.flexshoesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flexshose.flexshoesbackend.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
	Brand findByBrandName(String name);
}
