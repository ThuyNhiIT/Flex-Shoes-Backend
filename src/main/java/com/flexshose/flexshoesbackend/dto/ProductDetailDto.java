package com.flexshose.flexshoesbackend.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {
        private Integer productId;
        private String productName;
        private String description;
        private double originalPrice;
        private double salePrice;
        private double finalPrice;
        private String status;
        private List<String> images;
        private List<ColorDto> colors;
        private List<SizeDto> sizes;
}

