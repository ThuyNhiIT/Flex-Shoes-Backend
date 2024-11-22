package com.flexshose.flexshoesbackend.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDto {
    private Integer id;
    private Integer productId;
    private Integer colorId;
    private Integer sizeId;
    private int quantity;
}
