package com.flexshose.flexshoesbackend.service;

import com.flexshose.flexshoesbackend.dto.ProductAdminDto;

import java.util.List;

public interface ProductAdminService {

    // Phương thức lấy tất cả sản phẩm
    List<ProductAdminDto> getAllProductAdmin();
}
