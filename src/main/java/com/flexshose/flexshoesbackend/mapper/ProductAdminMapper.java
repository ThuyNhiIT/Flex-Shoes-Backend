package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.ProductAdminDto;
import com.flexshose.flexshoesbackend.entity.*;

import java.util.List;
import java.util.Set;

public class ProductAdminMapper {

    // Phương thức chuyển đổi Product thành ProductAdminDto
    public static ProductAdminDto mapToProductAdminDto(Product product, Quantity quantity, Brand brand, ProductCategory productCategory) {
        ProductAdminDto productAdminDto = new ProductAdminDto();
        productAdminDto.setProductId(product.getProductId());
        productAdminDto.setProductName(product.getProductName());
        productAdminDto.setOriginalPrice(product.getOriginalPrice());
        productAdminDto.setSalePrice(product.getSalePrice());
        productAdminDto.setDescription(product.getDescription());

        // Nếu quantity là null, set mặc định là 0
        productAdminDto.setQuantity(quantity != null ? quantity.getQuantity() : 0);

        // Xử lý trường hợp Brand và Category null
        productAdminDto.setBrandName(brand != null ? brand.getBrandName() : "Unknown");
        productAdminDto.setCategoryName(productCategory != null ? productCategory.getCategoryName() : "Unknown");

        // Xử lý ảnh (nếu null, sử dụng danh sách trống)
        productAdminDto.setImages(product.getImages() != null ? product.getImages() : Set.of());

        // Tính giá cuối cùng
        double finalPrice = (product.getOriginalPrice() - (product.getOriginalPrice() * product.getSalePrice() / 100)) * (1 + product.getVat() / 100);
        finalPrice = Math.round(finalPrice * 100.0) / 100.0; // Làm tròn 2 chữ số thập phân
        productAdminDto.setFinalPrice(finalPrice);

        return productAdminDto;
    }
}
