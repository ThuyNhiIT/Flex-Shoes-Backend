// src/main/java/com/flexshose/flexshoesbackend/service/impl/ProductDetailServiceImpl.java

package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.ProductDetailDto;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.mapper.ProductDetailMapper;
import com.flexshose.flexshoesbackend.repository.ProductRepository;
import com.flexshose.flexshoesbackend.service.ProductDetailService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductDetailServiceImpl.class);

    @Override
    public ProductDetailDto getProductDetailById(int id) {
        try {
            Product product = productRepository.findByProductId(id);

            if (product == null) {
                return null;
            }

            return ProductDetailMapper.mapToProductDetailDto(product);
        } catch (Exception e) {
            logger.error("Error fetching product with id: {}", id, e);
            throw new RuntimeException("Error fetching product details", e);
        }
    }
}
