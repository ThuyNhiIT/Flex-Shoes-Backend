package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.ProductAdminDto;
import com.flexshose.flexshoesbackend.service.ProductAdminService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products/admin")
@AllArgsConstructor
public class ProductAdminController {

    private final ProductAdminService productAdminService;
    private static final Logger logger = LoggerFactory.getLogger(ProductAdminController.class);

    // Endpoint để lấy tất cả sản phẩm cho quản trị viên
    @GetMapping
    public ResponseEntity<List<ProductAdminDto>> getAllProducts() {
        try {
            logger.info("Đang lấy tất cả sản phẩm cho quản trị viên...");
            List<ProductAdminDto> productAdminDtos = productAdminService.getAllProductAdmin();

            // Kiểm tra nếu không có sản phẩm nào
            if (productAdminDtos.isEmpty()) {
                logger.info("Không có sản phẩm nào.");
                return new ResponseEntity<>(productAdminDtos, HttpStatus.NO_CONTENT);  // Trả về HTTP 204 nếu không có sản phẩm
            }

            return new ResponseEntity<>(productAdminDtos, HttpStatus.OK);  // Trả về HTTP 200 và danh sách sản phẩm
        } catch (Exception e) {
            logger.error("Lỗi khi lấy sản phẩm cho quản trị viên", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // Trả về HTTP 500 nếu có lỗi
        }
    }
}
