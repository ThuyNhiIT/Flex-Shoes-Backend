package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.ProductAdminDto;
import com.flexshose.flexshoesbackend.entity.*;
import com.flexshose.flexshoesbackend.mapper.ProductAdminMapper;
import com.flexshose.flexshoesbackend.repository.ProductAdminRepository;
import com.flexshose.flexshoesbackend.service.ProductAdminService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductAdminImpl implements ProductAdminService {

    private final ProductAdminRepository productAdminRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductAdminImpl.class);

    @Override
    public List<ProductAdminDto> getAllProductAdmin() {
        try {
            // Lấy tất cả sản phẩm mà không phân trang
            List<Product> products = productAdminRepository.findAll();

            // Nếu không có sản phẩm nào
            if (products.isEmpty()) {
                logger.info("Không có sản phẩm nào.");
                return List.of();  // Trả về danh sách trống
            }

            // Chuyển đổi từ Product entity sang ProductAdminDto
            return products.stream().map(product -> {
                Set<Quantity> quantities = product.getQuantities();
                Quantity quantity = (quantities != null && !quantities.isEmpty()) ? quantities.iterator().next() : null;

                // Lấy các thực thể liên quan
                Brand brand = product.getBrand();
                ProductCategory category = product.getProductCategory();

                return ProductAdminMapper.mapToProductAdminDto(product, quantity, brand, category);
            }).collect(Collectors.toList());

        } catch (Exception e) {
            logger.error("Lỗi khi lấy danh sách sản phẩm", e);
            throw new RuntimeException("Lỗi khi lấy danh sách sản phẩm", e);
        }
    }
}
