package com.flexshose.flexshoesbackend.dto;

import com.flexshose.flexshoesbackend.entity.Color;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.entity.Size;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuantityDto {

    private int id;
//    @JsonIgnore
    private Product product;
    private Color color;
    private Size size;
    private int quantity;







}
