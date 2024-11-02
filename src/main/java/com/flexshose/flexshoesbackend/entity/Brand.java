package com.flexshose.flexshoesbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;
    private String brandName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
