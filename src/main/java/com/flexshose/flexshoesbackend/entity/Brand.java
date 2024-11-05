package com.flexshose.flexshoesbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BRAND")
public class Brand implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "BRAND_ID", columnDefinition = "nvarchar(55)")
    private String brandId;

    @Column(name = "BRAND_NAME", columnDefinition = "nvarchar(55)")
    private String brandName;

    @Column(name = "DESCRIPTION", columnDefinition = "nvarchar(255)")
    private String description;
}