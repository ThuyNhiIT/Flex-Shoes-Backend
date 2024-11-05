package com.flexshose.flexshoesbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PRODUCT_CATEGORY")

public class ProductCategory implements Serializable {
    /**
     *
     */


    @Id
    @Column(name = "CATEGORY_ID", columnDefinition = "nvarchar(55)")
    private String categoryId;

    @Column(name = "CATEGORY_NAME", columnDefinition = "nvarchar(55)")
    @NotNull(message = "Category name cannot be empty")
    private String categoryName;

    @Column(name = "DESCRIPTION", columnDefinition = "nvarchar(255)")
    private String description;
}

