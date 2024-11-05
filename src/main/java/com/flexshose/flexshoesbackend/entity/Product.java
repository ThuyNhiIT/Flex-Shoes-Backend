package com.flexshose.flexshoesbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    // Fields
    private static final long serialVersionUID = 8124213137126012314L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", columnDefinition = "int", updatable = false, insertable = false)
    private Integer productId;

    @Column(name = "PRODUCT_NAME", columnDefinition = "nvarchar(55)")
    private String productName;

    @Column(name = "DESCRIPTION", columnDefinition = "nvarchar(255)")
    private String description;

    @Column(name = "ORIGINAL_PRICE")
    private double originalPrice;

    @Column(name = "STATUS", columnDefinition = "nvarchar(25)")
    private String status;

    @Column(name = "SALE_PRICE")
    private double salePrice;

    @Column(name = "VAT")
    private double vat;

    @ElementCollection
    @CollectionTable(name = "IMAGES", joinColumns = @JoinColumn(name = "PRODUCT_ID"))
    @Column(name = "IMAGE")
    private Set<String> images;

    // Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = true)
    private ProductCategory productCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID", nullable = true)
    private Brand brand;
}
