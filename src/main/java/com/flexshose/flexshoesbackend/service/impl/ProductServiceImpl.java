package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.AddProductDto;
import com.flexshose.flexshoesbackend.dto.ProductDTOv2;
import com.flexshose.flexshoesbackend.dto.ProductDto;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.mapper.AddProductMapper;
import com.flexshose.flexshoesbackend.mapper.ProductMapper;
import com.flexshose.flexshoesbackend.mapper.ProductMapperv2;
import com.flexshose.flexshoesbackend.repository.ProductRepository;
import com.flexshose.flexshoesbackend.service.ProductService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {

	ProductRepository productRepository;
	ProductMapperv2 productMapper;

	@Override
	public AddProductDto createProductDto(AddProductDto addProductDto) {
		Product product = AddProductMapper.toProduct(addProductDto);
		Product savedProduct = productRepository.save(product);
		System.out.println("savedProduct: " + savedProduct);
		return AddProductMapper.toAddProductDto(savedProduct);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		return productRepository.findAll().stream().map(ProductMapper::mapToProductDto).collect(Collectors.toList());
	}

	// searchProductsByName
	@Override
	public List<ProductDto> searchProductsByName(String name) {
		return productRepository.findByNameContainingIgnoreCase(name).stream()
				.map(product -> new ProductDto(product.getProductId(), product.getProductName(),
						product.getOriginalPrice(), product.getImages(), product.getDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDTOv2 getProductById(Integer productId) {
		return productRepository.findByProductId(productId) != null
				? productMapper.toDto(productRepository.findByProductId(productId))
				: null;
	}

	@Override
	public ProductDTOv2 updateProduct(ProductDTOv2 productDto) {
		// TODO Auto-generated method stub
		try {
			Product product = productMapper.toEntity(productDto);
			productRepository.save(product);
			return productMapper.toDto(product);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Update product failed");
		}

	}

	@Override
	public Boolean deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		try {
			productRepository.deleteById(productId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
