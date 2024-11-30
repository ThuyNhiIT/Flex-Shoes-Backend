package com.flexshose.flexshoesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexshose.flexshoesbackend.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Integer> {
	Size findBySizeName(String name);
}
