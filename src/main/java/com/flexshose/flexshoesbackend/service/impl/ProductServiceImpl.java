package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.ProductDto;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.mapper.ProductMapper;
import com.flexshose.flexshoesbackend.repository.ProductRepository;
import com.flexshose.flexshoesbackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;  // Thêm final ở đây

    @Override
    public ProductDto createProductDto(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    
    // searchProductsByName
	@Override
	public List<ProductDto> searchProductsByName(String name) {
		return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(product -> new ProductDto(
                        product.getProductId(),
                        product.getProductName(),
                        product.getOriginalPrice(),
                        product.getImages(),
                        product.getDescription()))
                .collect(Collectors.toList());
	}

}
