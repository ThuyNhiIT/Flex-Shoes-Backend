package com.flexshose.flexshoesbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    private String imageName;
    private String url;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
