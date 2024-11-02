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
import org.springframework.beans.factory.annotation.Autowired;

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

}
