package com.flexshose.flexshoesbackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flexshose.flexshoesbackend.entity.ProductCategory;
import com.flexshose.flexshoesbackend.repository.ProductCategoryRepository;
import com.flexshose.flexshoesbackend.service.ProductCategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService{
	private final ProductCategoryRepository productCategoryRepository;
	@Override
	public List<ProductCategory> getAllProductCategories() {
		// TODO Auto-generated method stub
		return productCategoryRepository.findAll();
	}

}
