package com.flexshose.flexshoesbackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flexshose.flexshoesbackend.entity.Brand;
import com.flexshose.flexshoesbackend.repository.BrandRepository;
import com.flexshose.flexshoesbackend.service.BrandService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
	private final BrandRepository brandRepository;
	@Override
	public List<Brand> getAllBrands() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}
	
}
