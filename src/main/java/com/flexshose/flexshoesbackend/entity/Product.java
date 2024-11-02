package com.flexshose.flexshoesbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private double Price;
    private String description;
    private boolean status;
    private float discount;
    private int quantity;
    private boolean gender;

    @ElementCollection
    private Map<String, Integer> colors;

    @ElementCollection
    private Map<String, Integer> sizes;

    private double tax;
    private double salePrice;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<Image> images;

    // Add the missing field and mapping for ProductCategory
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private ProductCategory productCategory;

    // Add the missing field and mapping for Brand
    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;


}
