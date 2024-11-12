package com.flexshose.flexshoesbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "SIZE")
public class Size implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIZE_ID")
    private Integer sizeId;

    @Column(name = "SIZE_NAME")
    private String sizeName;
}
