// src/main/java/com/flexshose/flexshoesbackend/controller/ProductDetailController.java

package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.ProductDetailDto;
import com.flexshose.flexshoesbackend.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product-detail")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    @Autowired
    public ProductDetailController(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailDto> getProductDetail(@PathVariable("id") int productId) {
        try {
            ProductDetailDto productDetail = productDetailService.getProductDetailById(productId);

            if (productDetail == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(productDetail, HttpStatus.OK);
        } catch (Exception e) {
            // Log lỗi khi không thể lấy chi tiết sản phẩm
            System.err.println("Error fetching product detail: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
